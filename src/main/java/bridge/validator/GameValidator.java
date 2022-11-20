package bridge.validator;

import static bridge.BridgeRule.*;
import static bridge.BridgeRule.UP_BRIDGE_SYMBOL;
import static bridge.Exception.ERROR_MESSAGE_INVALID_MOVE;
import static bridge.Exception.ERROR_MESSAGE_OUT_OF_RANGE;

public class GameValidator {
    public static void validateBridgeSize(int size) {
        if(BRIDGE_LENGTH_MAX < size || size < BRIDGE_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    public static void validateMovingInput (String input) {
        if(!input.equals(DOWN_BRIDGE_SYMBOL) && !input.equals(UP_BRIDGE_SYMBOL)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_MOVE);
        }
    }

    public static void validateCommand(String input) {
        if(!input.equals(COMMAND_RETRY) && !input.equals(COMMAND_QUIT)){
            throw new IllegalArgumentException();
        }
    }
}
