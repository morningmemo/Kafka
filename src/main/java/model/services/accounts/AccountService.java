package model.services.accounts;

import model.entities.accounts.Account;
import model.entities.members.Member;

public interface AccountService {
    public Account open(Member member);
    public boolean deposit(Account account, long amount);
    public boolean withdraw(Account account, long amount);
    public boolean transfer(Account fromAccount, Account toAccount, long amount);
}
