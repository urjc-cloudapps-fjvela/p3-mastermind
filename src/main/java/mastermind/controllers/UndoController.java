package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class UndoController extends Controller {

	public UndoController(Game game, State state) {
		super(game, state);
	}
	
	void undo() {
		game.undo();
	}

	boolean isUndoable() {
		return game.isUndoable();
	}

}
