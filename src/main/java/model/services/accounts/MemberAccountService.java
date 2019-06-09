package model.services.accounts;

import model.dao.accounts.AccountDao;
import model.entities.accounts.Account;
import model.entities.members.Member;

import java.util.Objects;

public class MemberAccountService implements AccountService {

    private AccountDao accountDao;

    public MemberAccountService( AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account open(Member member) {
        Account account = new Account(member);
        return accountDao.create(account);
    }

    @Override
    public boolean deposit(Account account, long amount) {
        Account newAccount = new Account(account);
        try {
            newAccount.increaseAmount(amount);
        } catch( IllegalArgumentException e) {
            return false;
        }

        if (accountDao.update(newAccount)) {
            account.increaseAmount(amount);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public boolean withdraw(Account account, long amount) {
        Account newAccount = new Account(account);
        try {
            newAccount.decreaseAmount(amount);
        } catch( IllegalArgumentException e) {
            return false;
        }

        if (accountDao.update(newAccount)) {
            account.decreaseAmount(amount);
        } else {
            return false;
        }

        return true;
    }

    @Override
    public boolean transfer(Account fromAccount, Account toAccount, long amount) {

        Account newFromAccount = new Account(fromAccount);
        Account newToAccount = new Account(toAccount);

        try {
            newFromAccount.decreaseAmount(amount);
        } catch( IllegalArgumentException e) {
            return false;
        }

        try {
            newToAccount.increaseAmount(amount);
        } catch( IllegalArgumentException e) {
            return false;
        }

        if (accountDao.update(newFromAccount) && accountDao.update(newToAccount)) {
            fromAccount.decreaseAmount(amount);
            toAccount.increaseAmount(amount);
        } else {
            return false;
        }

        return true;
    }

}
