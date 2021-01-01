package main.exceptions;

public class IgraException extends Exception {
    public IgraException() {}

    public IgraException(String message) {
        super(message);
    }

    public IgraException(String message, Throwable cause) {
        super(message, cause);
    }

    public IgraException(Throwable cause) {
        super(cause);
    }
}