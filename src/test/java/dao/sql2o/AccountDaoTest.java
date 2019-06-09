package dao.sql2o;

import model.dao.accounts.AccountDao;
import model.dao.accounts.AccountDaoFactory;
import model.dao.members.MemberDao;
import model.dao.members.MemberDaoFactory;
import model.entities.accounts.Account;
import model.entities.members.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AccountDaoTest {
    private static MemberDao memberDao;
    private static AccountDao accountDao;

    @BeforeAll
    public static void setUp() {
        accountDao = AccountDaoFactory.getInstance();
        memberDao = MemberDaoFactory.getInstance();
    }

    @Test
    public void createTest() {
        Member member = new Member();

        member.setName("이종현");
        member.setDateOfBirth(LocalDate.of(1988,3,12));

        Member newMember = memberDao.create(member);

        assertEquals(newMember.getId(), 1);

        Account account = new Account(newMember);
        accountDao.create(account);
    }

    @Test
    public void updateTest() {
        Member member = new Member();

        member.setName("이종현");
        member.setDateOfBirth(LocalDate.of(1988,3,12));

        Member newMember = memberDao.create(member);

        assertEquals(newMember.getId(), 1);

        Account account = new Account(newMember);
        accountDao.create(account);

        account.increaseAmount(231000);
        assertTrue(accountDao.update(account));

        assertEquals(account.getAmount(), 231000);

        assertThrows(IllegalArgumentException.class, () -> account.decreaseAmount(2131414214));

        assertEquals(account.getAmount(), 231000);

        account.decreaseAmount(1000);
        assertEquals(account.getAmount(), 230000);
        assertTrue(accountDao.update(account));
        assertEquals(account.getAmount(), 230000);
    }
}
