package mastermind.server.dispatchers;


import mastermind.controllers.GameController;

public class IsWinnerDispatcher extends Dispatcher {


    public IsWinnerDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        Boolean isWinner = ((GameController) acceptorController).isWinner();
        tcpip.send(isWinner);
    }

}
