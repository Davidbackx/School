// Schrijf hier je code
function firstChar(string) {
    return string[0];
}

function lastChar(string) {
    return string[string.length - 1];
}

function isEmptyString(string) {
    if (string === "") {
        return true;
    }
    return false;
}

function formatTime(h, m, s, ms) {
    return `${h}:${m}:${s}.${ms}`;
}

function repeat(n, string) {
    let result = "";
    for (let i = 0; i < n; i++) {
        result += string;
    }
    return result;
}

function join(strings, separator) {
    let result = '';
    let isFirst = true;
    for (let string of strings) {
        if (isFirst) {
            result += string;
            isFirst = false;
        } else {
            result += separator + string;
        }
    }
    return result;
}

function prefix(str, n) {
    return str.substring(0, n);
}

function suffix(str, n) {
    return str.substr(str.length - n);
}

function startsWith(beginning, string) {
    return (prefix(string, beginning.length) === beginning);
}

function endsWith(ending, string) {
    return suffix(string, ending.length) === ending;
}

function isSubstringOf(substring, string) {
    for (let i = 0; i < string.length; i++) {
        if (startsWith(substring, string.substring(i))) {
            return true;
        }
    }
    return false;
}

function split(string, separator) {
    let result = [];
    let currentWord = '';
    for (let char of string) {
        if (isSeparator(char)) {
            finishWord();
        } else {
            addToCurrentWord(char);
        }
    }
    finishWord();
    return result;

    function isSeparator(char) {
        return char === separator;
    }

    function finishWord() {
        result.push(currentWord);
        currentWord = '';
    }

    function addToCurrentWord(char) {
        currentWord += char;
    }
}

function split2(string, separator) {
    let result = [];
    let currentWord = '';
    for (let char of string) {
        if (isSeparator(char)) {
            finishWord();
        } else {
            addToCurrentWord(char);
        }
    }
    finishWord();
    return result;

    function isSeparator(char) {
        return char === separator;
    }

    function finishWord() {
        if (currentWord.length > 0) {
            result.push(currentWord);
            currentWord = '';
        }
    }

    function addToCurrentWord(char) {
        currentWord += char;
    }
}

function split3(string, separators) {
    let result = [];
    let currentWord = '';
    for (let char of string) {
        if (isSeparator(char)) {
            finishWord();
        } else {
            addToCurrentWord(char);
        }
    }
    finishWord();
    return result;

    function isSeparator(char) {
        for (let separator of separators) {
            if (char === separator) {
                return true;
            }
        }
        return false;
    }

    function finishWord() {
        if (currentWord.length > 0) {
            result.push(currentWord);
            currentWord = '';
        }
    }

    function addToCurrentWord(char) {
        currentWord += char;
    }
}

function balanced(string) {
    let outward = getTimesSeparator(string, "(");
    let inward = getTimesSeparator(string, ")");

    return outward === inward;

    function getTimesSeparator(string, sep) {
        let result = 0;
        for (let str of string) {
            if (str === sep) {
                result++;
            }
        }
        return result;
    }
}
/*
function equalIgnoringSpaces(s1, s2) {
    if (removeSpaces(s1) === removeSpaces(s2)) {
        return true;
    }
    return false;

    function removeSpaces(string) {
        let result;
        for (let str in string) {
            if (!isSeparator(str)) {
                result += str;
            }
        }
        return result;
    }

    function isSeparator(char) {
        return char === " "
    }
}
*/

function equalIgnoringSpaces(s1, s2) {
    let i = next(s1, 0);
    let j = next(s2, 0);
    while (i < s1.length && j < s2.length) {
        if (s1[i] !== s2[j]) {
            return false;
        } else {
            i = next(s1, i + 1);
            j = next(s2, j + 1);
        }
    }
    return i === s1.length && j === s2.length;

    function next(str, i) {
        while (i < str.length && isWhitespace(str[i])) {
            ++i;
        }
        return i;
    }

    function isWhitespace(c) {
        return c === ' ';
    }
}