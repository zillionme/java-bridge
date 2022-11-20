package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeRule.*;
import static bridge.Exception.ERROR_MESSAGE_OUT_OF_RANGE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> bridge = new ArrayList<>();
        
        while (bridge.size() != size) {
            int randomNumber = bridgeNumberGenerator.generate();
            bridge.add(getSymbolByNumber(randomNumber));
        }

        return bridge;
    }

    public String getSymbolByNumber(int number) {
        if (number == DOWN_BRIDGE_NUMBER) {
            return DOWN_BRIDGE_SYMBOL;
        }
        return UP_BRIDGE_SYMBOL;
    }

    public void validateBridgeSize(int size) {
        if(BRIDGE_LENGTH_MAX < size || size < BRIDGE_LENGTH_MIN) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }
}
