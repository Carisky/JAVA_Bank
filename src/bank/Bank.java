package bank;

import atm.ATM;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private final ArrayList<ATM> ATMS = new ArrayList<ATM>();
    public Bank(int atm_count){
        for(int i = 0; i < atm_count; i++) {
            int randomValue = new Random().nextInt(4,11);
            ATMS.add(new ATM(randomValue*10000));
        }
    }
    public void work() {
        if (ATMS.isEmpty()) {
            System.out.println("No ATMs available in the bank.");
            return;
        }

        Random random = new Random();
        int randomATMIndex = random.nextInt(ATMS.size());
        ATM selectedATM = ATMS.get(randomATMIndex);

        // Randomly choose whether to withdraw or put money
        boolean withdrawOperation = random.nextBoolean();


        System.out.print("ATM "+randomATMIndex+" ");
        if (withdrawOperation) {
            int randomWithdrawAmount = random.nextInt(1, 6500); // Adjust the range as needed
            selectedATM.withdraw(randomWithdrawAmount);
        } else {
            int randomPutMoneyAmount = random.nextInt(1, 10000); // Adjust the range as needed
            selectedATM.putMoney(randomPutMoneyAmount);
        }
    }
}
