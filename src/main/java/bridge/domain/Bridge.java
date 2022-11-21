package bridge.domain;

import java.util.Arrays;

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
        return symbol;
    }

    public int getMappingNumber() {
        return mappingNumber;
    }

    public static String getSymbolBy(int number) {
        return Arrays.stream(Bridge.values())
                .filter(bridge -> bridge.getMappingNumber() == number)
                .findFirst()
                .get().getSymbol();
    }
}
