package exception.logicException.garageException;

public class GarageException extends Exception {
    public GarageException() {
        super();
    }

    public GarageException(String message) {
        super(message);
    }

    public GarageException(String message, Throwable cause) {
        super(message, cause);
    }

    public GarageException(Throwable cause) {
        super(cause);
    }
}
