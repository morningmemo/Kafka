package model.dao.accounts;

import model.dao.sql2o.Sql2oFactory;
import model.entities.accounts.Account;
import model.entities.members.Member;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class AccountSql2oDao implements AccountDao {
    private final Sql2o sql2o;

    public AccountSql2oDao(DataSource dataSource) {
        this.sql2o = Sql2oFactory.getInstance(dataSource);
    }

    @Override
    public Account create(Account account) {
        try (Connection conn = sql2o.open()) {
            Account newAccount = new Account(account);
            newAccount.setCreatedAt(LocalDateTime.now());

            conn.createQuery(
                    "insert into accounts(account_number, amount, created_at) VALUES (:accountNumber, :amount, :createdAt)",
                    true)
                    .bind(newAccount)
                    .executeUpdate();

            newAccount.getMember().setAccount(newAccount);

            return newAccount;
        }
    }

    @Override
    public boolean update(Account account) {
        try (Connection conn = sql2o.open()) {
            int rslt = conn.createQuery("update accounts set amount = :amount where account_number = :accountNumber")
                    .bind(account)
                    .executeUpdate()
                    .getResult();

            if (rslt == 1) {
                return true;
            }

            return false;
        }
    }
}
