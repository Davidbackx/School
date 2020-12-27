function shapeT(color) {
    return [[color, color, color], [0, color, 0]];
}

function shapeI(color) {
    return [[color], [color], [color], [color]];
}

function shapeS(color) {
    return [[0, color, color], [color, color, 0]];
}

function shapeZ(color) {
    return [[color, color, 0], [0, color, color]];
}

function shapeL(color) {
    return [[color, 0], [color, 0], [color, color]];
}

function shapeJ(color) {
    return [[0, color], [0, color], [color, color]];
}

function shapeO(color) {
    return [[color, color], [color, color]];
}

function createEmptyPit(width, height) {
    const pit = new Array(height);
    for (let i = 0; i !== height; ++i) {
        pit[i] = new Array(width);
        for (let j = 0; j !== width; ++j) {
            pit[i][j] = 0;
        }
    }
    return pit;
}

function width(grid) {
    return grid[0].length;
}

function height(grid) {
    return grid.length;
}

function isInside(grid, row, column) {
    return 0 <= column && column < width(grid) && 0 <= row && row < height(grid);
}

function rotateCW(grid) {
    return initializeArray(width(grid), columnIndex => reverse(column(grid, columnIndex)));
}

function initializeArray(n, at) {
    let result = new Array(n);
    for (let i = 0; i !== n; ++i) {
        result[i] = at(i);
    }
    return result;
}

function reverse(xs) {
    return initializeArray(xs.length, i => xs[xs.length - i - 1]);
}

function column(grid, columnIndex) {
    return grid.map(row => row[columnIndex]);
}

function isRowFull(row) {
    for (i of row) {
        if (i === 0) return false;
    }
    return true;
}

function countFullRows(pit) {
    let aantal = 0;
    for (row of pit) {
        if (isRowFull(row)) aantal += 1;
    }
    return aantal;
}

function clearRow(pit, row) {
    for (let i = 0; i < pit[row].length; i++) {
        pit[row][i] = 0;
    }
}

function copyRow(pit, from, to) {
    const w = width(pit);
    for (let x = 0; x !== w; ++x) {
        pit[to][x] = pit[from][x];
    }
}

function removeRow(pit, row) {
    for (let y = row; y > 0; y--) {
        copyRow(pit, y - 1, y);
    }
    clearRow(pit, 0);
}

function removeFullRows(grid) {
    const h = height(grid);
    for (let row = 0; row !== h; ++row) {
        if (isRowFull(grid[row])) {
            removeRow(grid, row);
        }
    }
}

function shapeFitsAt(shape, grid, row, column) {
    const shapeWidth = width(shape);
    const shapeHeight = height(shape);
    for (let shapeRow = 0; shapeRow !== shapeHeight; ++shapeRow) {
        for (let shapeColumn = 0; shapeColumn !== shapeWidth; ++shapeColumn) {
            const square = shape[shapeRow][shapeColumn];
            if (square !== 0) {
                const gridRow = shapeRow + row;
                const gridColumn = shapeColumn + column;
                if (!isInside(grid, gridRow, gridColumn) || grid[gridRow][gridColumn] !== 0) {
                    return false;
                }
            }
        }
    }
    return true;
}

function addShapeAt(shape, grid, row, column) {
    const shapeWidth = width(shape);
    const shapeHeight = height(shape);
    for (let shapeRow = 0; shapeRow !== shapeHeight; ++shapeRow) {
        for (let shapeColumn = 0; shapeColumn !== shapeWidth; ++shapeColumn) {
            const square = shape[shapeRow][shapeColumn];
            if (square !== 0) {
                const gridRow = shapeRow + row;
                const gridColumn = shapeColumn + column;
                grid[gridRow][gridColumn] = shape[shapeRow][shapeColumn];
            }
        }
    }
}

function dropShape(shape, pit, shapeRow, shapeColumn) {
    while (shapeFitsAt(shape, pit, shapeRow + 1, shapeColumn)) {
        shapeRow++;
    }
    addShapeAt(shape, pit, shapeRow, shapeColumn);
}