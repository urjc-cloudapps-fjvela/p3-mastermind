package mastermind.views.console.menu.command;

import mastermind.controllers.StartController;
import mastermind.views.console.menu.SavedGameSelectMenu;

public class OpenSavedGameCommand extends Command {


    public OpenSavedGameCommand(StartController startController) {
        super(CommandTitle.OPEN_SAVED_GAME_COMMAND, startController);
    }

    @Override
    public void execute() {
        new SavedGameSelectMenu((StartController) this.acceptorController).execute();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
