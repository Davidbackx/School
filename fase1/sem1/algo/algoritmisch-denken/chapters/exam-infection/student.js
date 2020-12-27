function isValidBoard(board) {
    if (board.length < 1) return false;
    for (pos of board) {
        if (pos !== 0 && pos !== 1 && pos !== 2) return false;
    }
    return true;
}

function vijand(kleur) {
    if (kleur === 1) return 2;
    return 1;
}

function mitosis(board, from, to) {
    let b = [...board];
    let kleur = b[from];
    b[to] = kleur;

    if (b[to - 1] === vijand(kleur)) {
        b[to - 1] = kleur;
    }
    if (b[to + 1] === vijand(kleur)) {
        b[to + 1] = kleur;
    }
    return b;
}

function counts(board) {
    if (board.length === 0) {
        return { red: 0, green: 0 };
    }
    else {
        const [first, ...rest] = board;
        let { red, green } = counts(rest);
        if (first === 1) {
            red++;
        }
        else if (first === 2) {
            green++;
        }
        return { red, green };
    }
}

function around({ x, y }) {
    const result = [];

    for (const dx of [-1, 0, 1]) {
        for (const dy of [-1, 0, 1]) {
            if (dx !== 0 || dy !== 0) {
                result.push({ x: x + dx, y: y + dy });
            }
        }
    }

    return result;
}

function isValidBoard2D(board) {
    if (board.length < 1) return false;
    let columnSize = board[0].length;
    if (columnSize < 1) return false;

    for (let x = 0; x < board.length; x++) {
        if (board[x].length !== columnSize) return false;
        for (let y = 0; y < columnSize; y++) {
            if (board[x][y] !== 0 && board[x][y] !== 1 && board[x][y] !== 2) {
                return false;
            }
        }
    }
    return true;
}

function width(xss) {
    return xss[0].length;
}

function height(xss) {
    return xss.length;
}

function size(xss) {
    return { width: width(xss), height: height(xss) };
}


function isInside(xss, { x, y }) {
    const { width, height } = size(xss);

    return 0 <= x && x < width && 0 <= y && y < height;
}

function isValidJump({ x: x1, y: y1 }, { x: x2, y: y2 }) {
    const dx = Math.abs(x2 - x1);
    const dy = Math.abs(y2 - y1);

    return (dx === 0 && [1, 2].includes(dy)) || (dy === 0 && [1, 2].includes(dx)) || (dx === dy && [1, 2].includes(dx));
}

function isValidMove2D(board, from, to) {
    return isInside(board, from) && isInside(board, to) && [1, 2].includes(board[from.y][from.x]) && board[to.y][to.x] === 0 && isValidJump(from, to);
}

function jump2D(board, from, to) {
    board[to.y][to.x] = board[from.y][from.x];
    board[from.y][from.x] = 0;
}

function otherPlayer(x) {
    return 3 - x;
}

function mitosis2D(board, from, to) {
    const me = board[from.y][from.x];
    const he = otherPlayer(me);

    board[to.y][to.x] = me;
    for (pos of around(to)) {
        if (isInside(board, pos) && board[pos.y][pos.x] === he) {
            board[pos.y][pos.x] = me;
        }
    }
}

function move2D(board, from, to) {
    const dx = Math.abs(to.x - from.x);
    const dy = Math.abs(to.y - from.y);

    if (dx <= 1 && dy <= 1) {
        mitosis2D(board, from, to);
    }
    else {
        jump2D(board, from, to);
    }
}

function countCells2D(board, player) {
    let c = 0;
    for (let p of board.flat()) {
        if (p === player) {
            c++;
        }
    }
    return c;
}

function isGameOver2D(board) {
    for (let p of board.flat()) {
        if (p === 0) return false;
    }
    return true;
}