package TestDataGenerator.bot.actions;

import TestDataGenerator.bot.Bot;

abstract public class ActionBase implements Action {
    private final Bot bot;

    public ActionBase(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return bot;
    }
}
