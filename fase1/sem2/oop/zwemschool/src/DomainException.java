public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
    public DomainException(String message, Exception exception) {
        super(message, exception);
    }
    public DomainException() {
        super();
    }
}
