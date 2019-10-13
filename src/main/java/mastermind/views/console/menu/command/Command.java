package mastermind.views.console.menu.command;

import mastermind.controllers.AcceptorController;

public abstract class Command {

    protected String title;
    protected AcceptorController acceptorController;

    protected Command(String title, AcceptorController acceptorController) {
        this.title = title;
        this.acceptorController = acceptorController;
    }

    protected Command(CommandTitle title, AcceptorController acceptorController) {
        this(title.getTitle(), acceptorController);
    }

    public abstract void execute();

    public String getTitle() {
        return title;
    }

    public abstract boolean isActive();

}
