package mastermind.models.server;

import java.util.List;

import mastermind.models.Game;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class SessionImplServer implements Session {

    private TCPIP tcpip;

    public SessionImplServer(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    @Override
    public StateValue getValueState() {
        tcpip.send(FrameType.GET_VALUE_STATE);
        return tcpip.receiveStateValue();
    }

    @Override
    public void redo() {
        tcpip.send(FrameType.REDO);
    }

    @Override
    public boolean isRedoable() {

        tcpip.send(FrameType.IS_REDOABLE);
        return tcpip.receiveBoolean();
    }

    @Override
    public void undo() {
        tcpip.send(FrameType.UNDO);

    }

    @Override
    public boolean isUndoable() {

        tcpip.send(FrameType.IS_UNDOABLE);
        return tcpip.receiveBoolean();
    }

    @Override
    public boolean isWinner() {

        tcpip.send(FrameType.IS_WINNER);
        return tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {

        tcpip.send(FrameType.IS_LOOSER);
        return tcpip.receiveBoolean();
    }

    @Override
    public int getAttempts() {

        tcpip.send(FrameType.GET_ATTEMPTS);
        return tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        tcpip.send(FrameType.GET_COLORS);
        tcpip.send(position);
        return tcpip.receiveColors();
    }

    @Override
    public int getBlacks(int position) {

        tcpip.send(FrameType.GET_BLACKS);
        return tcpip.receiveInt();
    }

    @Override
    public int getWhites(int position) {

        tcpip.send(FrameType.GET_WHITES);
        return tcpip.receiveInt();
    }

    @Override
    public int getWidth() {

        tcpip.send(FrameType.GET_WIDTH);
        return tcpip.receiveInt();
    }

    @Override
    public void nextState() {
        tcpip.send(FrameType.NEXT_STATE);
    }

    @Override
    public void addProposedCombination(List<Color> colors) {
        tcpip.send(FrameType.ADD_PROPOSED_COMBINATION);
        tcpip.send(colors);

        tcpip.receiveError();
    }

    @Override
    public void clear() {
        tcpip.send(FrameType.CLEAR);

    }

    @Override
    public void resetState() {
        tcpip.send(FrameType.RESET_STATE);

    }

    @Override
    public Game getGame() {
        return null;
    }

    @Override
    public void setStateValue(StateValue stateValue) {
        tcpip.send(FrameType.SET_STATE_VALUE);
        tcpip.send(stateValue);

    }

    @Override
    public boolean isGameFinished() {
        tcpip.send(FrameType.IS_GAME_FINISHED);
        return tcpip.receiveBoolean();
    }

    @Override
    public void setGame(Game game) {

    }
}