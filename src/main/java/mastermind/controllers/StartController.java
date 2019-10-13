package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class StartController extends AcceptorController {

	public StartController(Game game, State state, TCPIP tcpip) {
		super(game, state, tcpip);
	}

	public void start() {
		if (tcpip != null) {
			this.tcpip.send(FrameType.START.name());
		}
		state.next();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
