package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        ((GameController) acceptorController).undo();
    }

}
