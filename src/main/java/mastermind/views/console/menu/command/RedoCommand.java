package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;

public class RedoCommand extends Command {

    public RedoCommand(GameController gameController) {
        super(CommandTitle.REDO_COMMAND, gameController);
    }

    @Override
    public void execute() {
        ((GameController) acceptorController).redo();
    }

    @Override
    public boolean isActive() {
        return ((GameController) acceptorController).isRedoable();
    }

}
