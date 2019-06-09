package model.dao.accounts;

import model.dao.sql2o.DataSourceFactory;

public class AccountDaoFactory {
    private static AccountDao accountDao;
    public static synchronized AccountDao getInstance() {
        if (accountDao == null) {
            accountDao = new AccountSql2oDao(DataSourceFactory.getInstance());
        }
        return accountDao;
    }
}
