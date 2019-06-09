package TestDataGenerator.bot;

import java.util.concurrent.ThreadLocalRandom;

public class BotContainer {
    private final int TOTAL_BOTS = 50000;
    private Bot[] bots = new Bot[TOTAL_BOTS];
    private static BotContainer botContainer = new BotContainer();

    private BotContainer() {
        for (int i = 0; i < TOTAL_BOTS; i++) {
            bots[i] = new CustomerBot();
        }
    };

    public static BotContainer getBotContainer() {
        return botContainer;
    }

    public synchronized Bot getBot() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int idx = threadLocalRandom.nextInt(0, TOTAL_BOTS);

        Bot bot = bots[idx];
        if (!bot.isAvailable()) {
            return getBot();
        }

        bot.setInUse();

        return bot;
    }
}
