package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import santaTecla.utils.TCPIP;

public class ResumeController extends AcceptorController {

	public ResumeController(Game game, State state, TCPIP tcpip) {
		super(game, state, tcpip);
	}

	public void resume(boolean newGame) {
		if (newGame) {
			game.clear();
			state.reset();
		} else {
			state.next();
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
