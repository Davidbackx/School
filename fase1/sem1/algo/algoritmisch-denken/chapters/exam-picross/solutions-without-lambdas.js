function removeLeadingWhite(ns)
{
    ns = [...ns];

    while ( ns.length > 0 && ns[0] === 0 )
    {
        ns.shift();
    }

    return ns;
}

function removeLeadingBlack(ns)
{
    ns = [...ns];
    let count = 0;

    while ( ns.length > 0 && ns[0] === 1 )
    {
        ns.shift();
        count++;
    }

    return { rest: ns, removed: count };
}

function deriveConstraints(ns)
{
    const result = [];

    while ( ns.length > 0 )
    {
        ns = removeLeadingWhite(ns);

        const { rest, removed } = removeLeadingBlack(ns);
        ns = rest;

        if ( removed > 0 )
        {
            result.push(removed);
        }
    }

    return result;
}

function equalArrays(xs, ys)
{
    if ( xs.length !== ys.length ) return false;

    for ( let i = 0; i !== xs.length; ++i )
    {
        if ( xs[i] !== ys[i] )
        {
            return false;
        }
    }

    return true;
}

function satisfiesConstraints(ns, constraints)
{
    return !ns.includes(-1) && equalArrays(deriveConstraints(ns), constraints);
}

function areCompatible(xs, ys)
{
    if ( xs.length !== ys.length ) return false;
    if ( xs.length === 0 ) return true;

    const [ a, ...as ] = xs;
    const [ b, ...bs ] = ys;

    return (a === b || a === -1 || b === -1) && areCompatible(as, bs);
}

function parse(string)
{
    const lines = string.split("\n");
    const rows = [];

    for ( const line of lines )
    {
        rows.push(parseRow(line));
    }

    return rows;


    function parseRow(rowString)
    {
        const result = [];

        for ( const char of rowString )
        {
            result.push(parseChar(char));
        }

        return result;
    }

    function parseChar(char)
    {
        if ( char === '.' ) return 0;
        if ( char === 'x' ) return 1;
        return -1;
    }
}

function unparse(nss)
{
    let rowStrings = [];

    for ( const ns of nss )
    {
        rowStrings.push(rowToString(ns));
    }

    return rowStrings.join("\n");


    function rowToString(ns)
    {
        let result = '';

        for ( const n of ns )
        {
            result += toChar(n);
        }

        return result;
    }

    function toChar(n)
    {
        if ( n === 0 ) return '.';
        if ( n === 1 ) return 'x';
        return '?';
    }
}

function width(nss)
{
    return nss[0].length;
}

function height(nss)
{
    return nss.length;
}

function findUnknowns(nss)
{
    const result = [];

    for ( let y = 0; y !== height(nss); ++y )
    {
        for ( let x = 0; x !== width(nss); ++x )
        {
            if ( nss[y][x] === -1 )
            {
                result.push( {x, y} );
            }
        }
    }

    return result;
}

function sum(ns)
{
    let total = 0;

    for ( const n of ns )
    {
        total += n;
    }

    return total;
}

function areValidConstraints(n, constraints)
{
    return sum(constraints) + constraints.length - 1 <= n;
}

function overwriteUnknowns(nss, value)
{
    for ( const {x, y} of findUnknowns(nss) )
    {
        nss[y][x] = value;
    }
}

function column(nss, i)
{
    const result = [];

    for ( let j = 0; j !== height(nss); ++j )
    {
        result.push(nss[j][i]);
    }

    return result;
}

function row(nss, i)
{
    return nss[i];
}

function pairUp({grid, rowConstraints, columnConstraints})
{
    const result = [];

    for ( let i = 0; i !== width(grid); ++i )
    {
        result.push( [ column(grid, i), columnConstraints[i] ] );
    }

    for ( let i = 0; i !== height(grid); ++i )
    {
        result.push( [ row(grid, i), rowConstraints[i] ] );
    }

    return result;
}
