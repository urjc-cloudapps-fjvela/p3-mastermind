package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class ResetStateDispatcher extends Dispatcher {

    public ResetStateDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
         ((GameController) acceptorController).resetState();
    }

}
