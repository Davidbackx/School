function sameRow(p, q) {
    return p.row === q.row;
}

function sameColumn(p, q) {
    return p.column === q.column;
}

function sameSquare(p, q) {
    return sqr(p.row) === sqr(q.row) && sqr(p.column) === sqr(q.column);

    function sqr(x) {
        return Math.floor(x / 3);
    }
}

function sameGroup(p, q) {
    return sameRow(p, q) || sameColumn(p, q) || sameSquare(p, q);
}

function equalPositions(p, q) {
    return sameRow(p, q) && sameColumn(p, q)
}

function allPositions() {
    return flatten(range(0, 9).map(row => range(0, 9).map(column => ({ row, column }))));
}

function range(from, to) {
    if (from < to) {
        return [from, ...range(from + 1, to)];
    } else {
        return [];
    }
}

function flatten(xss) {
    return xss.reduce((xs, ys) => [...xs, ...ys], []);
}

function remove(xs, x) {
    return xs.filter(y => x !== y);
}