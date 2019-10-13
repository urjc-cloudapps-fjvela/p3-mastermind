package mastermind.server.proxy;

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
        this.tcpip.send(FrameType.START);
    }

}
