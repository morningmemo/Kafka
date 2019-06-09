package model.services.customers;

import model.dao.members.MemberDao;
import model.entities.members.Member;

public class SimpleCustomerService implements CustomerService {
    private MemberDao memberDao;

    public SimpleCustomerService( MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member register(Member member) {
        Member newMember = memberDao.create(member);
        return newMember;
    }
}
