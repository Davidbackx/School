// Hulpfunctie
function countStones(bs) {
    let count = 0;

    for (const b of bs) {
        if (b) count++;
    }

    return count;
}


function isSolved(bs) {
    return countStones(bs) === 1;
}

function pattern(n) {
    let result = [];

    for (let i = 0; i !== n; ++i) {
        result = [...result, false, true, true];
    }

    return result;
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

function move(bs, from, delta) {
    // Maak kopie, gezien de gegeven array niet gewijzigd mag worden
    bs = [...bs];

    bs[from] = false;
    bs[from + delta] = false;
    bs[from + 2 * delta] = true;

    return bs;
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

// Hulpfunctie
function width(bss) {
    return bss[0].length;
}

function height(bss) {
    return bss.length;
}

// Hulpfunctie
function isValidBoardShape(bss) {
    if (height(bss) === 0) return false;

    const firstRowWidth = width(bss);
    if (firstRowWidth === 0) return false;

    for (let i = 1; i < bss.length; ++i) {
        const row = bss[i];

        if (row.length !== firstRowWidth) return false;
    }

    return true;
}

function size(bss) {
    if (!isValidBoardShape(bss)) {
        return 'invalid';
    }
    else {
        return { width: width(bss), height: height(bss) };
    }
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

function parse(string) {
    const lines = string.split('|');
    const height = lines.length;
    const width = lines[0].length;
    const result = [];

    for (let line of lines) {
        result.push(parseLine(line));
    }

    return result;


    function parseLine(line) {
        const result = [];

        for (const char of line) {
            result.push(parseChar(char));
        }

        return result;
    }

    function parseChar(char) {
        // Returns true if 'x'
        // Returns false if '.'
        return char === 'x';
    }
}
