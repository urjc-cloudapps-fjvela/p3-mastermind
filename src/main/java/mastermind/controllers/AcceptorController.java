package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import santaTecla.utils.TCPIP;

public abstract class AcceptorController extends Controller {

    AcceptorController(Game game, State state, TCPIP tcpip) {
        super(game, state, tcpip);
    }

	public abstract void accept(ControllersVisitor controllersVisitor);

}




