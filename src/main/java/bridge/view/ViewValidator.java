package bridge.view;

public class ViewValidator {
    public static boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit); //음수면 false
    }
}
