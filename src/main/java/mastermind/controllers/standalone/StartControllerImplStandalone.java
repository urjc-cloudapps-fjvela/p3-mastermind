package mastermind.controllers.standalone;

import mastermind.controllers.StartController;

import mastermind.models.Session;


public class StartControllerImplStandalone extends StartController {

    public StartControllerImplStandalone(Session session) {
        super(session);
    }

    @Override
    public void start() {
        session.nextState();
    }

}
