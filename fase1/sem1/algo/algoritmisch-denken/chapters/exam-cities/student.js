function isValidDistanceMatrix(nss) {
    if (nss.length < 1 || nss[0].length < 1) return false;
    if (nss.length !== nss[0].length) {
        return false;
    }
    for (let i = 0; i < nss.length; i++) {
        for (let j = 0; j < nss.length; j++) {
            if (nss[i][j] !== nss[j][i]) {
                return false;
            }
        }
    }
    return isValidDiagonal(nss);

    function isValidDiagonal(nss) {
        let index = 0;
        for (let i = 0; i < nss.length; i++) {
            if (nss[i][index] !== 0) {
                return false;
            }
            index++;
        }
        return true;
    }
}

// Hulpfunctie
function cityIndex(cities, string) {
    for (let i = 0; i < cities.length; i++) {
        if (cities[i] === string) {
            return i;
        }
    }
    return -1;
}

function distance(distances, cities, from, to) {
    if (from === to) return 0;

    let i = cityIndex(cities, from);
    let j = cityIndex(cities, to);
    if (i === -1 || j === -1) {
        return -1
    }
    else {
        return distances[i][j];
    }
}

function areValidCities(cities, itinerary) {
    for (c of itinerary) {
        if (cityIndex(cities, c) === -1) return false;
    }
    return true;
}

function pairs(xs) {
    if (xs.length <= 1) {
        return [];
    }
    else {
        let pair = [xs[0], xs[1]];
        return [pair, ...pairs(xs.slice(1))]
    }
}

// Hulpfunctie
function validPath(distances, cities, path) {
    if (distance(distances, cities, path[0], path[1]) === -1) return false;
    return true;
}

function isValidItinerary(distances, cities, itinerary) {
    if (!areValidCities(cities, itinerary)) return false;

    let paths = pairs(itinerary);
    for (path of paths) {
        if (!validPath(distances, cities, path)) return false;
    }
    return true;
}

function totalDistance(distances, cities, itinerary) {
    if (!isValidItinerary(distances, cities, itinerary)) return -1;
    let paths = pairs(itinerary);
    let totalDistance = 0;
    for (path of paths) {
        totalDistance += distance(distances, cities, path[0], path[1]);
    }
    return totalDistance;
}

function reachableFrom(distances, cities, from) {
    let result = {};
    for (let i = 0; i < cities.length; i++) {
        let city = cities[i];
        let dis = distance(distances, cities, from, city);
        if (dis !== 0 && dis !== -1) {
            result[city] = dis;
        }
    }
    return result;
}

function expand(distances, cities, itinerary) {
    let result = [];
    const ns = itinerary["path"];
    let from = ns[ns.length - 1];

    let paths = [];
    for (let key in reachableFrom(distances, cities, from)) {
        paths = [...paths, ...key];
    }

    for (let i of paths) {
        let distancePair = { distance: itinerary["distance"] + distance(distances, cities, from, i) };
        let pathPair = { path: [...ns, i] }
        result.push({ ...distancePair, ...pathPair });
    }
    return result;
}

function insert(queue, itinerary) {
    let i = 0;
    while (queue.length > i && itinerary.distance > queue[i].distance) {
        i++;
    }
    let left = queue.slice(0, i);
    let right = queue.slice(i);
    return [...left, itinerary, ...right];
}

function shortestPath(distances, cities, from, to) {
    let queue = [{ distance: 0, path: [from] }];

    while (queue.length != 0) {
        let current = queue.shift();
        if (current.path[current.path.length - 1] === to) {
            return current.path;
        }
        else {
            let paths = expand(distances, cities, current);
            for (p of paths) {
                queue = insert(queue, p);
            }
        }
    }
    return [];
}