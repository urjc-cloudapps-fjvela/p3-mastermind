package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class GetWidthDispatcher extends Dispatcher {

    public GetWidthDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        int width = ((GameController) acceptorController).getWidth();
        tcpip.send(width);
    }

}
