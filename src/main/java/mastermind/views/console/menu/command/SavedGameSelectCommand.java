package mastermind.views.console.menu.command;

import mastermind.controllers.StartController;

public class SavedGameSelectCommand extends Command {


    public SavedGameSelectCommand(String title, StartController startController) {
        super(title, startController);
    }

    @Override
    public void execute() {
        ((StartController) this.acceptorController).start(title);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
