function longest(xss) {
    let y = [];
    for (x of xss) {
        if (x.length > y.length) {
            y = x;
        }
    }
    return y;
}

function flatten(xss) {
    let result = [];
    for (let xs of xss) {
        result = [...result, ...xs];
    }
    return result;
}

function orderedPairs(xss) {
    let result = [];
    for (let i = 0; i < xss.length; i++) {
        for (let j = 0; j < xss.length; j++) {
            result.push([xss[i], xss[j]]);
        }
    }
    return result;
}

function unorderedPairs(xss) {
    let result = [];
    for (let i = 0; i < xss.length; i++) {
        for (let j = i + 1; j < xss.length; j++) {
            result.push([xss[i], xss[j]]);
        }
    }
    return result;
}

function prefixes(xs) {
    const result = new Array(xs.length + 1);
    for (let i = 0; i < result.length; i++) {
        result[i] = xs.slice(0, i);
    }
    return result;
}

function pascal(n) {
    const result = new Array(n);
    result[0] = [1];
    for (let i = 1; i < n; ++i) {
        result[i] = nextRow(result[i - 1]);
    }
    return result;

    function nextRow(ns) {
        const result = new Array(ns.length + 1);
        ns = [0, ...ns, 0];
        for (let i = 0; i !== result.length; ++i) {
            result[i] = ns[i] + ns[i + 1];
        }
        return result;
    }
}

function concat(xss) {
    let result = [];
    for (x of xss) {
        result = [...result, ...x];
    }
    return result;
}

function intersection(xss) {
    if (xss.length === 0) {
        return [];
    } else {
        const result = [];
        const [first, ...rest] = xss;
        for (const x of first) {
            if (containedInEachOfRest(x)) {
                result.push(x);
            }
        }
        return result;

        function containedInEachOfRest(x) {
            for (const xs of rest) {
                if (!xs.includes(x)) {
                    return false;
                }
            }
            return true;
        }
    }
}