package TestDataGenerator.bot.actions.transaction;

import TestDataGenerator.bot.Bot;

import java.util.concurrent.ThreadLocalRandom;

public class TransactionRandomGenerator {

    public static Transaction generateTransaction(Bot bot) {
        TransactionTypes[] transactionTypes = TransactionTypes.values();
        TransactionTypes transactionType = transactionTypes[
                ThreadLocalRandom.current().nextInt(
                        0,
                        transactionTypes.length
                )
            ];

        System.out.println(transactionType);

        return transactionType.newInstance(bot);
    }
}
