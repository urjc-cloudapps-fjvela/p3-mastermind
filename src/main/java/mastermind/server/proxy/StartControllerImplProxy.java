package mastermind.server.proxy;

import java.util.List;

import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class StartControllerImplProxy extends StartController {

    private TCPIP tcpip;

    public StartControllerImplProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void start() {
        tcpip.send(FrameType.START);
    }

    @Override
    public void start(String fileName) {
        tcpip.send(FrameType.START_OPEN_SAVED_GAME);
        tcpip.send(fileName);

    }

    @Override
    public String[] getSavedGamesNames() {
        tcpip.send(FrameType.GET_SAVED_GAMES_NAMES);
        List<String> result = tcpip.receiveStringArray();
        return result.toArray(new String[result.size()]);
    }

}
