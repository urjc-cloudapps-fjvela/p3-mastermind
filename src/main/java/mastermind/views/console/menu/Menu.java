package mastermind.views.console.menu;

import java.util.ArrayList;

import mastermind.controllers.GameController;
import mastermind.views.console.menu.command.*;
import santaTecla.utils.WithConsoleView;

public class Menu extends WithConsoleView{

    private static final String OPTION = "Choose an option: ";
    private ArrayList<Command> commandList;

    public Menu(GameController gameController) {
        commandList = new ArrayList<Command>();
        commandList.add(new ProposeCombinationCommand(gameController));
        commandList.add(new UndoCommand(gameController));
        commandList.add(new RedoCommand(gameController));

    }

    public void execute() {
        ArrayList<Command> commands = new ArrayList<Command>();
        for (int i = 0; i < commandList.size(); i++) {
            if (commandList.get(i).isActive()) {
                commands.add(commandList.get(i));
            }
        }
        boolean error;
        int option;
        do {
            error = false;
            for (int i = 0; i < commands.size(); i++) {
                console.writeln((i + 1) + ") " + commands.get(i).getTitle());
            }
            console.write(OPTION);
            option = console.readInt("") - 1;
            console.writeln();
        } while (error);
        commands.get(option).execute();
    }

    protected void addCommand(Command command) {
        commandList.add(command);
    }

}
