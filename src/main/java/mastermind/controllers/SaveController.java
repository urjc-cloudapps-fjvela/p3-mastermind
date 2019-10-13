package mastermind.controllers;

import mastermind.models.Session;

public abstract class SaveController extends AcceptorController {

    public SaveController(Session session) {
        super(session);
    }

    public abstract void save(String fileName);


    public abstract void nextState();


    public abstract boolean existsFileName(String fileName);

    @Override
    public void accept(ControllersVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
