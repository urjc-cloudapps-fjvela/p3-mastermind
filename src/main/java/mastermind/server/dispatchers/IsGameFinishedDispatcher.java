package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class IsGameFinishedDispatcher extends Dispatcher {

    public IsGameFinishedDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        ((GameController) acceptorController).isGameFinished();
    }

}
