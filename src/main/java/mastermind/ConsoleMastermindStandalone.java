package mastermind;

import mastermind.controllers.standalone.LogicImplStandalone;

public class ConsoleMastermindStandalone extends Mastermind {

	public ConsoleMastermindStandalone() {
		super();
		logic = new LogicImplStandalone();
	}

	public static void main(String[] args) {
		new ConsoleMastermindStandalone().play();
	}

	@Override
	protected Boolean isStandalone() {
		return true;
	}

}
