package TestDataGenerator.bot.actions.transaction;

import TestDataGenerator.bot.Bot;

import java.util.function.Function;

public enum TransactionTypes {
    DEPOSIT(Deposit::new),
    TRANSFER(Transfer::new),
    WITHDRAW(Withdraw::new);

    private final Function<Bot, Transaction> constructor;

    TransactionTypes(Function<Bot, Transaction> constructor) {
        this.constructor = constructor;
    }

    public Transaction newInstance(Bot bot) {
        return constructor.apply(bot);
    }
}
