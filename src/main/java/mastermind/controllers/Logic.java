package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;


import mastermind.models.Session;

import mastermind.models.StateValue;

public abstract class Logic {

	protected Session session;
	protected Map<StateValue, AcceptorController> controllers;
	protected StartController startController;
	protected GameController gameController;
	protected ResumeController resumeController;
	protected SaveController saveController;

	// public Logic(State state, Game game) {
		// this.state = state;
		// this.game = game;
	public Logic() {

	

        controllers = new HashMap<StateValue, AcceptorController>();

		// controllers = new HashMap<StateValue, AcceptorController>();
		// startController = new StartController(session );
		// gameController = new GameController(session);
		// resumeController = new ResumeController(session);

		// controllers.put(StateValue.INITIAL, startController);
		// controllers.put(StateValue.IN_GAME, gameController);
		// controllers.put(StateValue.FINAL, resumeController);
		// controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return controllers.get( session.getValueState());
	}


}
