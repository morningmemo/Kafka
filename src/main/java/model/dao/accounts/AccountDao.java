package model.dao.accounts;

import model.entities.accounts.Account;
import model.entities.members.Member;

import java.util.Optional;

public interface AccountDao {
    public Account create(Account account);
    public boolean update(Account account);
//    public Optional<Account> get(Member member);
}
