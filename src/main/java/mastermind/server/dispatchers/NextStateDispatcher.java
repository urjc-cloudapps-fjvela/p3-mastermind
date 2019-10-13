package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class NextStateDispatcher extends Dispatcher {

    public NextStateDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
         ((GameController) acceptorController).nextState();
    }

}
