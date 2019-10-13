package mastermind.controllers.server;

import mastermind.controllers.standalone.LogicImplStandalone;
import mastermind.server.dispatchers.AddProposedCombinationDispatcher;
import mastermind.server.dispatchers.ClearDispatcher;
import mastermind.server.dispatchers.DispatcherPrototype;
import mastermind.server.dispatchers.GetAttemptsDispatcher;
import mastermind.server.dispatchers.GetBlacksDispatcher;
import mastermind.server.dispatchers.GetColorsDispatcher;
import mastermind.server.dispatchers.GetValueStateDispatcher;
import mastermind.server.dispatchers.GetWhitesDispatcher;
import mastermind.server.dispatchers.GetWidthDispatcher;
import mastermind.server.dispatchers.IsLooserDispatcher;
import mastermind.server.dispatchers.IsRedoableDispatcher;
import mastermind.server.dispatchers.IsUndoableDispatcher;
import mastermind.server.dispatchers.IsWinnerDispatcher;
import mastermind.server.dispatchers.NextStateDispatcher;
import mastermind.server.dispatchers.RedoDispatcher;
import mastermind.server.dispatchers.ResetStateDispatcher;
import mastermind.server.dispatchers.StartDispatcher;
import mastermind.server.dispatchers.UndoDispatcher;
import mastermind.types.FrameType;

public class LogicServerImplServer extends LogicImplStandalone {


    public LogicServerImplServer() {
        super();

   
    }

    public void createDispatchers(DispatcherPrototype dispatcherPrototype ) {

        dispatcherPrototype.add(FrameType.START, new StartDispatcher(startController));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(gameController));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(gameController));
        dispatcherPrototype.add(FrameType.ADD_PROPOSED_COMBINATION,
                new AddProposedCombinationDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_ATTEMPTS, new GetAttemptsDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_BLACKS, new GetBlacksDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_COLORS, new GetColorsDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_WHITES, new GetWhitesDispatcher(gameController));
        dispatcherPrototype.add(FrameType.IS_LOOSER, new IsLooserDispatcher(gameController));
        dispatcherPrototype.add(FrameType.IS_REDOABLE, new IsRedoableDispatcher(gameController));
        dispatcherPrototype.add(FrameType.IS_UNDOABLE, new IsUndoableDispatcher(gameController));
        dispatcherPrototype.add(FrameType.IS_WINNER, new IsWinnerDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_VALUE_STATE, new GetValueStateDispatcher(gameController));
        dispatcherPrototype.add(FrameType.GET_WIDTH, new GetWidthDispatcher(gameController));
        dispatcherPrototype.add(FrameType.NEXT_STATE, new NextStateDispatcher(gameController));
        dispatcherPrototype.add(FrameType.CLEAR, new ClearDispatcher(gameController));
        dispatcherPrototype.add(FrameType.RESET_STATE,  new ResetStateDispatcher(gameController));
    }
}
