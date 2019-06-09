package model.services.sessions.virtual;

import spark.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VirtualSessionFactory {
    private static final Map<Long, VirtualSession> sessionContainer = new ConcurrentHashMap<>();

    public static synchronized VirtualSession getSession(long key) {
        VirtualSession session = sessionContainer.get(key);
        if (session == null) {
            session = new VirtualSession();
            sessionContainer.putIfAbsent(key, session);
        }

        return session;
    }

    public static synchronized boolean existSession(long key) {
        return sessionContainer.get(key) != null;
    }
}
