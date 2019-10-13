package mastermind.views.console;

import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.console.ErrorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

	public void interact(GameController gameController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(gameController).read();
			error = gameController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
		this.console.writeln();
		new AttemptsView(gameController).writeln();
		new SecretCombinationView(gameController).writeln();
		for (int i = 0; i < gameController.getAttempts(); i++) {
			new ProposedCombinationView(gameController).write(i);
			new ResultView(gameController).writeln(i);
		}
		if (gameController.isWinner()) {
			this.console.writeln(MessageView.WINNER.getMessage());
		} else if (gameController.isLooser()) {
			this.console.writeln(MessageView.LOOSER.getMessage());
		}
	}

}
