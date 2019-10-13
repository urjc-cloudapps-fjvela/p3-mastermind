package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.menu.command.NewGameCommand;
import mastermind.views.console.menu.command.OpenSavedGameCommand;

public class StartMenu extends Menu {

    public StartMenu(StartController startController) {
        this.addCommand(new NewGameCommand(startController));
        this.addCommand(new OpenSavedGameCommand(startController));
    }
}

