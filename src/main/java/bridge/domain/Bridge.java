package bridge.domain;

public enum Bridge {
    UP_BRIDGE("U",1),
    DOWN_BRIDGE("D",0);

    private final String symbol;
    private final int mappingNumber;

    Bridge(String symbol, int mappingNumber) {
        this.symbol = symbol;
        this.mappingNumber = mappingNumber;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getMappingNumber() {
        return mappingNumber;
    }
}
