// Hulpfunctie
function countStones(bs) {
    let count = 0;

    for (const b of bs) {
        if (b) count++;
    }

    return count;
}

function isSolved(bs) {
    let a = 0;
    for (let i = 0; i < bs.length; i++) {
        if (bs[i] === true) a++;
    }
    return a === 1;
}

function pattern(n) {
    const result = []
    for (let i = 0; i < n; i++) {
        result.push(false);
        result.push(true);
        result.push(true);
    }
    return result;
}

function isValidMove(bs, i, delta) {
    if (i < 0 || i > bs.length || isSolved(bs)) return false;

    if (delta === -1) {
        if (bs[i - 2] !== undefined && bs[i - 2] === false) {
            return true;
        }
    }

    if (delta === 1) {
        if (bs[i + 2] !== undefined && bs[i + 2] === false) {
            return true;
        }
    }
    return false;
}

// Hulpfunctie
function isValidIndex(xs, i) {
    return 0 <= i && i < xs.length;
}

function isValidMove(bs, i, delta) {
    const start = i;
    const jumpedOver = i + delta;
    const arrival = i + 2 * delta;

    return isValidIndex(bs, start) && isValidIndex(bs, arrival) && bs[start] === true && bs[jumpedOver] === true && bs[arrival] === false;
}

function validMoves(bs) {
    const left = [];
    const right = [];

    for (let i = 0; i !== bs.length; ++i) {
        if (isValidMove(bs, i, -1)) {
            left.push(i);
        }

        if (isValidMove(bs, i, +1)) {
            right.push(i);
        }
    }

    return { left, right };
}

function move(bs, i, delta) {
    let board = [...bs];

    board[i] = false;
    if (delta === -1) {
        board[i - 2] = true;
        board[i - 1] = false;
    }
    if (delta === 1) {
        board[i + 2] = true;
        board[i + 1] = false;
    }
    return board;
}

function solveable(bs) {
    if (isSolved(bs)) {
        return true;
    }

    const { left, right } = validMoves(bs);

    for (const i of left) {
        const afterMove = move(bs, i, -1);

        if (solveable(afterMove)) {
            return true;
        }
    }

    for (const i of right) {
        const afterMove = move(bs, i, 1);

        if (solveable(afterMove)) {
            return true;
        }
    }

    return false;
}

function size(bss) {
    if (bss[0] === undefined) {
        return "invalid";
    }

    let size = bss[0].length;
    for (let i = 0; i < bss.length; i++) {
        if (bss[i][0] === undefined) {
            return "invalid";
        }
        if (bss[i].length !== size) {
            return "invalid";
        }
    }

    var board = new Object();
    board.width = bss[0].length;
    board.height = bss.length;
    return board;
}

function width(bss) {
    return bss[0].length;
}

function height(bss) {
    return bss.length;
}

function isValidPosition2D(bss, x, y) {
    return 0 <= x && x < width(bss) && 0 <= y && y < height(bss);
}


function isValidMove2D(bss, x, y, dx, dy) {
    const start = { x, y };
    const jumpedOver = { x: x + dx, y: y + dy };
    const arrival = { x: x + 2 * dx, y: y + 2 * dy };

    if (!isValidPosition2D(bss, start.x, start.y) || !isValidPosition2D(bss, arrival.x, arrival.y)) {
        return false;
    }

    return at(start) === true && at(jumpedOver) === true && at(arrival) === false;


    // Geneste hulpfunctie, voor de leesbaarheid
    function at(p) {
        return bss[p.y][p.x];
    }
}

function isSolved2D(bss) {
    let total = 0;
    for (const row of bss) {
        total += countStones(row);
    }
    return total === 1;
}

function parse(str) {
    let board = [];
    let ar = [];

    for (let i = 0; i < str.length; i++) {
        if (str[i] === "x") {
            ar.push(true);
        }
        if (str[i] === ".") {
            ar.push(false);
        }
        if (str[i] === "|") {
            board.push(ar);
            ar = [];
        }
    }
    board.push(ar);
    return board;
}