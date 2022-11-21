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

    public boolean isSymbolEqualTo(String input) {
        return this.symbol.equals(input);
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMappingNumber() {
        return mappingNumber;
    }
}
