package mastermind.server;

import mastermind.server.dispatchers.DispatcherPrototype;

public class MastermindServer {

    private DispatcherPrototype dispatcherPrototype;

    private LogicServer logicServer;

    private MastermindServer() {
        this.dispatcherPrototype = new DispatcherPrototype();
        this.logicServer = new LogicServer(true);
        this.logicServer.createDispatchers(dispatcherPrototype);
    }

    public static void main(String[] args) {
        new MastermindServer().serve();
    }

    private void serve() {
        dispatcherPrototype.serve();
    }

}
