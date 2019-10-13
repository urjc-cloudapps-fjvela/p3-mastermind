package mastermind.server.proxy;

import mastermind.controllers.SaveController;
import mastermind.models.Session;
import mastermind.types.FrameType;
import santaTecla.utils.TCPIP;

public class SaveControllerImplProxy extends SaveController {

    private TCPIP tcpip;

    public SaveControllerImplProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void save(String fileName) {
        tcpip.send(FrameType.SAVE);
        tcpip.send(fileName);
    }

    @Override
    public void nextState() {
        tcpip.send(FrameType.NEXT_STATE);
    }

    @Override
    public boolean existsFileName(String fileName) {

        tcpip.send(FrameType.EXITS_FILE);
        tcpip.send(fileName);
        return tcpip.receiveBoolean();
    }

}
