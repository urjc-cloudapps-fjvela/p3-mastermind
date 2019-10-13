package mastermind.views.console;

import mastermind.controllers.GameController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.SaveController;
import mastermind.controllers.StartController;
import mastermind.views.View;
import mastermind.views.console.menu.GameMenu;
import mastermind.views.console.menu.StartMenu;

public class ConsoleView extends View {


	private ResumeView resumeView;

	private SaveView saveView;

	public ConsoleView() {
		resumeView = new ResumeView();
		saveView = new SaveView();
	}

	@Override
	public void visit(StartController startController) {
		new StartMenu(startController).execute();

	}

	@Override
	public void visit(ResumeController resumeController) {
		resumeView.interact(resumeController);
	}

	@Override
	public void visit(GameController gameController) {
		new GameMenu(gameController).execute();
	}

	@Override
	public void visit(SaveController saveController) {
		saveView.interact(saveController);
	}
}
