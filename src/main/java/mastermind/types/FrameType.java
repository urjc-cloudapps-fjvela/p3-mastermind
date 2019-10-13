package mastermind.types;

public enum FrameType {
    START,
    UNDO,
    REDO,
    IS_UNDOABLE,
    IS_REDOABLE,
    GET_ATTEMPTS,
    GET_COLORS,
    ADD_PROPOSED_COMBINATION,
    IS_WINNER,
    IS_LOOSER,
    GET_BLACKS,
    GET_WHITES,
    CLOSE
    ;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
