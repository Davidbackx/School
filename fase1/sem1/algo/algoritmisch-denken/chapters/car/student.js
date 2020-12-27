function forwardXTimes(bike, x){
    for (i = 0; i < x; i++){
        forward(bike);
    }
}

function myFirstFunction(bike){
    forward(bike);
}

function twiceForward(bike){
    forward(bike);
    forward(bike);
}

function thriceForward(bike){
    forwardXTimes(bike,3);
}

function forward4(bike){
    forwardXTimes(bike,4);
}

function forward5(bike){
    forwardXTimes(bike,5);
}

function forward10(bike){
    let i = 10;

    while (i > 0){
        forward(bike);
        i--;
    }
}
function right(bike){
    turnRight(bike);
    forward(bike);
}

function ellShape(bike){
    forward5(bike);
    right(bike);
    thriceForward(bike);
}

function uTurn(bike){
    thriceForward(bike);
    right(bike);
    forwardXTimes(bike,9);
    right(bike);
    forward(bike);
}

function forwardN(bike, steps){
    let i = steps;

    while (i > 0){
        forward(bike);
        i--;
    }
}

function crookedUTurn(bike) {
    forwardN(bike, 7);
    turnRight(bike);
    forwardN(bike, 9);
    turnRight(bike);
    forwardN(bike, 3);
}

function forwardUntilWall(bike){
    while (!sensor(bike)){
        forward(bike);
    }
}

function smartEllShape(bike){
    forwardUntilWall(bike);
    turnRight(bike);
    forwardUntilWall(bike);
}

function isDeadEnd(bike){
    if (!sensor(bike)){
        return false;
    }

    turnRight(bike);

    if (!sensor(bike)){
        return false;
    }
    
    turnRight(bike);
    turnRight(bike);

    if (!sensor(bike)){
        return false;
    }

    turnRight(bike);
    return true;
}

function spiral(bike){
    while (true){
        forwardUntilWall(bike);
        if (isDeadEnd(bike)){
            break;
        }
    }
}

function turnLeft(bike){
    turnRight(bike);
    turnRight(bike);
    turnRight(bike);
}

function left(bike){
    turnLeft(bike);
    forward(bike);
}

function canTurnRight(bike){
    turnRight(bike);
    
    if (sensor(bike)){
       turnLeft(bike);
       return false;
    }
    turnLeft(bike);
    return true;
}

function canTurnLeft(bike){
    turnLeft(bike);
    
    if (sensor(bike)){
       turnRight(bike);
       return false;
    }
    turnRight(bike);
    return true;
}

function canTurnBackward(bike){
    turnLeft(bike);
    turnLeft(bike);
    if (sensor(bike)){
       turnRight(bike);
       turnRight(bike);
       return false;
    }
    turnRight(bike);
    turnRight(bike);
    return true;
}

function slalom(bike){
    while (true){
        forwardUntilWall(bike);

        if (canTurnRight(bike)){
            turnRight(bike);
        }
        else if (canTurnLeft(bike)){
            turnLeft(bike);
        }
        

        if (isDeadEnd(bike)){
            break;
        }
    }
}

function leftOrRight(bike){
    slalom(bike);
}

function incompleteU (bike){
    forwardUntilWall(bike);
    turnRight(bike);
    forwardUntilWall(bike);
    turnRight(bike);
    forwardUntilWall(bike);
}

function whichDirection(bike){
    if (canTurnBackward(bike)){
        turnLeft(bike);
        turnLeft(bike);
    }
    else if (canTurnLeft(bike)){
        turnLeft(bike);
    }
    else if (canTurnRight(bike)){
        turnRight(bike);
    }
    
    forwardUntilWall(bike);
}

function sensorLeft(car) {
    turnLeft(car);
    let result = sensor(car);
    turnRight(car);

    return result;
}

function sensorRight(car) {
    turnRight(car);
    let result = sensor(car);
    turnLeft(car);

    return result;
}

function firstRight(car) {
    forwardUntilFreeRight(car);
    turnRight(car);
    forwardUntilWall(car);
}

function firstLeft(car) {
    while (sensorLeft(car)) {
        forward(car);
    }

    turnLeft(car);
    forwardUntilWall(car);
}

function zigZag(car) {
    firstRight(car);
    turnLeft(car);
    forward(car);
    firstLeft(car);
}

function forwardUntilFreeRight(car){
    while (sensorRight(car)){
        forward(car);
    }
}

function forwardUntilNthRight(car, nrights) {
    let i = nrights;

    while (i > 0) {
        forward(car);

        if (!sensorRight(car)) {
            i = i - 1;
        }
    }
}

function secondRight(car){
    forwardUntilNthRight(car, 2);
    turnRight(car);
    forwardUntilWall(car);   
}

function thirdRight (car){
    forwardUntilNthRight(car, 3);
    turnRight(car);
    forwardUntilWall(car); 
}

function fourthRight (car){
    forwardUntilNthRight(car, 4);
    turnRight(car);
    forwardUntilWall(car); 
}

function forwardUntilFreeLeft(car){
    while (sensorLeft(car)){
        forward(car);
    }
}

function forwardUntilNthLeft(car, nlefts) {
    let i = nlefts;

    while (i > 0) {
        forward(car);

        if (!sensorLeft(car)) {
            i = i - 1;
        }
    }
}

function fifthLeft (car){
    forwardUntilNthLeft(car, 5);
    turnLeft(car);
    forwardUntilWall(car);
}

function maze (car){
    R(2);
    L(1);
    L(2);
    L(2);
    R(4);
    R(1);
    L(3);
    forwardUntilWall(car);

    function L(x){
        forwardUntilNthLeft(car,x)
        turnLeft(car);
    }
    function R(x){
        forwardUntilNthRight(car,x);
        turnRight(car);
    }
}

function turnAround(car) {
    turnRight(car);
    turnRight(car);
}

function backward(car) {
    turnAround(car);
    forward(car);
    turnAround(car);
}

// Zelfde als isDeadEnd
function foundDeadEnd(car){
    if (!sensor(car)) {
        return false;
    }

    if (!sensorRight(car)) {
        return false;
    }

    if (!sensorLeft(car)) {
        return false;
    }

    return true;
}

function findDeadEnd(car){
    while (true){
        forward(car);

        if (isDeadEnd(car)){
            return;
        }

        backward(car);
        turnRight(car);
    }
}

function follow(car){
    while (true){
        if (isDeadEnd(car)){
            return;
        }
        
        forwardUntilWall(car);
        
        if (canTurnLeft(car)){
            turnLeft(car);
        }

        if (canTurnRight(car)){
            turnRight(car);
        }
    }
}

function rightHand(car) {
    while (!foundDeadEnd(car)) {
        if (!sensorRight(car)) {
            turnRight(car);
            forward(car);
        } else if (!sensor(car)) {
            forward(car);
        } else {
            turnLeft(car);
            forward(car);
        }
    }
}

function forwardUntilDestination(car){
    while (!destinationReached(car)){
        forward(car);
    }
}

function smartForwardUntilWall (car){
    while(!arrived()){
        forward(car);
    }
    return destinationReached(car);

    function arrived(){
        if (sensor(car)){
            return true;
        }

        if (destinationReached(car)){
            return true;
        }

        return false;
    }
}

function roomba (car){
    while (true){
        if (smartForwardUntilWall(car)){
            return;
        }

        turnRight(car);
        forward(car);
        turnRight(car);

        if (smartForwardUntilWall(car)) {
            return;
        }

        turnLeft(car);
        forward(car);
        turnLeft(car);
   }
}

