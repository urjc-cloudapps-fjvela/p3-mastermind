package mastermind.server;

import mastermind.Mastermind;

public class MastermindClient extends Mastermind {

    public static void main(String[] args) {
        new MastermindClient().play();
    }

    @Override
    protected Boolean isStandalone() {
        return false;
    }

}
