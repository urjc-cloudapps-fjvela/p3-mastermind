package mastermind.server;

import mastermind.controllers.server.LogicServerImplServer;
import mastermind.server.dispatchers.DispatcherPrototype;

public class MastermindServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicServerImplServer logicServer;
    

    private MastermindServer() {
        dispatcherPrototype = new DispatcherPrototype();
        logicServer = new LogicServerImplServer();
        logicServer.createDispatchers(dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        dispatcherPrototype.serve();
    }

}
