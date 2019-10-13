package mastermind.controllers;

import java.util.List;

import mastermind.models.Game;
import mastermind.models.State;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;;

public class GameController extends AcceptorController {

    private ProposalController proposalController;

    private UndoController undoController;

    private RedoController redoController;

    public GameController(Game game, State state, TCPIP tcpip) {
        super(game, state, tcpip);
        proposalController = new ProposalController(game, state, tcpip);
        undoController = new UndoController(game, state, tcpip);
        redoController = new RedoController(game, state, tcpip);
    }

    public void undo() {
        if (tcpip == null) {
            undoController.undo();
        } else {
            tcpip.send(FrameType.UNDO);
        }
    }

    public void redo() {
        if (tcpip == null) {
            redoController.redo();
        } else {
            tcpip.send(FrameType.REDO);
        }
    }

    public boolean isUndoable() {
        if (tcpip == null) {
            return undoController.isUndoable();
        } else {
            tcpip.send(FrameType.IS_UNDOABLE);
            return tcpip.receiveBoolean();
        }
    }

    public boolean isRedoable() {
        if (tcpip == null) {
            return redoController.isRedoable();
        } else {
            tcpip.send(FrameType.IS_REDOABLE);
            return tcpip.receiveBoolean();
        }
    }

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public int getAttempts() {
        if (tcpip == null) {
            return proposalController.getAttempts();
        } else {
            tcpip.send(FrameType.GET_ATTEMPTS);
            return tcpip.receiveInt();
        }
    }

    public List<Color> getColors(int position) {
        if (tcpip == null) {
            return proposalController.getColors(position);
        } else {
            tcpip.send(FrameType.GET_COLORS);
            tcpip.send(position);
            return tcpip.receiveColors();
        }
    }

    public Error addProposedCombination(List<Color> colors) {
        if (tcpip == null) {
            return proposalController.addProposedCombination(colors);
        } else {
            tcpip.send(FrameType.ADD_PROPOSED_COMBINATION);
            tcpip.send(colors);
            return tcpip.receiveError();
        }
    }

    public boolean isWinner() {
        if (tcpip == null) {
            return proposalController.isWinner();
        } else {
            tcpip.send(FrameType.IS_WINNER);
            return tcpip.receiveBoolean();
        }
    }

    public boolean isLooser() {
        if (tcpip == null) {
            return proposalController.isLooser();
        } else {
            tcpip.send(FrameType.IS_LOOSER);
            return tcpip.receiveBoolean();
        }
    }

    public int getBlacks(int position) {
        if (tcpip == null) {
            return proposalController.getBlacks(position);
        } else {
            tcpip.send(FrameType.GET_BLACKS);
            tcpip.send(position);
            return tcpip.receiveInt();
        }
    }

    public int getWhites(int position) {

        if (tcpip == null) {
            return proposalController.getWhites(position);
        } else {
            tcpip.send(FrameType.GET_WHITES);
            tcpip.send(position);
            return tcpip.receiveInt();
        }
    }

}
