package atm.exceptions;

public class ExceededBanknoteLimitException extends RuntimeException {
    public ExceededBanknoteLimitException() {
        super("Exceeded the limit of 30 banknotes for withdrawal.");
    }
}
