package mastermind.controllers;

import mastermind.models.Session;

public abstract class StartController extends AcceptorController {

	public StartController(Session session) {
		super(session);
	}

	public abstract void start();

	public abstract void start(String fileName);

	public abstract String[] getSavedGamesNames();

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}
