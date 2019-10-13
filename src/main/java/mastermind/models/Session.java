package mastermind.models;

import java.util.List;

import mastermind.types.Color;

public interface Session {

    StateValue getValueState();

    void redo();

    boolean isRedoable();

    void undo();

    boolean isUndoable();

    boolean isWinner();

    boolean isLooser();

    int getAttempts();

    List<Color> getColors(int position);

    int getBlacks(int position);

    int getWhites(int position);

    int getWidth();

    void nextState();

    void addProposedCombination(List<Color> colors);

    void clear();

    void resetState();

}