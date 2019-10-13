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
    CLOSE,
    RESUME,
    GET_VALUE_STATE,
    GET_WIDTH,
    NEXT_STATE,
    CLEAR,
    RESET_STATE
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
