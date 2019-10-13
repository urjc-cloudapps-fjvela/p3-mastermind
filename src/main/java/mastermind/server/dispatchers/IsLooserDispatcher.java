package mastermind.server.dispatchers;


import mastermind.controllers.GameController;

public class IsLooserDispatcher extends Dispatcher {


    public IsLooserDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
       Boolean isLooser = ((GameController) this.acceptorController).isLooser();
       tcpip.send(isLooser);
    }

}
