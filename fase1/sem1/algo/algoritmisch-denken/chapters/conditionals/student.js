// Schrijf hier je code
function min2 (x, y){
    if (x < y){
        return x;
    }else{
        return y;
    }
}

function abs (n){
    if (n < 0){
        return -n;
    }else{
        return n
    }
}

function sign (n){
    if (n == 0){
        return 0
    }
    else if (n > 0){
        return 1
    }
    else if (n < 0){
        return -1
    }
}

function has31Days(month){
    return month === 1 || month === 3 || month === 5 || month === 7 || month === 8 || month === 10 || month === 12
}

function has28Days(month,year){
    return month == 2 && !isLeapYear(year)
}

function has29Days (month, year){
    return month == 2 && isLeapYear(year)
}

function has30Days(month){
    return month === 4 || month === 6 || month === 9 || month === 11
}

function isDivisibleBy(x,y){
    return x % y === 0;
}

function isLeapYear(year){
    return isDivisibleBy(year, 4) && !isDivisibleBy(year, 100) || isDivisibleBy(year,400)
}

function daysInMonth (month, year){
    if (has31Days(month)) {
        return 31;
    }
    else if (has30Days(month)) {
        return 30;
    }
    else if (has29Days(month, year)) {
        return 29;
    }
    else if (has28Days(month, year)) {
        return 28;
    }
    else {
        return -1;
    }
}

function is10OrMore(x){
    if (x >= 10){
        return true
    }
    return false;
}

function passPercentage (a, b, c){
    let aantalGeslaagt = 0
    if (is10OrMore(a)){
        aantalGeslaagt++;
    }
    if (is10OrMore(b)){
        aantalGeslaagt++;
    }
    if (is10OrMore(c)){
        aantalGeslaagt++;
    }

    return Math.round((aantalGeslaagt) / 3 * 100)
}

function democracy (a, b, c, d, e){
    let against = 0;
    if (!a){
        against++;
    }
    if (!b){
        against++;
    }
    if (!c){
        against++;
    }
    if (!d){
        against++;
    }
    if (!e){
        against++;
    }

    return against < (5 - against)

}

function totalOrderCost(amount){
    if (amount < 100){
        amount += 10;
    }

    if (amount >= 200){
        amount *= 0.9;
    }
    return amount;
}

function quadrants(x, y){
    if (x == 0 || y == 0){
        return 0;
    }
    if (x > 0 && y > 0){
        return 1;
    }
    if (x < 0 && y < 0){
        return 3
    }
    if (x > 0 && y < 0){
        return 2;
    }
    if (x < 0 && y > 0){
        return 4;
    }
}

