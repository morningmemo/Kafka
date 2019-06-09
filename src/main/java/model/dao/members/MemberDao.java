package model.dao.members;

import model.entities.members.Member;

import java.util.Optional;

public interface MemberDao {
    public Member create(Member member);
    public Optional<Member> get(long memberId);
}
