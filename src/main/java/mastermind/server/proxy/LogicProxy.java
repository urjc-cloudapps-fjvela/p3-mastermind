package mastermind.server.proxy;

import mastermind.controllers.Logic;

import mastermind.models.StateValue;
import mastermind.models.server.SessionImplServer;
import mastermind.server.proxy.GameControllerImplProxy;
import mastermind.server.proxy.ResumeControllerImplProxy;
import mastermind.server.proxy.StartControllerImplProxy;
import santaTecla.utils.TCPIP;

public class LogicProxy extends Logic {
    private TCPIP tcpip;

    public LogicProxy() {
        tcpip = TCPIP.createClientSocket();
        session = new SessionImplServer(this.tcpip);
    

        startController = new StartControllerImplProxy(session,tcpip);
        gameController = new GameControllerImplProxy(session,tcpip);
        resumeController = new ResumeControllerImplProxy(session, tcpip);

        controllers.put(StateValue.INITIAL, startController);
        controllers.put(StateValue.IN_GAME, gameController);
        controllers.put(StateValue.FINAL, resumeController);
        controllers.put(StateValue.EXIT, null);
    }

    public void close() {
        this.tcpip.close();
    }
}
