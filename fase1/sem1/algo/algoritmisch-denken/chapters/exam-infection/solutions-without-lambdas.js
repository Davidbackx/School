function isValidCell(x)
{
    return [0, 1, 2].includes(x);
}

function isValidBoard(xs)
{
    if ( xs.length === 0 ) return false;

    for ( const x of xs )
    {
        if ( !isValidCell(x) )
        {
            return false;
        }
    }

    return true;
}

function otherPlayer(x)
{
    return 3 - x;
}

function mitosis(xs, from, to)
{
    xs = [...xs];

    const me = xs[from];
    const he = otherPlayer(me);

    xs[to] = me;;

    if ( xs[to - 1] === he ) xs[to - 1] = me;
    if ( xs[to + 1] === he ) xs[to + 1] = me;

    return xs;
}

function counts(board)
{
    if ( board.length === 0 )
    {
        return { red: 0, green: 0 };
    }
    else
    {
        const [ first, ...rest ] = board;
        let { red, green } = counts(rest);

        if ( first === 1 )
        {
            red++;
        }
        else if ( first === 2 )
        {
            green++;
        }

        return { red, green };
    }
}

function around({x, y})
{
    const result = [];

    for ( const dx of [ -1, 0, 1 ] )
    {
        for ( const dy of [ -1, 0, 1 ] )
        {
            if ( dx !== 0 || dy !== 0 )
            {
                result.push( {x: x + dx, y: y + dy} );
            }
        }
    }

    return result;
}

function width(xss)
{
    return xss[0].length;
}

function height(xss)
{
    return xss.length;
}

function positions(xss)
{
    const result = [];

    for ( let x = 0; x !== width(xss); ++x )
    {
        for ( let y = 0; y !== height(xss); ++y )
        {
            result.push( {x, y} );
        }
    }

    return result;
}

function isValidBoard2D(xss)
{
    if ( xss.length === 0 ) return false;
    if ( xss[0].length === 0 ) return false;

    for ( const xs of xss )
    {
        if ( xs.length !== xss[0].length )
        {
            return false;
        }
    }

    for ( const {x, y} of positions(xss) )
    {
        if ( !isValidCell(xss[y][x]) )
        {
            return false;
        }
    }

    return true;
}

function size(xss)
{
    return { width: width(xss), height: height(xss) };
}

function isInside(xss, {x, y})
{
    const { width, height } = size(xss);

    return 0 <= x && x < width && 0 <= y && y < height;
}

function isValidJump({x: x1, y: y1}, {x: x2, y: y2})
{
    const dx = Math.abs(x2 - x1);
    const dy = Math.abs(y2 - y1);

    return (dx === 0 && [1, 2].includes(dy)) || (dy === 0 && [1, 2].includes(dx)) || (dx === dy && [1, 2].includes(dx));
}

function isValidMove2D(board, from, to)
{
    return isInside(board, from) && isInside(board, to) && [1, 2].includes(board[from.y][from.x]) && board[to.y][to.x] === 0 && isValidJump(from, to);
}

function jump2D(board, from, to)
{
    const me = board[from.y][from.x];

    board[to.y][to.x] = me;
    board[from.y][from.x] = 0;
}

function mitosis2D(board, from, to)
{
    const me = board[from.y][from.x];
    const he = otherPlayer(me);

    board[to.y][to.x] = me;

    for ( const position of around(to) )
    {
        if ( isInside(board, position) && board[position.y][position.x] === he )
        {
            board[position.y][position.x] = me
        }
    }
}

function move2D(board, from, to)
{
    const dx = Math.abs(to.x - from.x);
    const dy = Math.abs(to.y - from.y);

    if ( dx <= 1 && dy <= 1 )
    {
        mitosis2D(board, from, to);
    }
    else
    {
        jump2D(board, from, to);
    }
}

function countCells2D(board, player)
{
    let count = 0;

    for ( const x of board.flat() )
    {
        if ( x === player )
        {
            count++;
        }
    }

    return count;
}

function isGameOver2D(board)
{
    return countCells2D(board, 0) === 0;
}
