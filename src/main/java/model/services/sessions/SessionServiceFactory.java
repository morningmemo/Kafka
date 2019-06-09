package model.services.sessions;

import model.dao.members.MemberDaoFactory;
import model.services.customers.CustomerService;
import model.services.customers.KafkaCustomerService;
import model.services.customers.SimpleCustomerService;
import model.services.sessions.virtual.VirtualSession;
import model.services.sessions.virtual.VirtualSessionFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionServiceFactory {
    private static SessionService sessionService;
    public static synchronized SessionService getInstance() {
        if (sessionService == null) {
            sessionService = new KafkaSessionService(
                    new VirtualSessionService()
            );
        }
        return sessionService;
    }
}
