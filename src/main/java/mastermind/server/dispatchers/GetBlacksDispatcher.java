package mastermind.server.dispatchers;


import mastermind.controllers.GameController;

public class GetBlacksDispatcher extends Dispatcher {


    public GetBlacksDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        int position = tcpip.receiveInt();
        int blacks = ((GameController) this.acceptorController).getBlacks(position);
        tcpip.send(blacks);
    }

}
