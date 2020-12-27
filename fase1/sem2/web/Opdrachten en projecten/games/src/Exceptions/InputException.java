package Exceptions;

public class InputException extends RuntimeException {
    public InputException (String message) {
        super(message + " is invalid");
    }

    public InputException () {
        super();
    }
}
