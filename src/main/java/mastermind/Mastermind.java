package mastermind;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.Logic;
import mastermind.views.View;
import mastermind.views.console.ConsoleView;

public abstract class Mastermind {

	protected Logic logic;

	private View view;

	protected Mastermind() {
		this.view = new ConsoleView();
	}

	protected void play() {
		AcceptorController controller;
		do {
			controller = logic.getController();
			if (controller != null) {
				this.view.interact(controller);
			}
		} while (controller != null);
		// if (!this.isStandalone()) {
		// 	this.logic.close();
		// }
	}

	protected abstract Boolean isStandalone();
}