package mastermind.controllers;

public interface ControllersVisitor {

	void visit(StartController startController);

	void visit(GameController gameController);

	void visit(ResumeController continueController);

}
