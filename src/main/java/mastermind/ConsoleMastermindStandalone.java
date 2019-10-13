package mastermind;


public class ConsoleMastermindStandalone extends Mastermind {

	public static void main(String[] args) {
		new ConsoleMastermindStandalone().play();
	}

	@Override
	protected Boolean isStandalone() {
		return true;
	}

}
