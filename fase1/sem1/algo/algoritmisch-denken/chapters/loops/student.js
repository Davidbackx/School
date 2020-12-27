// Schrijf hier je code
function sum(n) {
    let i = 1;
    let sum = 0;
    while (i <= n) {
        sum += i;
        i++;
    }
    return sum;
}

function sumRange(from, to) {
    let i = 0;
    let sum = 0;
    while (from <= to) {
        sum += from;
        from++;
    }
    return sum;
}

function factorial(n) {
    let result = 1;
    let i = 2;

    while (i <= n) {
        result *= i;
        i++;
    }

    return result;
}

function multiply(a, b) {
    let i = 0;
    let result = 0;
    while (i < b) {
        result += a;
        i++;
    }
    return result;
}

function power(a, b) {
    let i = 0;
    let result = 1;
    while (i < b) {
        result *= a;
        i++;
    }
    return result;
}

function thanos(population, target) {
    let vingerknip = 0;

    while (population > target) {
        population = Math.ceil(population / 2);
        vingerknip++;
    }
    return vingerknip;
}

function amazon(n) {
    let a = 50;
    let b = 50;
    while (n > 0) {
        const nextA = b * 0.95;
        const nextB = a * 1.1;
        a = nextA;
        b = nextB;
        n--;
    }
    return b;
}

function lastDigit(n) {
    return n % 10;

}

function dropLastDigit(n, digit) {
    return (n - digit) / 10;
}

function digitSum(n) {
    let i = 0;
    let current = n;
    let sum = 0;
    while (i < n) {
        const ld = lastDigit(current);
        sum += lastDigit(current)
        current = dropLastDigit(current, lastDigit(current));
        i++;
    }
    return sum;
}

function divisibleBy3(n) {
    while (n >= 10) {
        n = digitSum(n);
    }
    return n === 0 || n === 3 || n === 6 || n === 9;
}

function sum2(n) {
    let sum = 0;
    for (let i = 0; i <= n; i++) {
        sum += i;
    }
    return sum;
}


function factorial2(n) {
    let result = 1;

    for (let i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}

function fibonacci(n) {
    let a = 1, b = 0;

    for (i = 0; i < n; i++) {
        const next = a + b;
        a = b
        b = next;
    }
    return a;
}

function countDivisors(n) {
    let count = 1;
    for (i = 0; i < n; i++) {
        if (n % i == 0) {
            count++;
        }
    }
    return count;
}

function isDivisorOf(x, y) {
    return y % x === 0;
}

function gcd(x, y) {
    const start = Math.min(x, y);
    for (let i = start; i > 1; --i) {
        if (isDivisorOf(i, x) && isDivisorOf(i, y)) {
            return i;
        }
    }
    return 1;
}

function lcm(x, y) {
    let i = Math.max(x, y);
    while (!isDivisorOf(x, i) || !isDivisorOf(y, i)) {
        ++i;
    }
    return i;
}

function dice2(targetSum) {
    let count = 0;
    for (x = 1; x <= 6; x++) {
        for (y = 1; y <= 6; y++) {
            if (x + y === targetSum) {
                count++;
            }
        }
    }
    return count;
}

function dice3(targetSum) {
    let count = 0;
    for (x = 1; x <= 6; x++) {
        for (y = 1; y <= 6; y++) {
            for (i = 1; i <= 6; i++) {
                if (x + y + i === targetSum) {
                    count++;
                }
            }
        }
    }
    return count;
}

function isPrime(n) {
    if (n <= 1) {
        return false;
    }
    for (let i = 2; i < n; i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

function countPrimes(n) {
    let count = 0;
    for (i = 0; i <= n; i++) {
        if (isPrime(i)) {
            count++;
        }
    }
    return count;
}

