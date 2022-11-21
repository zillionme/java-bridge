package bridge.validator;

import static bridge.validator.Exception.ERROR_MESSAGE_FOR_NOT_NUMBER;

public class ViewValidator {
    public static void isNumber(String input) {
        if(input.chars().allMatch(Character::isDigit)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NOT_NUMBER);
    }
}
