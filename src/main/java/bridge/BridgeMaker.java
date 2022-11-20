package bridge;

import bridge.domain.Bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bridge.BridgeRule.*;

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
        List<String> bridge = new ArrayList<>();

        while (bridge.size() != size) {
            addMovesToBridge(bridge);
        }

        return bridge;
    }

    public void addMovesToBridge(List<String> bridge) {
        int randomNumber = bridgeNumberGenerator.generate();
        bridge.add(getSymbolByNumber(randomNumber));
    }

    public String getSymbolByNumber(int number) {
        
        return Arrays.stream(Bridge.values())
                .filter(bridge -> bridge.getMappingNumber() == number)
                .findFirst()
                .get().getSymbol();
    }


}
