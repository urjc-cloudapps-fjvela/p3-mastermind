package mastermind.server.proxy;

import java.util.List;

import mastermind.controllers.GameController;
import mastermind.models.Session;
import mastermind.models.StateValue;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;;

public class GameControllerImplProxy extends GameController {

    private TCPIP tcpip;

    public GameControllerImplProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;

    }

    public void undo() {

        tcpip.send(FrameType.UNDO);
    }

    public void redo() {

        tcpip.send(FrameType.REDO);
    }

    public boolean isUndoable() {

        tcpip.send(FrameType.IS_UNDOABLE);
        return tcpip.receiveBoolean();

    }

    public boolean isRedoable() {

        tcpip.send(FrameType.IS_REDOABLE);
        return tcpip.receiveBoolean();

    }

    public int getAttempts() {

        tcpip.send(FrameType.GET_ATTEMPTS);
        return tcpip.receiveInt();

    }

    public List<Color> getColors(int position) {

        tcpip.send(FrameType.GET_COLORS);
        tcpip.send(position);
        return tcpip.receiveColors();

    }

    public Error addProposedCombination(List<Color> colors) {

        tcpip.send(FrameType.ADD_PROPOSED_COMBINATION);
        tcpip.send(colors);
        return tcpip.receiveError();

    }

    public boolean isWinner() {

        tcpip.send(FrameType.IS_WINNER);
        return tcpip.receiveBoolean();

    }

    public boolean isLooser() {

        tcpip.send(FrameType.IS_LOOSER);
        return tcpip.receiveBoolean();

    }

    public int getBlacks(int position) {

        tcpip.send(FrameType.GET_BLACKS);
        tcpip.send(position);
        return tcpip.receiveInt();

    }

    public int getWhites(int position) {
        tcpip.send(FrameType.GET_WHITES);
        tcpip.send(position);
        return tcpip.receiveInt();
    }

    @Override
    public void clear() {
        tcpip.send(FrameType.CLEAR);

    }

    @Override
    public StateValue getStateValue() {
        tcpip.send(FrameType.GET_VALUE_STATE);
        return tcpip.receiveStateValue();

    }

    @Override
    public void nextState() {
        tcpip.send(FrameType.NEXT_STATE);

    }

    @Override
    public void resetState() {
        tcpip.send(FrameType.RESET_STATE);

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

}
