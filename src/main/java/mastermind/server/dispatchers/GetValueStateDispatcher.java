package mastermind.server.dispatchers;


import mastermind.controllers.GameController;
import mastermind.models.StateValue;

public class GetValueStateDispatcher extends Dispatcher {

    public GetValueStateDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        StateValue stateValue = ((GameController) acceptorController).getStateValue();
        tcpip.send(stateValue);
    }

}
