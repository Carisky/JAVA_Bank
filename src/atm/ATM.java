package atm;

import atm.exceptions.InsufficientBanknotesException;
import atm.exceptions.WithdrawalAmountException;
import banknote.Banknote;
import banknotes_colection.Banknotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ATM {
    private Banknotes banknotes;
    private final int minimal_withdraw = 200;
    public ATM() {
        banknotes = new Banknotes();
    }

    public ATM(int amount) {
        banknotes = new Banknotes();
        int tmp_amount = amount;
        do {
            Banknote banknote = new Banknote();

            amount-=banknote.getValue();
            if (amount>=0) {
                tmp_amount = amount;
                banknotes.add(banknote);
            }else if (amount<=0){
                amount = tmp_amount;
            }

        }while (amount>0);


    }
    public void withdraw(int amount) {
        try {
            if (amount < minimal_withdraw) {
                throw new WithdrawalAmountException();
            }
            banknotes.sortDESC();
            int remainingAmount = amount;
            Iterator<Banknote> iterator = banknotes.iterator();

            while (iterator.hasNext() && remainingAmount > 0) {
                Banknote banknote = iterator.next();
                if (banknote.getValue() <= remainingAmount) {
                    remainingAmount -= banknote.getValue();
                    iterator.remove(); // Remove the banknote from the collection
                }
            }

            if (remainingAmount > 0) {
                throw new InsufficientBanknotesException();
            } else {
                System.out.println("Withdrawal successful. Remaining balance: " + this.banknotes.getAmount());
            }

        } catch (WithdrawalAmountException | InsufficientBanknotesException exception) {
            System.out.println(exception.getMessage());
        }
    }


    public void showMoneyAmount() {
        System.out.println(banknotes.getAmount());
    }
    public void showCountBanknotes() {
        banknotes.sortASC();
        banknotes.countBanknotes();
    }
}
