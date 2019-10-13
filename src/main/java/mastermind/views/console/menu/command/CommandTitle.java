package mastermind.views.console.menu.command;

public enum CommandTitle {

    PROPOSE_COMBINATION_COMMAND("Propose Combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposaln"),
    EXIT_COMMAND("Exit"),
    OPEN_SAVED_GAME_COMMAND("Open a saved game"),
    NEW_GAME_COMMAND("New game");

    
    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
