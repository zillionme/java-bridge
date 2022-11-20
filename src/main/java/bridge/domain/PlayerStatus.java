package bridge.domain;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

import static bridge.BridgeRule.DOWN_BRIDGE_SYMBOL;
import static bridge.BridgeRule.UP_BRIDGE_SYMBOL; //ENUM으로 활용 가능

public class PlayerStatus {
    private Map<String, List<String>> playerStatusMap;

    public void setDefault() {
        this.playerStatusMap = new HashMap<>();
        playerStatusMap.put(DOWN_BRIDGE_SYMBOL, new ArrayList<>());
        playerStatusMap.put(UP_BRIDGE_SYMBOL, new ArrayList<>());
    }

}

