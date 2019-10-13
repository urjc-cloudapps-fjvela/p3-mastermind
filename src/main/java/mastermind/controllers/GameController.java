package mastermind.controllers;

import java.util.List;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.types.Color;
import mastermind.types.Error;;

public class GameController extends AcceptorController {

    private ProposalController proposalController;

    private UndoController undoController;

    private RedoController redoController;

    public GameController(Game game, State state) {
        super(game, state);
        proposalController = new ProposalController(game, state);
        undoController = new UndoController(game, state);
        redoController = new RedoController(game, state);
    }

    public void undo() {
        undoController.undo();
    }

    public void redo() {
        redoController.redo();
    }

    public boolean isUndoable() {
        return undoController.isUndoable();
    }

    public boolean isRedoable() {
        return redoController.isRedoable();
    }

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public int getAttempts() {
        return proposalController.getAttempts();
    }

    public List<Color> getColors(int position) {
        return proposalController.getColors(position);
    }

    public Error addProposedCombination(List<Color> colors) {
        return proposalController.addProposedCombination(colors);
    }

    public boolean isWinner() {
		return proposalController.isWinner();
	}

	public boolean isLooser() {
		return proposalController.isLooser();
    }
    
    public int getBlacks(int position) {
		return proposalController.getBlacks(position);
	}

	public int getWhites(int position) {
		return proposalController.getWhites(position);
	}
	

}
