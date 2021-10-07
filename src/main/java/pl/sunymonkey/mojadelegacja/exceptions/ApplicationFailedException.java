package pl.sunymonkey.mojadelegacja.exceptions;

public class ApplicationFailedException extends RuntimeException{

    public ApplicationFailedException(String message) {
        super(message);
    }
}
