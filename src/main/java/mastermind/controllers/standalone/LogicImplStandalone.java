package mastermind.controllers.standalone;


import mastermind.controllers.Logic;

import mastermind.models.StateValue;
import mastermind.models.standalone.SessionImplStandalone;


public class LogicImplStandalone extends Logic {



    public LogicImplStandalone() {

        super();
        session = new SessionImplStandalone();
        startController = new StartControllerImplStandalone(session);
        gameController = new GameControllerImplStandalone(session);
        resumeController = new ResumeControllerImplStandalone(session);

        controllers.put(StateValue.INITIAL, startController);
        controllers.put(StateValue.IN_GAME, gameController);
        controllers.put(StateValue.FINAL, resumeController);
        controllers.put(StateValue.EXIT, null);
    }

}
