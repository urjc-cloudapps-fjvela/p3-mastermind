package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class Mastermind {

	private Logic logic;

	private View view;

	protected Mastermind() {
		this.logic = new Logic(isStandalone());
		this.view = new ConsoleView();
	}

	protected void play() {
		AcceptorController controller;
		do {
			controller = this.logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
		if (!this.isStandalone()) {
			this.logic.close();
		}
	}

	protected abstract Boolean isStandalone();

}