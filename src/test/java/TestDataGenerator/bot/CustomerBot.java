package TestDataGenerator.bot;

import TestDataGenerator.bot.actions.Action;
import TestDataGenerator.bot.actions.AppContact;
import model.services.sessions.virtual.VirtualSession;

public class CustomerBot implements Bot {
    // overflow 고려 안되어 있음.
    private static long currentId = 1;
    private static final Object countLock = new Object();
    private final long id = incrementCount();
    private boolean inUse = false;

    private final Action initAction;

    private VirtualSession session;

    public CustomerBot() {
        initAction = new AppContact(this);
    }

    @Override
    public void action() {
        initAction.action();
    }

    @Override
    public long getId() {
        return id;
    }

    public void setSession(VirtualSession session) {
        this.session = session;
    }

    public VirtualSession getSession() {
        return session;
    }

    public long incrementCount() {
        synchronized (countLock) {
            return currentId++;
        }
    }

    @Override
    public synchronized boolean isAvailable() {
        return !inUse;
    }

    @Override
    public synchronized boolean setInUse() {
        inUse = true;
        return inUse;
    }

    @Override
    public synchronized boolean release() {
        inUse = false;
        return inUse;
    }
}