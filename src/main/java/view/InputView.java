package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static util.ErrorCode.NOT_NUMBER;
import static util.ErrorCode.NOT_VALID_INPUT;

public class InputView {

    private static final String MESSAGE_INPUT = "을 입력하세요.";

    //문자열 입력 : 문자열 비었는지 검사하고 문자열 반환
    public String readString() {
        System.out.println(MESSAGE_INPUT);
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    //숫자 입력 : 문자열 비었는지 검사하고, 숫자인지 검사하고 문자열 반환
    public int readInt() {
        String input = Console.readLine();
        validateInput(input);
        validateNumber(input);
        return Integer.parseInt(input.trim());
    }

    //문자열리스트 입력 : 문자열 비었는지 검사하고 - 공백제거한 문자열로 반환
    public List<String> readList() {
        System.out.println();
        String input = Console.readLine();
        validateInput(input);

        return createList(input);
    }

    public List<String> createList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    //숫자인지 +양수인지(음수이면 오류 발생)
    public void validateNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw NOT_NUMBER.throwError();
        }
    }

    public void validateInput(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw NOT_VALID_INPUT.throwError();
        }
    }
}
