package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.models.StateValue;
import santaTecla.utils.TCPIP;

public class Logic {

	private State state;
	private Game game;
	private Map<StateValue, AcceptorController> controllers;
	private TCPIP tcpip;
	protected StartController startController;
	protected GameController gameController;
	protected ResumeController resumeController;

	public Logic(boolean isStandalone) {

		tcpip = (isStandalone) ? null : TCPIP.createClientSocket();
		state = new State();
		game = new Game();

		controllers = new HashMap<StateValue, AcceptorController>();
		startController = new StartController(game, state, tcpip);
		gameController = new GameController(game, state, tcpip);
		resumeController = new ResumeController(game, state, tcpip);

		controllers.put(StateValue.INITIAL, startController);
		controllers.put(StateValue.IN_GAME, gameController);
		controllers.put(StateValue.FINAL, resumeController);
		controllers.put(StateValue.EXIT, null);
	}

	public AcceptorController getController() {
		return controllers.get(state.getValueState());
	}

	public void close() {
		if (tcpip != null) {
			tcpip.close();
		}
	}
}
