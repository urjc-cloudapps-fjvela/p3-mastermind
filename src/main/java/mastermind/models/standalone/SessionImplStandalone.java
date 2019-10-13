package mastermind.models.standalone;

import java.util.List;

import mastermind.models.Game;
import mastermind.models.Session;
import mastermind.models.State;
import mastermind.models.StateValue;
import mastermind.types.Color;

public class SessionImplStandalone implements Session {

    private State state;

    private Game game;

    public SessionImplStandalone() {
        this.state = new State();
        this.game = new Game();
    }

    @Override
    public StateValue getValueState() {
        
        return state.getValueState();
    }

    @Override
    public void redo() {
        
        game.redo();
    }

    @Override
    public boolean isRedoable() {
        
        return game.isRedoable();
    }

    @Override
    public void undo() {
        game.undo();

    }

    @Override
    public boolean isUndoable() {
        
        return game.isUndoable();
    }

    @Override
    public boolean isWinner() {
        
        return game.isWinner();
    }

    @Override
    public boolean isLooser() {
        
        return game.isLooser();
    }

    @Override
    public int getAttempts() {
        
        return game.getAttempts();
    }

    @Override
    public List<Color> getColors(int position) {
        
        return game.getColors(position);
    }

    @Override
    public int getBlacks(int position) {
        
        return game.getBlacks(position);
    }

    @Override
    public int getWhites(int position) {
        
        return game.getWhites(position);
    }

    @Override
    public int getWidth() {
        
        return game.getWidth();
    }

    @Override
    public void nextState() {
        state.next();
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        
         game.addProposedCombination(colors);
    }

    @Override
    public void clear() {
        game.clear();

    }

    @Override
    public void resetState() {
        state.reset();

    }
}