package bridge.domain;

import bridge.util.constants.ErrorCode;

import java.util.Arrays;

import static bridge.util.constants.Exception.ERROR_MESSAGE_FOR_NOT_BRIDGE_NUMBER;

public enum Bridge {
    UP_BRIDGE("U", 1),
    DOWN_BRIDGE("D", 0);

    private final String symbol;
    private final int mappingNumber;

    Bridge(String symbol, int mappingNumber) {
        this.symbol = symbol;
        this.mappingNumber = mappingNumber;
    }

    public static String getSymbolBy(int number) {
        return Arrays.stream(Bridge.values())
                .filter(bridge -> bridge.getMappingNumber() == number)
                .findFirst()
//                .orElseThrow(()-> new IllegalArgumentException(ERROR_MESSAGE_FOR_NOT_BRIDGE_NUMBER))
                .orElseThrow(ErrorCode.ERROR_MESSAGE_FOR_NOT_BRIDGE_NUMBER::throwException)
                .getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMappingNumber() {
        return mappingNumber;
    }
}
