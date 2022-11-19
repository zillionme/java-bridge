package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다. 숫자 아니면 예외발생
 */
public class InputView {

    private static final String ERROR_MESSAGE_FOR_NOT_NUMBER ="[ERROR] 숫자를 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다. +
     */
    public int readBridgeSize() {
        String input = Console.readLine().trim();

        return castToInt(input);
    }

    //서비스로직
    public int castToInt(String input) {
        if(isPositiveNumber(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NOT_NUMBER);
    }

    public boolean isPositiveNumber(String input) {
        return input.chars().allMatch(Character::isDigit); //음수면 false
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
