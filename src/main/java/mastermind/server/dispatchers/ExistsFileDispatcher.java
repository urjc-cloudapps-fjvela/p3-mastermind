package mastermind.server.dispatchers;

import mastermind.controllers.SaveController;

public class ExistsFileDispatcher extends Dispatcher {

    public ExistsFileDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String fileName = tcpip.receiveLine();
        tcpip.send(((SaveController) acceptorController).existsFileName(fileName));
    }

}
