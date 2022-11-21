package bridge.util.validation;

import bridge.util.constants.Exception;

public class ViewValidator {
    public static void isNumber(String input) {
        if (input.chars().allMatch(Character::isDigit)) {
            return;
        }

        throw new IllegalArgumentException(Exception.ERROR_MESSAGE_FOR_NOT_NUMBER);
    }

    public static void isNotEmptyOrNull(String input) {
        if(input==null || input.isEmpty()) {
            throw new IllegalArgumentException(Exception.ERROR_MESSAGE_FOR_NULL_OR_EMPTY);
        }
    }
}
