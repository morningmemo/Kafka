package log;

import model.entities.members.Member;
import utils.JsonUtils;

public class MemberSessionStartLog extends SessionStartLog {
    private final long memberId;

    public MemberSessionStartLog(SessionStartLog sessionStartLog, Member member) {
        super(sessionStartLog.getStartAt());
        this.memberId = member.getId();
    }
    
    @Override
    public String toJson() {
        return JsonUtils.toJson(this);
    }
}
