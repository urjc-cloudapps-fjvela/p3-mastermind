package mastermind.views.console.menu;

import mastermind.controllers.GameController;
import mastermind.views.console.menu.command.ExitCommand;
import mastermind.views.console.menu.command.ProposeCombinationCommand;
import mastermind.views.console.menu.command.RedoCommand;
import mastermind.views.console.menu.command.UndoCommand;

public class GameMenu extends Menu {

    public GameMenu(GameController gameController) {
        super();
        addCommand(new ProposeCombinationCommand(gameController));
        addCommand(new UndoCommand(gameController));
        addCommand(new RedoCommand(gameController));
        addCommand(new ExitCommand(gameController));
    }

}
