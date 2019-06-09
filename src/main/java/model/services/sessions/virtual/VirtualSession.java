package model.services.sessions.virtual;

import model.entities.members.Member;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualSession {
    private final long id;
    private Member member;

    public VirtualSession() {
        id = ThreadLocalRandom.current().nextLong(1,Long.MAX_VALUE);
    }

    public long getId() {
        return id;
    }

    public synchronized void setMember(Member member) {
        this.member = member;
    }

    public synchronized Member getMember() {
        return member;
    }

    public synchronized boolean isLoggined() {
        return member != null;
    }
}
