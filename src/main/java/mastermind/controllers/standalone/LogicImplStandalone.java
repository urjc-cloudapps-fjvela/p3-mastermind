package mastermind.controllers.standalone;


import mastermind.controllers.Logic;

import mastermind.models.StateValue;
import mastermind.models.dao.DAOManager;
import mastermind.models.standalone.SessionImplStandalone;


public class LogicImplStandalone extends Logic {



    public LogicImplStandalone() {

        super();

        session = new SessionImplStandalone();
        DAOManager daoManager = new DAOManager(session);

        startController = new StartControllerImplStandalone(session, daoManager);
        gameController = new GameControllerImplStandalone(session);
        resumeController = new ResumeControllerImplStandalone(session);
        saveController = new SaveControllerImplStandalone(session,daoManager);

        controllers.put(StateValue.INITIAL, startController);
        controllers.put(StateValue.IN_GAME, gameController);
        controllers.put(StateValue.SAVING, saveController);
        controllers.put(StateValue.FINAL, resumeController);
        controllers.put(StateValue.EXIT, null);
    }

}
