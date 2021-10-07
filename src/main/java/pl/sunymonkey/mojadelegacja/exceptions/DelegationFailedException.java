package pl.sunymonkey.mojadelegacja.exceptions;

public class DelegationFailedException extends RuntimeException{

    public DelegationFailedException(String message) {
        super(message);
    }
}
