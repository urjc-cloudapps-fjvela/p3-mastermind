package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.models.StateValue;

public class Logic {

	private State state;

	private Game game;

	private Map<StateValue, AcceptorController> controllers;

	public Logic() {
		state = new State();
		game = new Game();
		controllers = new HashMap<StateValue, AcceptorController>();
		controllers.put(StateValue.INITIAL, new StartController(game, state));
		controllers.put(StateValue.IN_GAME, new GameController(game, state));
		controllers.put(StateValue.FINAL, new ResumeController(game, state));
		controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return controllers.get(state.getValueState());
	}

}
