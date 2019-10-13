package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class ClearDispatcher extends Dispatcher {

    public ClearDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        ((GameController) acceptorController).clear();
    }

}
