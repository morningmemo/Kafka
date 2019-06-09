package model.services.accounts;

import model.dao.accounts.AccountDaoFactory;

public class MemberAccountServiceFactory {
    private static AccountService accountService;
    public static synchronized AccountService getInstance() {
        if (accountService == null) {
            accountService = new KafkaMemberAccountService(
                    new MemberAccountService(AccountDaoFactory.getInstance())
            );
        }
        return accountService;
    }
}
