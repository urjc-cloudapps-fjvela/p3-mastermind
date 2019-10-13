package mastermind.server.dispatchers;

import mastermind.controllers.SaveController;

public class SaveDispatcher extends Dispatcher {

    public SaveDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String fileName = tcpip.receiveLine();
        ((SaveController) acceptorController).save(fileName);
    }

}
