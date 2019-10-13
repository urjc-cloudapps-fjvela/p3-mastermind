package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public abstract class AcceptorController extends Controller {

    AcceptorController(Game game, State state) {
        super(game, state);
    }

	public abstract void accept(ControllersVisitor controllersVisitor);

}




