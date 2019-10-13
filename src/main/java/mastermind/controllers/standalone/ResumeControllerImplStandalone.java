package mastermind.controllers.standalone;

import mastermind.controllers.ResumeController;

import mastermind.models.Session;


public class ResumeControllerImplStandalone extends ResumeController {

	public ResumeControllerImplStandalone(Session session) {
		super(session);
	}

	@Override
	public void resume(boolean newGame) {
		if (newGame) {
			session.clear();
			session.resetState();
		} else {
			session.nextState();
		}
	}

}
