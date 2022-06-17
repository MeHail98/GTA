package exception.logicException.partException;

public class PartException extends Exception {
    public PartException() {
        super();
    }

    public PartException(String message) {
        super(message);
    }

    public PartException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartException(Throwable cause) {
        super(cause);
    }
}
