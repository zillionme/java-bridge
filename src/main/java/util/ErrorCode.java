package util;

public enum ErrorCode {
    NOT_VALID_INPUT("값이 입력되지 않았습니다"),
    NOT_NUMBER("숫자를 입력하지 않았습니다");

    private static final String ERROR_BEGIN = "[ERROR] ";
    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = ERROR_BEGIN + errorMessage;
    }

    public IllegalArgumentException throwError() {
        return new IllegalArgumentException(this.errorMessage);
    }
}
