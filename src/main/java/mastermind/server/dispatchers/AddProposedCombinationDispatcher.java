package mastermind.server.dispatchers;

import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;

public class AddProposedCombinationDispatcher extends Dispatcher {

    public AddProposedCombinationDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        List<Color> colors = tcpip.receiveColors();
        tcpip.send(((GameController) this.acceptorController).addProposedCombination(colors));
    }

}
