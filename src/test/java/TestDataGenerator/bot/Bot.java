package TestDataGenerator.bot;

import model.services.sessions.virtual.VirtualSession;

public interface Bot {
    long getId();
    void action();

    VirtualSession getSession();
    void setSession(VirtualSession session);

    public boolean isAvailable();
    public boolean setInUse();
    public boolean release();
}
