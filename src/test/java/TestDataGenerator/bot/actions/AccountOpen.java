package TestDataGenerator.bot.actions;

import TestDataGenerator.bot.Bot;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.accounts.MemberAccountServiceFactory;

// TODO :: 계좌개설 transaction
public class AccountOpen extends ActionChain {
    AccountOpen(Bot bot) {
        super(bot, null);
    }

    @Override
    public void doAction() {
        AccountService as = MemberAccountServiceFactory.getInstance();

        Member member = getBot().getSession().getMember();
        as.open(member);
    }
}
