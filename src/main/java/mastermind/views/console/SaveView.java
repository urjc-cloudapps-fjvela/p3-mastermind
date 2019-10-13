package mastermind.views.console;

import mastermind.controllers.SaveController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;
import santaTecla.utils.YesNoDialog;

class SaveView extends WithConsoleView {

    void interact(SaveController saveController) {
        boolean save = new YesNoDialog().read(MessageView.SAVE);
        String name = null;
        if (save) {

            boolean exists = false;
            do {
                name = console.readString(MessageView.ASK_FILE_NAME);
                exists = saveController.existsFileName(name);
                if (exists) {
                    console.writeln(MessageView.NAME_ALREADY_EXISTS);
                }
            } while (exists);
            saveController.save(name);

        }
        saveController.nextState();
    }

}
