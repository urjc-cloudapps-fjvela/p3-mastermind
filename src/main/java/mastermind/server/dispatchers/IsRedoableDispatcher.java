package mastermind.server.dispatchers;


import mastermind.controllers.GameController;

public class IsRedoableDispatcher extends Dispatcher {


    public IsRedoableDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        Boolean isRedoable = ((GameController) this.acceptorController).isRedoable();
        tcpip.send(isRedoable);
    }

}
