package mastermind.controllers.standalone;

import mastermind.controllers.SaveController;
import mastermind.models.Session;
import mastermind.models.dao.DAOManager;

public class SaveControllerImplStandalone extends SaveController {

    private final DAOManager daoManager;

    SaveControllerImplStandalone(Session session, DAOManager sessionImplementationDAO) {
        super(session);
        this.daoManager = sessionImplementationDAO;
    }

    @Override
    public void save(String fileName) {
        daoManager.save(fileName);
    }

    @Override
    public void nextState() {
        session.nextState();

    }

    @Override
    public boolean existsFileName(String name) {
        return daoManager.exists(name);
    }
}