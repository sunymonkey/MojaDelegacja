package pl.sunymonkey.mojadelegacja.exceptions;

public class ExpensesFailedException extends RuntimeException {
    public ExpensesFailedException(String expenses_not_correct) {
        super(expenses_not_correct);
    }
}
