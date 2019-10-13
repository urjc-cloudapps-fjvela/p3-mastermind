package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class RedoController extends Controller {

	public RedoController(Game game, State state) {
		super(game, state);
	}
	
	void redo() {
		game.redo();
	}

	boolean isRedoable() {
		return game.isRedoable();
	}
}
