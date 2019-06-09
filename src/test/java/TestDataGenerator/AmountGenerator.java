package TestDataGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class AmountGenerator {
    public static long getRandomAmount() {
        return ThreadLocalRandom.current().nextLong(1, 100000);
    }
}
