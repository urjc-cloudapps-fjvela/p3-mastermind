package mastermind.views.console;

import mastermind.controllers.GameController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;
import mastermind.views.console.menu.Menu;

public class ConsoleView extends View {

	private StartView startView;


	private ResumeView resumeView;

	public ConsoleView() {
		this.startView = new StartView();
		this.resumeView = new ResumeView();
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}

	@Override
	public void visit(ResumeController resumeController) {
		resumeView.interact(resumeController);
	}
	@Override
	public void visit(GameController gameController) {
		new Menu(gameController).execute();
	}
}
