package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;

public class UndoCommand extends Command {

    public UndoCommand(GameController gameController) {
        super(CommandTitle.UNDO_COMMAND, gameController);
    }

    @Override
    public void execute() {
        gameController.undo();
        
    }

    @Override
    public boolean isActive() {
        return gameController.isUndoable();
    }

}
