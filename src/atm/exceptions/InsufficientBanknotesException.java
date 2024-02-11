package atm.exceptions;

public class InsufficientBanknotesException extends RuntimeException {
    public InsufficientBanknotesException() {
        super("Insufficient banknotes to cover the withdrawal amount.");
    }
}
