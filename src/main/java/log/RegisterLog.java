package log;

import kafka.TopicType;
import model.entities.members.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisterLog extends Log {
    private final long memberId;
    private final String name;
    private final LocalDate dateOfBirth;
    private final LocalDateTime createdAt;

    public RegisterLog(Member member) {
        this.memberId = member.getId();
        this.name = member.getName();
        this.dateOfBirth = LocalDate.from(member.getDateOfBirth());
        this.createdAt = LocalDateTime.from(member.getCreatedAt());
    }

    @Override
    public String getTopic() {
        return TopicType.MEMBER_REGISTER.toString();
    }
}
