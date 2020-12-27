function black(width, height) {
    const result = new Array(height);
    for (let y = 0; y !== height; ++y) {
        result[y] = new Array(width);
        for (let x = 0; x !== width; ++x) {
            result[y][x] = false;
        }
    }
    return result;
}

function white(width, height) {
    const result = new Array(height);
    for (let y = 0; y !== height; ++y) {
        result[y] = new Array(width);
        for (let x = 0; x !== width; ++x) {
            result[y][x] = true;
        }
    }
    return result;
}

function width(image) {
    return image[0].length;
}

function height(image) {
    return image.length;
}

function isInside(image, row, col) {
    return 0 <= col && col < width(image) && 0 <= row && row < height(image);
}

function drawHorizontalLine(image, y) {
    for (let x = 0; x < image[0].length; x++) {
        image[y][x] = true;
    }
}

function drawVerticalLine(image, x) {
    for (let y = 0; y < image.length; y++) {
        image[y][x] = true;
    }
}

function horizontalLines(width, height) {
    const result = black(width, height);
    for (let y = 1; y < height; y += 2) {
        drawHorizontalLine(result, y);
    }
    return result;
}

function verticalLines(width, height) {
    const result = black(width, height);
    for (let x = 1; x < width; x += 2) {
        drawVerticalLine(result, x);
    }
    return result;
}

function horizontalLines2(width, height, thickness) {
    const result = black(width, height);
    for (let y = 0; y < height; y += 1 + thickness) {
        for (let dy = 0; dy < thickness && y + 1 + dy < height; ++dy) {
            drawHorizontalLine(result, y + dy + 1);
        }
    }
    return result;
}
function horizontalLines3(width, height, thickness, gapSize) {
    const result = black(width, height);
    for (let y = 0; y < height; y += thickness + gapSize) {
        for (let dy = 0; dy < thickness; ++dy) {
            if (y + gapSize + dy < height) {
                drawHorizontalLine(result, y + gapSize + dy);
            }
        }
    }
    return result;
}

function triangle(size) {
    const result = black(size, size);
    for (let y = 0; y !== size; ++y) {
        for (let x = 0; x !== size; ++x) {
            result[y][x] = x <= y;
        }
    }
    return result;
}

function triangle2(size) {
    const result = black(size, size);
    for (let y = 0; y !== size; ++y) {
        for (let x = 0; x !== size; ++x) {
            result[y][x] = x < size - y;
        }
    }
    return result;
}

function triangle3(size) {
    const result = black(size, size);
    for (let y = 0; y !== size; ++y) {
        for (let x = 0; x !== size; ++x) {
            result[y][x] = x >= y;
        }
    }
    return result;
}
function checkerboard(width, height) {
    const result = black(width, height);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            result[y][x] = (x + y) % 2 !== 0;
        }
    }
    return result;
}

function checkerboard2(width, height, size) {
    const result = black(width, height);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            result[y][x] = (Math.floor(x / size) + Math.floor(y / size)) % 2 !== 0;
        }
    }
    return result;
}

function diagonals(width, height, size) {
    const result = black(width, height);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            result[y][x] = (x + y) % (2 * size) < size;
        }
    }
    return result;
}

function drawDisk(image, centerRow, centerColumn, radius) {
    for (let y = 0; y !== height(image); ++y) {
        for (let x = 0; x !== width(image); ++x) {
            if ((x + 0.5 - centerColumn) ** 2 + (y + 0.5 - centerRow) ** 2 <= radius ** 2) {
                image[y][x] = true;
            }
        }
    }
}

function drawRectangle(image, row, column, width, height) {
    drawHorizontalSegment(column, column + width, row);
    drawHorizontalSegment(column, column + width, row + height - 1);
    drawVerticalSegment(column, row, row + height);
    drawVerticalSegment(column + width - 1, row, row + height);

    function drawHorizontalSegment(x1, x2, y) {
        for (let x = x1; x < x2; ++x) {
            image[y][x] = true;
        }
    }

    function drawVerticalSegment(x, y1, y2) {
        for (let y = y1; y < y2; ++y) {
            image[y][x] = true;
        }
    }
}

function drawFilledRectangle(image, row, column, width, height) {
    for (let dy = 0; dy < height; ++dy) {
        for (let dx = 0; dx < width; ++dx) {
            image[row + dy][column + dx] = true;
        }
    }
}

function drawTiltedSquare(image, row, column, size) {
    --size;
    for (let dy = 0; dy <= size; ++dy) {
        for (let dx = -dy; dx <= dy; ++dx) {
            const y = row + dy;
            const x = column + size + dx;
            image[y][x] = true;
        }
    }
    for (let dy = 1; dy <= size; ++dy) {
        for (let dx = -(size - dy); dx <= size - dy; ++dx) {
            const y = row + size + dy;
            const x = column + size + dx;
            image[y][x] = true;
        }
    }
}

function spiral(width, height) {
    const result = black(width, height);
    const directions = [
        [1, 0],
        [0, 1],
        [-1, 0],
        [0, -1]
    ];
    let currentDirectionIndex = 0;
    let currentPosition = [0, 0];
    while (canContinue()) {
        paintStraightForward();
        turn();
    }
    return result;

    function paintStraightForward() {
        while (canContinue()) {
            paint();
            forward();
        }
        backward();
    }

    function paint() {
        const [x, y] = currentPosition;
        result[y][x] = true;
    }

    function forward() {
        const currentDirection = directions[currentDirectionIndex];
        currentPosition = move(currentPosition, 1, currentDirection);
    }

    function backward() {
        const currentDirection = directions[currentDirectionIndex];
        currentPosition = move(currentPosition, -1, currentDirection);
    }

    function turn() {
        currentDirectionIndex = (currentDirectionIndex + 1) % directions.length;
    }

    function canContinue() {
        const currentDirection = directions[currentDirectionIndex];
        const oneStepAhead = move(currentPosition, 1, currentDirection);
        return !at(oneStepAhead);
    }

    function at([x, y]) {
        if (isInside([x, y])) {
            return result[y][x];
        } else if (onBorder([x, y])) {
            return false;
        } else {
            return true;
        }
    }

    function isInside([x, y]) {
        return 0 <= x && x < width && 0 <= y && y < height;
    }

    function onBorder([x, y]) {
        return x === -1 || x === width || y === -1 || y === height;
    }

    function move([x, y], n, [dx, dy]) {
        return [x + n * dx, y + n * dy];
    }
}

function floodFill(image, row, col) {
    if (isInside(image, row, col) && !image[row][col]) {
        image[row][col] = true;
        floodFill(image, row - 1, col);
        floodFill(image, row + 1, col);
        floodFill(image, row, col - 1);
        floodFill(image, row, col + 1);
    }
}