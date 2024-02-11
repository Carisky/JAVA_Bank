package atm;

import atm.exceptions.ExceededBanknoteLimitException;
import atm.exceptions.InsufficientBanknotesException;
import atm.exceptions.WithdrawalAmountException;
import banknote.Banknote;
import banknotes_colection.Banknotes;

import java.util.Iterator;

public class ATM {
    private final Banknotes banknotes = new Banknotes();
    private final int MINIMAL_WITHDRAW = 200;

    public ATM(){

    }
    public ATM(int amount) {
        int tmp_amount = amount;
        do {
            Banknote banknote = new Banknote();

            amount-=banknote.getValue();
            if (amount>=0) {
                tmp_amount = amount;
                banknotes.add(banknote);
            }else {
                amount = tmp_amount;
            }

        }while (amount>0);


    }
    public void withdraw(int amount) {
        try {
            if (amount < MINIMAL_WITHDRAW) {
                throw new WithdrawalAmountException();
            }

            banknotes.sortDESC();
            int remainingAmount = amount;
            int banknoteCount = 0; // Variable to keep track of the number of banknotes withdrawn
            Iterator<Banknote> iterator = banknotes.iterator();

            while (iterator.hasNext() && remainingAmount > 0 && banknoteCount < 30) {
                Banknote banknote = iterator.next();
                if (banknote.getValue() <= remainingAmount) {
                    remainingAmount -= banknote.getValue();
                    iterator.remove(); // Remove the banknote from the collection
                    banknoteCount++;
                }
            }

            if (remainingAmount > 0) {
                throw new InsufficientBanknotesException();
            } else if (banknoteCount == 30) {
                throw new ExceededBanknoteLimitException();
            } else {
                System.out.println("Withdrawal successful. Remaining balance: " + this.banknotes.getAmount());
            }

        } catch (WithdrawalAmountException | InsufficientBanknotesException | ExceededBanknoteLimitException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public void putMoney(int amount){
        int tmp_amount = amount;
        do {
            Banknote banknote = new Banknote();

            amount-=banknote.getValue();
            if (amount>=0) {
                tmp_amount = amount;
                banknotes.add(banknote);
            }else {
                amount = tmp_amount;
            }

        }while (amount>0);
        System.out.println("balance after put money "+banknotes.getAmount());
    }

    public void showMoneyAmount() {
        System.out.println(banknotes.getAmount());
    }
    public void showCountBanknotes() {
        banknotes.sortASC();
        banknotes.countBanknotes();
    }
}
