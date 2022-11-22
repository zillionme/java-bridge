package bridge.util.validation;

import bridge.util.constants.ErrorCode;
import bridge.util.constants.Exception;

public class ViewValidator {
    public static void isNumber(String input) {
        if (input.chars().allMatch(Character::isDigit)) {
            return;
        }

        ErrorCode.ERROR_MESSAGE_FOR_NOT_NUMBER.throwException();
//        throw new IllegalArgumentException(Exception.ERROR_MESSAGE_FOR_NOT_NUMBER);
    }

    public static void isNotEmptyOrNull(String input) {
        if(input==null || input.isEmpty()) {
            ErrorCode.ERROR_MESSAGE_FOR_NULL_OR_EMPTY.throwException();

//            throw new IllegalArgumentException(Exception.ERROR_MESSAGE_FOR_NULL_OR_EMPTY);
        }
    }
}
