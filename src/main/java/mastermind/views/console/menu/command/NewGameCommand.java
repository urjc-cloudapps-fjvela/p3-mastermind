package mastermind.views.console.menu.command;

import mastermind.controllers.StartController;

public class NewGameCommand extends Command {

    public NewGameCommand(StartController startController) {
        super(CommandTitle.NEW_GAME_COMMAND, startController);
    }

    @Override
    public void execute() {
        ((StartController) this.acceptorController).start();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}