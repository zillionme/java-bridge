package bridge.domain;

public enum GameResult {
    SUCCESS(true,"O","성공"),
    FAIL(false,"X","실패");

    private final boolean value;
    private final String symbol;
    private final String korean;

    GameResult(boolean value, String symbol, String korean) {
        this.value = value;
        this.symbol = symbol;
        this.korean = korean;
    }

    public boolean isEqualTo(boolean movingResult) {
        return this.value == movingResult;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getKorean() {
        return korean;
    }
}
