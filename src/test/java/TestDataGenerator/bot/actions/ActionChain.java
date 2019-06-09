package TestDataGenerator.bot.actions;

import TestDataGenerator.bot.Bot;

abstract public class ActionChain extends ActionBase {
    private Action nextAction;

    public ActionChain(Bot bot, Action action) {
        super(bot);
        this.nextAction = action;
    }

    public final void action() {
        doAction();

        if (nextAction != null) {
            nextAction.action();
        }
    }

    abstract protected void doAction();

    public Action getNextAction() {
        return nextAction;
    }

    public void setNextAction(Action nextAction) {
        this.nextAction = nextAction;
    }
}
