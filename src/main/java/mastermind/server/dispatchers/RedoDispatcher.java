package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class RedoDispatcher extends Dispatcher {

    public RedoDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        ((GameController) acceptorController).redo();
    }

}
