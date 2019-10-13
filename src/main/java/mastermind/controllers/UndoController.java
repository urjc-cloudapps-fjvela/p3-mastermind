package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import santaTecla.utils.TCPIP;

public class UndoController extends Controller {

	public UndoController(Game game, State state, TCPIP tcpip) {
		super(game, state, tcpip);
	}
	
	void undo() {
		game.undo();
	}

	boolean isUndoable() {
		return game.isUndoable();
	}

}
