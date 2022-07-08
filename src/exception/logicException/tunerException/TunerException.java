package exception.logicException.tunerException;

public class TunerException extends Exception{
    public TunerException() {
        super();
    }

    public TunerException(String message) {
        super(message);
    }

    public TunerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TunerException(Throwable cause) {
        super(cause);
    }
}
