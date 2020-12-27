function redFilter(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            const { r, g, b } = bitmap[y][x];
            bitmap[y][x] = { r, g: 0, b: 0 };
        }
    }
}

function bitmapWidth(bitmap) {
    return bitmap[0].length;
}

function bitmapHeight(bitmap) {
    return bitmap.length;
}

function greenFilter(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            const { r, g, b } = bitmap[y][x];
            bitmap[y][x] = { r: 0, g, b: 0 };
        }
    }
}

function blueFilter(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            const { r, g, b } = bitmap[y][x];
            bitmap[y][x] = { r: 0, g: 0, b };
        }
    }
}

function grayscale(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            bitmap[y][x] = toGray(bitmap[y][x]);
        }
    }

    function toGray(color) {
        const avg = (color.r + color.g + color.b) / 3;
        return { r: avg, g: avg, b: avg };
    }
}

function flipHorizontally(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x < width / 2; ++x) {
            const c = bitmap[y][x];
            const oppositeX = width - x - 1;
            bitmap[y][x] = bitmap[y][oppositeX];
            bitmap[y][oppositeX] = c;
        }
    }
}

function flipVertically(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let y = 0; y < height / 2; ++y) {
        const row = bitmap[y];
        const oppositeY = height - y - 1;
        bitmap[y] = bitmap[oppositeY];
        bitmap[oppositeY] = row;
    }
}

function rotateCW(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    const result = new Array(width);
    for (let x = 0; x !== width; ++x) {
        result[x] = new Array(height);
        for (let y = 0; y !== height; ++y) {
            result[x][y] = bitmap[height - y - 1][x];
        }
    }
    return result;
}

function rotateCCW(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    const result = new Array(width);
    for (let x = 0; x !== width; ++x) {
        result[x] = new Array(height);
        for (let y = 0; y !== height; ++y) {
            result[x][y] = bitmap[y][width - x - 1];
        }
    }
    return result;
}

function mosaic(bitmap, size) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    for (let x = 0; x < width; x += size) {
        for (let y = 0; y < height; y += size) {
            let rSum = 0;
            let gSum = 0;
            let bSum = 0;
            for (let dx = 0; dx !== size; ++dx) {
                for (let dy = 0; dy !== size; ++dy) {
                    const color = bitmap[y + dy][x + dx];
                    rSum += color.r;
                    gSum += color.g;
                    bSum += color.b;
                }
            }
            const rAverage = rSum / size ** 2;
            const gAverage = gSum / size ** 2;
            const bAverage = bSum / size ** 2;
            const averageColor = { r: rAverage, g: gAverage, b: bAverage };
            for (let dx = 0; dx !== size; ++dx) {
                for (let dy = 0; dy !== size; ++dy) {
                    bitmap[y + dy][x + dx] = averageColor;
                }
            }
        }
    }
}

function embiggen(bitmap) {
    const width = bitmapWidth(bitmap);
    const height = bitmapHeight(bitmap);
    const result = new Array(height * 2);
    for (let y = 0; y !== height; ++y) {
        result[2 * y] = new Array(width * 2);
        result[2 * y + 1] = new Array(width * 2);
        for (let x = 0; x !== width; ++x) {
            const c = bitmap[y][x];
            result[2 * y][2 * x] = c;
            result[2 * y + 1][2 * x] = c;
            result[2 * y][2 * x + 1] = c;
            result[2 * y + 1][2 * x + 1] = c;
        }
    }
    return result;
}

function crop(bitmap, left, top, width, height) {
    const result = new Array(height);
    for (let y = 0; y !== height; ++y) {
        result[y] = new Array(width);
    }
    for (let y = 0; y !== height; ++y) {
        for (let x = 0; x !== width; ++x) {
            result[y][x] = bitmap[top + y][left + x];
        }
    }
    return result;
}