const ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

function choices(nChoices) {
    if (nChoices < 1 || nChoices > 26) {
        return undefined;
    }
    let result = "";
    for (let i = 0; i < nChoices; i++) {
        result += ALFABET[i];
    }
    return result;
}

function isValidAnswer(answer, nChoices) {
    if (answer === "?") {
        return true;
    }
    let cho = choices(nChoices);
    for (let i = 0; i < nChoices; i++) {
        if (answer === cho[i]) {
            return true;
        }
    }
    return false;
}

function isValidExam(answers, nChoices) {
    for (let i = 0; i < answers.length; i++) {
        if (!isValidAnswer(answers[i], nChoices)) {
            return false;
        }
    }
    return true;
}

function grade(expected, actual, penalty) {
    if (expected === actual) {
        return 1;
    }
    if (actual === "?") {
        return 0;
    }
    return penalty;
}

function gradeStudent(expected, actual, penalty) {
    let grades = [];
    for (let i = 0; i < actual.length; i++) {
        grades.push(grade(expected[i], actual[i], penalty));
    }
    return grades;
}

function gradeClass(expected, actual, penalty) {
    let students = [];
    for (let i = 0; i < actual.length; i++) {
        students.push(gradeStudent(expected, actual[i], penalty));
    }
    return students;
}

function totalForStudent(gradeMatrix, studentIndex) {
    let som = 0;
    for (let i = 0; i < gradeMatrix[studentIndex].length; i++) {
        som += gradeMatrix[studentIndex][i];
    }
    let grade = Math.round(som / gradeMatrix[studentIndex].length * 20);
    if (grade < 0) {
        return 0;
    }
    return grade;
}

function countCorrectAnswers(gradeMatrix, questionIndex) {
    let correctAnswers = 0;
    for (let i = 0; i < gradeMatrix[0].length; i++) {
        if (gradeMatrix[i] === undefined) continue;
        if (gradeMatrix[i][questionIndex] === 1) correctAnswers++;
    }

    return correctAnswers;
}

function easiestQuestions(gradeMatrix) {
    let mostSolves = 0
    let ns = []
    let xs = []

    for (i in gradeMatrix[0]) {
        let counter = 0

        for (j in gradeMatrix) {
            if (gradeMatrix[j][i] == 1) {
                counter++
            }
        }
        if (counter > mostSolves) {
            mostSolves = counter;
        }
    }
    for (i in gradeMatrix[0]) {
        let counter2 = 0
        for (j in gradeMatrix) {
            if (gradeMatrix[j][i] == 1) {
                counter2++
            }
        }
        if (counter2 == mostSolves) {
            ns.push(i);
        }
    }

    for (i of ns) {
        xs.push(Number(i))
    }

    return xs
}