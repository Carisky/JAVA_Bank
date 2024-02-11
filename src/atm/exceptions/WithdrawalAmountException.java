package atm.exceptions;

public class WithdrawalAmountException extends RuntimeException {
    public WithdrawalAmountException() {
        super("Withdrawal amount cannot be less than the minimum withdrawal limit");
    }
}
