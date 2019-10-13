package mastermind.controllers.standalone;

import mastermind.controllers.StartController;

import mastermind.models.Session;
import mastermind.models.dao.DAOManager;

public class StartControllerImplStandalone extends StartController {

    private DAOManager daoManager;

    public StartControllerImplStandalone(Session session, DAOManager daoManager) {
        super(session);
        this.daoManager = daoManager;
    }

    @Override
    public void start() {
        session.nextState();
    }

    @Override
    public void start(String fileName) {
        daoManager.load(fileName);

    }

    @Override
    public String[] getSavedGamesNames() {
        return daoManager.getGamesNames();
    }

}
