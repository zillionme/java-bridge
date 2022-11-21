package bridge.util.validation;

import bridge.domain.Bridge;
import bridge.util.constants.Exception;
import java.util.List;

import static bridge.util.constants.GameRule.BRIDGE_LENGTH_MAX;
import static bridge.util.constants.GameRule.BRIDGE_LENGTH_MIN;
import static bridge.util.constants.GameRule.COMMAND_QUIT;
import static bridge.util.constants.GameRule.COMMAND_RETRY;

public class GameValidator {
    public static void validateBridgeSize(int size) {

        if (BRIDGE_LENGTH_MAX < size || size < BRIDGE_LENGTH_MIN) {
            throw new IllegalArgumentException(Exception.ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    public static void validateMovingInput(String input) {
        for (Bridge bridge : Bridge.values()) {
            if (input.equals(bridge.getSymbol())) {
                return;
            }
        }
        throw new IllegalArgumentException(Exception.ERROR_MESSAGE_INVALID_MOVE);
    }

    public static void validateCommand(String input) {
        if (!input.equals(COMMAND_RETRY) && !input.equals(COMMAND_QUIT)) {
            throw new IllegalArgumentException(Exception.ERROR_MESSAGE_INVALID_COMMAND);
        }
    }

    public static void validatePlayerLocation(int location, List<String> bridge) {
        if(location >= bridge.size()) {
            throw new IllegalArgumentException(Exception.ERROR_MESSAGE_OUT_RANGE_OF_BRIDGE);
        }
    }
}
