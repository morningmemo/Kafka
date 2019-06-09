package model.entities.accounts.accountnumber;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleAccountNumberGenerator {
    public static String generateAccountNumber() {
        StringBuffer temp = new StringBuffer();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < 30; i++) {
            temp.append((rnd.nextInt(10)));
        }
        return temp.toString();
    }
}
