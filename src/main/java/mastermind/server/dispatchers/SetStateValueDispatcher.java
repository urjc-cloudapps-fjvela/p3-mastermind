package mastermind.server.dispatchers;


import mastermind.controllers.GameController;
import mastermind.models.StateValue;

public class SetStateValueDispatcher extends Dispatcher {

    public SetStateValueDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        StateValue stateValue = tcpip.receiveStateValue();
        ((GameController) this.acceptorController).setStateValue(stateValue);
    }

}
