package mastermind.server.dispatchers;


import mastermind.controllers.StartController;


public class StartOpenSavedGameDispatcher extends Dispatcher {

    public StartOpenSavedGameDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
       String fileName = tcpip.receiveLine();
        ((StartController) this.acceptorController).start(fileName);
    }

}