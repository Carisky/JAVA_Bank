import atm.ATM;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(20000);
        atm.showMoneyAmount();
        atm.showCountBanknotes();
        atm.withdraw(20020);
        atm.showCountBanknotes();
    }
}