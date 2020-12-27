// Schrijf hier je code
function first (xs){
    return xs[0];
}

function last (xs){
    return xs[xs.length - 1];
}

function sum(ns){
    let som = 0;
    for (i = 0; i < ns.length; i++){
        som += ns[i];
    }
    return som;
}

function contains (value, xs){
    for (let i of xs){
        if (i === value){
            return true;;
        }
    }
    return false;
}

function all (bs){
    for (let i of bs){
        if (i === false){
            return false;
        }
    }
    return true;
}

function any (bs){
    for (let i of bs){
        if (i){
            return true;
        }
    }
    return false;
}

function repeat (n, x){
    const a = new Array(n);
    for (let i = 0; i < n; i++){
        a[i] = x;
    }
    return a;
}

function range (from, to){
    if (from > to){
        return [];
    } else {
        const ns = new Array(to - from + 1);

        for (let i = 0; i !== ns.length; i++){
            ns[i] = from + i;
        }
        return ns;
    }
}

function incrementEach (ns){
    if (ns !== []){
        for (let i = 0; i < ns.length; i++){
            ns[i] += 1;
        }
    }
}

function clamp (ns, min, max){
    for (let i = 0; i < ns.length; i++){
        if (ns[i] > max){
            ns[i] = max;
        }
        if (ns[i] < min){
            ns[i] = min;
        }
    }
}

function trimZeros(ns){
    while (ns.length > 0 && ns[0] === 0){
        ns.shift();
    }
    while (ns.length > 0 && last(ns) === 0){
        ns.pop();
    }   
}

function cut (xs, size){
    while (xs.length > size){
        xs.pop();
    }
}

function repeat2 (n, xs){
    let result = []
    for (let i = 0; i < n; i++){
        result = [...result,...xs];
    }
    return result;   
}

function count (value, xs) {
    let result = 0;
    for (let i of xs){
        if (value === i){
            result++;
        }
    }
    return result;
}

function minimum (ns){
    let minN = Number.POSITIVE_INFINITY;

    for (let i of ns){
        if (i < minN){
            minN = i;
        }
    }
    return minN;
}

function allEqual (xs){
    let firstValue = xs[0];

    for (let i of xs){
        if (i !== firstValue){
            return false;
        }
    }
    return true;
}

function allDifferent(xs) {
    for (let i = 0; i !== xs.length; ++i) {
        for (let j = i + 1; j < xs.length; ++j) {
            if (xs[i] === xs[j]) {
                return false;
            }
        }
    }
    return true;
}

function missingNumber (ns){
    const first =  ns[0];
    const last = ns[ns.length - 1];

    let expectedTotal = sum(range(first, last));
    let actualTotal = sum(ns);
    return expectedTotal - actualTotal;
}

function restaurant(entrees, mainCourses, desserts, budget) {
    let selection = [0, 0, 0];
    let selectionSum = 0;
    for (const entree of entrees) {
        for (const mainCourse of mainCourses) {
            for (const dessert of desserts) {
                const sum = entree + mainCourse + dessert;
                if (selectionSum < sum && sum <= budget) {
                    selection = [entree, mainCourse, dessert];
                    selectionSum = sum;
                }
            }
        }
    }
    return selection;
}