package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class GameController extends AcceptorController {

    protected UndoController undoController;
    protected RedoController redoController;
    protected ProposalController proposalController;

    public GameController(Session session) {
        super(session);

        undoController = new UndoController(session);
        redoController = new RedoController(session);

    }

    public abstract void undo();

    public abstract void redo();

    public abstract boolean isUndoable();

    public abstract boolean isRedoable();

    public abstract int getAttempts();

    public abstract List<Color> getColors(int position);

    public abstract Error addProposedCombination(List<Color> colors);

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract void clear();

    public abstract StateValue getStateValue();

    public abstract void nextState();

    public abstract void resetState();

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
