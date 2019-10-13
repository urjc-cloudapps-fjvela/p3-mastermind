package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import santaTecla.utils.TCPIP;

public class RedoController extends Controller {

	public RedoController(Game game, State state, TCPIP tcpip) {
		super(game, state, tcpip);
	}
	
	void redo() {
		game.redo();
	}

	boolean isRedoable() {
		return game.isRedoable();
	}
}
