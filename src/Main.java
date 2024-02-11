import atm.ATM;
import bank.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(10);

        while (true) {
            bank.work();

            try {
                Thread.sleep(650);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
