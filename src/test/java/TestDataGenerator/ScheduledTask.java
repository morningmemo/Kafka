package TestDataGenerator;

import TestDataGenerator.bot.Bot;
import TestDataGenerator.bot.BotContainer;

import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

class ScheduledTask extends TimerTask {

    private static BotContainer botContainer = BotContainer.getBotContainer();

    @Override
    public synchronized void run() {
        Bot bot = botContainer.getBot();
        bot.action();
        bot.release();
    }
}