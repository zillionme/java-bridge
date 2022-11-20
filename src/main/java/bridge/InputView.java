package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Exception.ERROR_MESSAGE_FOR_NOT_NUMBER;

/**
 * 사용자로부터 입력을 받는 역할을 한다. 숫자 아니면 예외발생
 */
public class InputView {
    public static String MESSAGE_TO_INPUT_BRIDGE_LENGTH = "\n다리 길이를 입력해주세요.";
    public static String MESSAGE_TO_INPUT_STEP = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static String MESSAGE_TO_INPUT_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다. +
     */
    public int readBridgeSize() {
        System.out.println(MESSAGE_TO_INPUT_BRIDGE_LENGTH);
        String input = Console.readLine().trim();

        return castToInt(input);
    }

    //서비스로직
    public int castToInt(String input) {
        if(isNumber(input)) {
            return Integer.parseInt(input);
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_FOR_NOT_NUMBER);
    }

    public boolean isNumber(String input) {
        return input.chars().allMatch(Character::isDigit); //음수면 false
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MESSAGE_TO_INPUT_STEP);
        String input = Console.readLine().trim();

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
