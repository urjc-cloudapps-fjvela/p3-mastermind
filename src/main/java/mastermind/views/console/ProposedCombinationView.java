package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;
import mastermind.views.console.ColorView;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

class ProposedCombinationView extends WithConsoleView {
	
	private GameController gameController;
	
	ProposedCombinationView(GameController GameController) {
		this.gameController = GameController;
	}
	
	void write(int position) {
		for (Color color : gameController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	List<Color> read() {
		String characters = console.readString(MessageView.PROPOSED_COMBINATION.getMessage());
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
