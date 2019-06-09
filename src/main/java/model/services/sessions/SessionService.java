package model.services.sessions;

import model.services.sessions.virtual.VirtualSession;

public interface SessionService {
    boolean existSession(long key);
    VirtualSession startSession(long key);
}
