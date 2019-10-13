package mastermind.controllers;

import mastermind.models.Game;
import mastermind.models.State;

public class StartController extends AcceptorController {

	public StartController(Game game, State state) {
		super(game, state);
	}
	
	public void start() {
		state.next();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
