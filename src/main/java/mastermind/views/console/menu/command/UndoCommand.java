package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;

public class UndoCommand extends Command {

    public UndoCommand(GameController gameController) {
        super(CommandTitle.UNDO_COMMAND, gameController);
    }

    @Override
    public void execute() {
        ((GameController) acceptorController).undo();

    }

    @Override
    public boolean isActive() {
        return ((GameController) acceptorController).isUndoable();
    }

}
