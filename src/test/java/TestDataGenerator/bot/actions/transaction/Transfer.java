package TestDataGenerator.bot.actions.transaction;

import TestDataGenerator.AmountGenerator;
import TestDataGenerator.bot.Bot;
import TestDataGenerator.bot.actions.ActionBase;
import TestDataGenerator.bot.actions.ActionChain;
import model.entities.accounts.Account;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.accounts.MemberAccountServiceFactory;

public class Transfer extends ActionBase implements Transaction {
    Transfer(Bot bot) {
        super(bot);
    }

    @Override
    public void action() {

    }
}
