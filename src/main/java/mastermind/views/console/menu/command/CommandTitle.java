package mastermind.views.console.menu.command;

public enum CommandTitle {

    PROPOSE_COMBINATION_COMMAND("Propose Combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposaln");

    
    private String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

}
