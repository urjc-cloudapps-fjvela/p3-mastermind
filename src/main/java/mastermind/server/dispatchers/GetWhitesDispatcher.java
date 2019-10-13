package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class GetWhitesDispatcher extends Dispatcher {

    public GetWhitesDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        int position = tcpip.receiveInt();
        int whites = ((GameController) acceptorController).getWhites(position);
        tcpip.send(whites);
    }

}
