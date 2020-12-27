// Schrijf hier je code
/*
   Auxiliary functions
*/

function range(a, b)
{
    if ( a < b )
    {
        return [ a, ...range(a + 1, b) ];
    }
    else
    {
        return [];
    }
}

function indices(xs)
{
    return range(0, xs.length);
}

function zip(xs, ys)
{
    return indices(xs).map( i => [ xs[i], ys[i] ] );
}

function equalArrays(xs, ys)
{
    return xs.length === ys.length && zip(xs, ys).every( ([x, y]) => x === y );
}

function range(a, b)
{
    return a < b ? [ a, ...range(a + 1, b) ] : [];
}

function width(xss)
{
    return xss[0].length;
}

function height(xss)
{
    return xss.length;
}

function row(xss, rowIndex)
{
    return xss[rowIndex];
}

function column(xss, columnIndex)
{
    return range(0, height(xss)).map(y => xss[y][columnIndex]);
}

function rows(xss)
{
    return xss;
}

function columns(xss)
{
    return range(0, width(xss)).map( i => column(xss, i) );
}

function sum(ns)
{
    return ns.reduce( (x, y) => x + y, 0 );
}

function positions(nss)
{
    return range(0, height(nss)).map(y => range(0, width(nss)).map(x => ({x, y}))).flat()
}

function findPositionsOf(nss, k)
{
    return positions(nss).filter(p => nss[p.y][p.x] === k);
}



/*
  PiCross-specific functions
*/

function removeLeading(ns, n)
{
    const index = [...ns, undefined].findIndex(k => k !== n);

    return { rest: ns.slice(index), removed: index };
}

function removeLeadingWhite(ns)
{
    return removeLeading(ns, 0).rest;
}

function removeLeadingBlack(ns)
{
    return removeLeading(ns, 1);
}

function deriveConstraints(ns)
{
    const result = [];

    while ( (ns = removeLeadingWhite(ns)).length > 0 )
    {
        const { rest, removed } = removeLeadingBlack(ns);
        ns = rest;
        result.push(removed);
    }

    return result;
}

function satisfiesConstraints(bs, constraints)
{
    return !bs.includes(-1) && equalArrays( constraints, deriveConstraints(bs) );
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
    return string.split('\n').map( line => line.split('').map(parseSingle) );


    function parseSingle(char)
    {
        if ( char === '.' ) return 0;
        else if ( char === 'x' ) return 1;
        else return -1;
    }
}

function unparse(nss)
{
    return nss.map(row => row.map(unparseSingle).join('')).join('\n');

    function unparseSingle(n)
    {
        if ( n === 0 ) return '.';
        else if ( n === 1 ) return 'x';
        else return '?';
    }
}

function findUnknowns(nss)
{
    return findPositionsOf(nss, -1);
}

function areValidConstraints(length, constraints)
{
    return sum(constraints) + constraints.length - 1 <= length;
}

function pairUp({ rowConstraints, columnConstraints, grid })
{
    return [ ...zip(columns(grid), columnConstraints), ...zip(rows(grid), rowConstraints) ];
}

function overwriteUnknowns(grid, value)
{
    findUnknowns(grid).forEach(({x, y}) => grid[y][x] = value);
}
