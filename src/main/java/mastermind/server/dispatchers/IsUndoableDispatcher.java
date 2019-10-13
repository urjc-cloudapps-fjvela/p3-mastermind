package mastermind.server.dispatchers;


import mastermind.controllers.GameController;

public class IsUndoableDispatcher extends Dispatcher {


    public IsUndoableDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        Boolean isUndoable = ((GameController) this.acceptorController).isUndoable();
        tcpip.send(isUndoable);
    }

}
