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


	public Logic() {

	

        controllers = new HashMap<StateValue, AcceptorController>();

	}

	public AcceptorController getController() {
		return controllers.get( session.getValueState());
	}


}
