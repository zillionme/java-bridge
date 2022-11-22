package bridge.util.constants;

public enum ErrorCode {
    ERROR_MESSAGE_FOR_NULL_OR_EMPTY("값을 입력해주세요."),
    ERROR_MESSAGE_FOR_NOT_NUMBER("숫자를 입력해주세요."),
    ERROR_MESSAGE_FOR_NOT_BRIDGE_NUMBER("숫자에 해당하는 다리가 없습니다."),
    ERROR_MESSAGE_OUT_RANGE_OF_BRIDGE("다리를 모두 건넜습니다."),
    ERROR_MESSAGE_OUT_OF_RANGE("3이상 20 이하의 숫자를 입력해주세요."),
    ERROR_MESSAGE_INVALID_MOVE("이동할 칸이 올바르지 않습니다. (위: U, 아래: D)"),
    ERROR_MESSAGE_INVALID_COMMAND("명령이 올바르지 않습니다. (재시도: R, 종료: Q)");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN+errorMessage;
    }

    public IllegalArgumentException throwException() {
        throw new IllegalArgumentException(this.getErrorMessage());
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
