package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;

public abstract class Command {

    protected CommandTitle title;
    protected GameController gameController;

    protected Command(CommandTitle title, GameController gameController) {
        this.title = title;
        this.gameController = gameController;
    }

    public abstract void execute();

    public String getTitle() {
        return title.getTitle();
    }

    public abstract boolean isActive();

}
