function isSolved(bs)
{
    return sum(bs) === 1;
}

function isValidIndex(xs, i)
{
    return 0 <= i && i < xs.length;
}

function isValidMove(bs, i, delta)
{
    return isValidIndex(bs, i) && isValidIndex(bs, i + 2 * delta) && bs[i] && bs[i + delta] && !bs[i + 2 * delta];
}

function range(from, to)
{
    return from < to ? [from, ...range(from+1, to)] : [];
}

function validMoves(bs)
{
    const left = range(0, bs.length).filter(i => isValidMove(bs, i, -1));
    const right = range(0, bs.length).filter(i => isValidMove(bs, i, 1));

    return { left, right };
}

function move(bs, from, delta)
{
    bs = [...bs];

    bs[from] = false;
    bs[from + delta] = false;
    bs[from + 2 * delta] = true;

    return bs;
}

function initializeArray(n, f)
{
    const result = new Array(n);

    for ( let i = 0; i !== n; ++i )
    {
        result[i] = f(i);
    }

    return result;
}

function pattern(n)
{
    return initializeArray(n * 3, i => i % 3 !== 0);
}

function size(bss)
{
    if ( bss.length === 0 || !bss.every(bs => bs.length > 0 && bs.length === bss[0].length) )
    {
        return 'invalid';
    }
    else
    {
        const width = bss[0].length;
        const height = bss.length;

        return { width, height };
    }
}

function isValidPosition2D(bss, x, y)
{
    const { width, height } = size(bss);

    return 0 <= x && x < width && 0 <= y && y < height;
}

function isValidMove2D(bss, x, y, dx, dy)
{
    return isValidPosition2D(bss, x, y) && isValidPosition2D(bss, x + 2 * dx, y + 2 * dy) && bss[y][x] && bss[y + dy][x + dx] && !bss[y + 2 * dy][x + 2 * dx];
}

function sum(ns)
{
    return ns.reduce((acc, x) => acc + x, 0);
}

function isSolved2D(bss)
{
    return sum(bss.map(sum)) === 1;
}

function parse(str)
{
    return str.split("|").map(line => line.trim().split('').map(c => c === 'x'));
}

function solveable(bs)
{
    return range(0, bs.length).some(i => isSolved(bs) || [-1, 1].some(delta => isValidMove(bs, i, delta) && solveable(move(bs, i, delta))));
}