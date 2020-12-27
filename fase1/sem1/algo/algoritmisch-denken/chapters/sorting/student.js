function swap(xs, i, j) {
    const temp = xs[i];
    xs[i] = xs[j];
    xs[j] = temp;
}

function bubbleSort(ns) {
    let madeChange = true;
    while (madeChange) {
        madeChange = false;
        for (let i = 1; i < ns.length; i++) {
            const a = ns[i - 1];
            const b = ns[i];
            if (a > b) {
                swap(ns, i - 1, i);
                madeChange = true;
            }
        }
    }
}

function inPlaceSelectionSort(ns) {
    let insertionIndex = 0;
    while (insertionIndex !== ns.length) {
        let minimumIndex = insertionIndex;
        for (let i = insertionIndex + 1; i < ns.length; i++) {
            if (ns[i] < ns[minimumIndex]) {
                minimumIndex = i;
            }
        }
        swap(ns, insertionIndex, minimumIndex);
        insertionIndex++;
    }
}

function indexOfMinimum(ns) {
    let minimumIndex = 0;
    for (let i = 1; i < ns.length; ++i) {
        if (ns[i] < ns[minimumIndex]) {
            minimumIndex = i;
        }
    }
    return minimumIndex;
}

function removeAt(xs, i) {
    const left = xs.slice(0, i);
    const right = xs.slice(i + 1);
    return [...left, ...right];
}

function selectionSort(ns) {
    if (ns.length === 0) {
        return [];
    } else {
        const minimumIndex = indexOfMinimum(ns);
        const minimum = ns[minimumIndex];
        const rest = removeAt(ns, minimumIndex);
        const sortedRest = selectionSort(rest);
        return [minimum, ...sortedRest];
    }
}

function orderedInsert(ns, n) {
    let i = 0;
    while (i < ns.length && n > ns[i]) {
        ++i;
    }
    const left = ns.slice(0, i);
    const right = ns.slice(i);
    return [...left, n, ...right];
}

function insertionSort(ns) {
    if (ns.length === 0) {
        return [];
    } else {
        const first = ns[0];
        const rest = ns.slice(1);
        const sortedRest = insertionSort(rest);
        return orderedInsert(sortedRest, first);
    }
}