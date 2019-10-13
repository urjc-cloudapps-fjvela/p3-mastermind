package mastermind.views.console.menu.command;

import mastermind.controllers.GameController;
import mastermind.views.console.ProposalView;

public class ProposeCombinationCommand extends Command {

    public ProposeCombinationCommand(GameController gameController) {
        super(CommandTitle.PROPOSE_COMBINATION_COMMAND, gameController);
    }

    @Override
    public void execute() {
		new ProposalView().interact(gameController);
        
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
