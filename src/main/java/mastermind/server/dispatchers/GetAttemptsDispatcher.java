package mastermind.server.dispatchers;

import mastermind.controllers.GameController;

public class GetAttemptsDispatcher extends Dispatcher {

    public GetAttemptsDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        int attempts = ((GameController) this.acceptorController).getAttempts();
      //  tcpip.send("hika");
        tcpip.send(attempts);
    }

}
