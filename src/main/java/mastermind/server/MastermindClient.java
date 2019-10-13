package mastermind.server;

import mastermind.Mastermind;
import mastermind.server.proxy.LogicProxy;

public class MastermindClient extends Mastermind {

    public MastermindClient() {
        super();
        logic = new LogicProxy();
    }

    public static void main(String[] args) {
        new MastermindClient().play();
    }
    

    @Override
    protected Boolean isStandalone() {
        return false;
    }

}
