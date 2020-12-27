function allPositive (ns){
   for (let i = 0; i < ns.length; i++){
       if (ns[i] < 0) {
           return false
        }
   }
   return true;
}

function allNegative (ns){
    for (let i = 0; i < ns.length; i++){
        if (ns[i] > 0) {
            return false
         }
    }
    return true;
 }

 function allOdd (ns){
    for (let i = 0; i < ns.length; i++){
        if (ns[i] % 2 == 0) {
            return false
         }
    }
    return true;
 }

 function all(xs, check) {
    for (let x of xs) {
        if (!check(x)) {
            return false;
        }
    }
    return true;
}

 function any (xs, check){
    for (let x of xs) {
        if (check(x)) {
            return true;
        }
    }
    return false;
 }

 function contains (xs, value){
     return any(xs, equalsValue)

     function equalsValue (x){
         return x === value;
     }
 }

 function isLowerBound(ns, k) {
   return all(ns, n => k <= n);
}

function isUpperBound(ns, k) {
   return all(ns, n => k >= n);
}

function allEqual(xs) {
    return xs.length === 0 || all(xs.slice(1), x => x === xs[0]);
}

function isSubset(xs, ys) {
    return all(xs, x => any(ys, y => x === y));
}
 

function findFirst (xs, check) {
    for (let x of xs){
        if (check(x)){
            return x;
        }
    }
    return undefined;
}

function minimum (ns){
    return findFirst(ns, min => isLowerBound(ns, min));
}

function findIndexOfFirst(xs, check){
    for (let i = 0; i < xs.length; i++){
        if (check(xs[i])){
            return i;
        }
    }
    return undefined;
}

function ranking(ns, n) {
    return 1 + findIndexOfFirst([...ns, Number.NEGATIVE_INFINITY], k => n > k);
}
