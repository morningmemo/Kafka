package model.services.sessions;

import model.services.sessions.virtual.VirtualSession;
import model.services.sessions.virtual.VirtualSessionFactory;

public class VirtualSessionService implements SessionService {

    @Override
    public boolean existSession(long key) {
        return VirtualSessionFactory.existSession(key);
    }

    @Override
    public VirtualSession startSession(long key) {
        return VirtualSessionFactory.getSession(key);
    }
}
