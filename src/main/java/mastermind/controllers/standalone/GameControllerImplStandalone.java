package mastermind.controllers.standalone;

import java.util.List;

import mastermind.controllers.GameController;

import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.Error;

public class GameControllerImplStandalone extends GameController {

    public GameControllerImplStandalone(Session session) {
        super(session);

        proposalController = new ProposalControllerImplStandalone(session);
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

    @Override
    public void clear() {
        proposalController.clear();

    }

    @Override
    public StateValue getStateValue() {
        return proposalController.getStateValue();
    }

    @Override
    public void nextState() {
        proposalController.nextState();
    }

    @Override
    public void resetState() {
        proposalController.resetState();

    }

}
