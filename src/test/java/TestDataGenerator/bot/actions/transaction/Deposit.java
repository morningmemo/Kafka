package TestDataGenerator.bot.actions.transaction;

import TestDataGenerator.AmountGenerator;
import TestDataGenerator.bot.Bot;
import TestDataGenerator.bot.actions.ActionBase;
import model.entities.accounts.Account;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.accounts.MemberAccountServiceFactory;

public class Deposit extends ActionBase implements Transaction {
    Deposit(Bot bot) {
        super(bot);
    }

    @Override
    public void action() {
        AccountService as = MemberAccountServiceFactory.getInstance();

        Member member = getBot().getSession().getMember();
        Account account = member.getAccount();
        if ( account != null) {
            as.deposit(account, AmountGenerator.getRandomAmount());
        }
    }
}
