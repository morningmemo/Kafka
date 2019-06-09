package model.dao.members;

import model.dao.sql2o.Sql2oFactory;
import model.entities.members.Member;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class MemberSql2oDao implements MemberDao{
    private final Sql2o sql2o;

    public MemberSql2oDao(DataSource dataSource) {
        this.sql2o = Sql2oFactory.getInstance(dataSource);
    }

    @Override
    public Member create(Member member) {
        try (Connection conn = sql2o.open()) {
            Member newMember = new Member(member);
            newMember.setCreatedAt(LocalDateTime.now());

            Long key = conn.createQuery(
                    "insert into members( name, date_of_birth, created_at) VALUES ( :name, :dateOfBirth, :createdAt)",
                    true)
                    .bind(newMember)
                    .executeUpdate()
                    .getKey(Long.class);

            if (Objects.isNull(key)) {
                throw new RuntimeException("가입 실패");
            }

            newMember.setId(key);

            return newMember;
        }
    }

    @Override
    public Optional<Member> get(long memberId) {
        try (Connection conn = sql2o.open()) {
            Member member = conn.createQuery("select * from members where member_id = :memberId")
                    .addParameter("memberId", memberId)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Member.class);

            return Optional.ofNullable(member);
        }
    }
}
