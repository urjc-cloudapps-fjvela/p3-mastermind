package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;

public class ExitCommand extends Command {

    public ExitCommand(GameController gameController) {
        super(CommandTitle.EXIT_COMMAND, gameController);
    }

    @Override
    public void execute() {
        ((GameController) acceptorController).nextState();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
