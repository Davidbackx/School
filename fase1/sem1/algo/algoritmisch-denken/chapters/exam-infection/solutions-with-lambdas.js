function isValidCell(x)
{
    return [0, 1, 2].includes(x);
}

function isValidBoard(xs)
{
    return xs.length > 0 && xs.every(isValidCell);
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

function count(xs, x)
{
    return xs.reduce( (acc, y) => acc + (x===y), 0 );
}

function counts(board)
{
    const red = count(board, 1);
    const green = count(board, 2);

    return { red, green };
}

function flatten([xs, ...xss])
{
    return xs.concat(...xss);
}

function around({x, y})
{
    return flatten([-1, 0, 1].map( dx =>
        flatten([-1, 0, 1].map( dy => {
            if ( dx !== 0 || dy !== 0 )
            {
                return [{x: x + dx, y: y + dy}];
            }
            else
            {
                return [];
            }
        } ))
    ));
}

function isValidBoard2D(xss)
{
    return xss.length !== 0 && xss[0].length !== 0 && xss.every( xs => xs.length == xss[0].length) && xss.every( xs => xs.every(isValidCell) );
}

function size(xss)
{
    const height = xss.length;
    const width = xss[0].length;

    return { width, height };
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

    around(to).filter((p) => isInside(board, p) && board[p.y][p.x] === he).forEach(p => board[p.y][p.x] = me);
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
    return board.map(xs => xs.filter(x => x === player).length).reduce((a, b) => a + b, 0);
}

function isGameOver2D(board)
{
    return countCells2D(board, 0) === 0;
}
