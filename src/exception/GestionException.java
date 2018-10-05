package exception;

public class GestionException extends Exception {

    public GestionException() {
    }

    public GestionException(String message) {
        super(message);
    }

    public GestionException(Throwable cause) {
        super(cause);
    }

    public GestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public GestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}