package mastermind.server.dispatchers;


import java.util.List;

import mastermind.controllers.GameController;
import mastermind.types.Color;

public class GetColorsDispatcher extends Dispatcher {


    public GetColorsDispatcher(GameController gameController) {
        super(gameController);
    }

    @Override
    public void dispatch() {
        int position = this.tcpip.receiveInt();
        List<Color> colors = ((GameController) this.acceptorController).getColors(position);
        tcpip.send(colors);
    }

}
