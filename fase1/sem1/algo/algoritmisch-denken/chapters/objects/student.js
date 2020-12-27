function getAge(person) {
    return person.age;
}

function bmi(person) {
    return Math.round(person.weight / (person.length / 100) ** 2);
}

function paternalAncestor(person, n) {
    while (n > 0) {
        person = person.father;
        --n;
    }
    return person.name;
}

function substitute(xs, dictionary) {
    const result = new Array(xs.length);
    for (let i = 0; i !== xs.length; ++i) {
        result[i] = dictionary[xs[i]];
    }
    return result;
}

function cycle(obj, start) {
    const result = [start];
    let current = obj[start];
    while (current !== start) {
        result.push(current);
        current = obj[current];
    }
    return result;
}

function keys(obj) {
    const result = [];
    for (o in obj) {
        result.push(o);
    }
    return result;
}

function values(obj) {
    const result = [];
    for (key in obj) {
        result.push(obj[key]);
    }
    return result;
}

function fixedPoints(obj) {
    const result = [];
    for (key in obj) {
        if (obj[key] == key) {
            result.push(obj[key]);
        }
    }
    return result;
}

function commonKeys(x, y) {
    const result = [];
    for (const key in x) {
        if (key in y) {
            result.push(key);
        }
    }
    return result;
}

function frequencies(xs) {
    const result = {};
    for (let x of xs) {
        if (!(x in result)) {
            result[x] = 0;
        }
        result[x]++;
    }
    return result;
}

function copy(obj) {
    const copy = {};
    for (const key in obj) {
        const value = obj[key];
        copy[key] = value;
    }
    return copy;
}

function update(obj, key, value) {
    const result = copy(obj);
    result[key] = value;
    return result;
}

function merge(x, y) {
    const result = copy(x);
    for (const key in y) {
        const value = y[key];
        result[key] = value;
    }
    return result;
}

function findTranslation(xs, ys) {
    const result = {};
    for (let i = 0; i !== xs.length; ++i) {
        const x = xs[i];
        const y = ys[i];
        if (x in result) {
            if (result[x] !== y) {
                return undefined;
            }
        } else {
            result[x] = y;
        }
    }
    return result;
}

function containsCycle(obj, start) {
    let hare = start;
    let turtle = start;
    while (hare && turtle) {
        turtle = obj[turtle];
        hare = obj[obj[hare]];
        if (turtle === hare) {
            return true;
        }
    }
    return false;
}