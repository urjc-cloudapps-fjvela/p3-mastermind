package mastermind.controllers;


import mastermind.models.Session;


public class RedoController extends Controller {

	public RedoController(Session session) {
		super(session);
	}
	
	public void redo() {
		session.redo();
	}

	public boolean isRedoable() {
		return session.isRedoable();
	}
}
