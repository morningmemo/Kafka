package log;

import kafka.TopicType;

import java.time.LocalDateTime;

public class SessionStartLog extends Log {
    private final LocalDateTime startAt;

    public SessionStartLog( LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public final LocalDateTime getStartAt() {
        return startAt;
    }

    @Override
    public String getTopic() {
        return TopicType.SESSION_START.toString();
    }
}
