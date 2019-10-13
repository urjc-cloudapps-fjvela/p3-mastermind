package mastermind.server.dispatchers;

import mastermind.controllers.StartController;

public class GetSavedGamesNamesDispatcher extends Dispatcher {

    public GetSavedGamesNamesDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        String[] result = ((StartController) acceptorController).getSavedGamesNames();
        tcpip.send(result);
    }

}
