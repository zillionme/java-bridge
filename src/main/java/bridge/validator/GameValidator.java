package bridge.validator;

import bridge.domain.Bridge;

import java.util.Arrays;

import static bridge.BridgeRule.BRIDGE_LENGTH_MAX;
import static bridge.BridgeRule.BRIDGE_LENGTH_MIN;
import static bridge.BridgeRule.COMMAND_QUIT;
import static bridge.BridgeRule.COMMAND_RETRY;
import static bridge.Exception.ERROR_MESSAGE_INVALID_MOVE;
import static bridge.Exception.ERROR_MESSAGE_OUT_OF_RANGE;

public class GameValidator {
    public static void validateBridgeSize(int size) {
        if(BRIDGE_LENGTH_MAX < size || size < BRIDGE_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    public static void validateMovingInput (String input) {
        Arrays.stream(Bridge.values())
                .filter(bridge-> bridge.isSymbolEqualTo(input))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(ERROR_MESSAGE_INVALID_MOVE));

    }

    public static void validateCommand(String input) {
        if(!input.equals(COMMAND_RETRY) && !input.equals(COMMAND_QUIT)){
            throw new IllegalArgumentException();
        }
    }
}
