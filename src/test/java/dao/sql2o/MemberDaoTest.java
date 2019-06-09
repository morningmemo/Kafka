package dao.sql2o;

import model.dao.members.MemberDao;
import model.dao.members.MemberDaoFactory;
import model.entities.members.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberDaoTest {
    private MemberDao memberDao;

    @BeforeAll
    public void setUp() {
        memberDao = MemberDaoFactory.getInstance();
    }

    @Test
    public void createTest() {
        Member member = new Member();

        member.setName("이종현");
        member.setDateOfBirth(LocalDate.of(1988,3,12));

        Member newMember = memberDao.create(member);

        assertEquals(newMember.getId(), 1);

        Optional<Member> rslt = memberDao.get(newMember.getId());

        assertTrue(rslt.isPresent());

        Member createdMember = rslt.get();
        assertEquals(createdMember.getName(), "이종현");
    }
}
