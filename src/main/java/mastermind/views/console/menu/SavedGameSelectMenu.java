package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import mastermind.views.console.menu.command.SavedGameSelectCommand;

public class SavedGameSelectMenu extends Menu {

    public SavedGameSelectMenu(StartController startController) {
        super();

        String[] gamesNames = startController.getSavedGamesNames();
        for (String title : gamesNames) {
            this.addCommand(new SavedGameSelectCommand(title, startController));
        }
    }

}
