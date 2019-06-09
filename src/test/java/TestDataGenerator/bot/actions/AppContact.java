package TestDataGenerator.bot.actions;

import TestDataGenerator.bot.Bot;
import TestDataGenerator.bot.actions.transaction.Transaction;
import TestDataGenerator.bot.actions.transaction.TransactionRandomGenerator;
import model.services.sessions.SessionService;
import model.services.sessions.SessionServiceFactory;
import model.services.sessions.virtual.VirtualSession;

public class AppContact extends ActionChain {
    public AppContact(Bot bot) {
        super(bot, null);
    }

    @Override
    public void doAction() {
        Bot bot = getBot();

        SessionService sessionService = SessionServiceFactory.getInstance();

        VirtualSession session = sessionService.startSession(getBot().getId());
        bot.setSession(session);

        if (!session.isLoggined()) {
            setNextAction(new Register(bot));
        } else {
            Transaction transaction = TransactionRandomGenerator.generateTransaction(bot);
            setNextAction(transaction);
        }
    }
}
