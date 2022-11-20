package bridge.domain;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

import static bridge.BridgeRule.DOWN_BRIDGE_SYMBOL;
import static bridge.BridgeRule.UP_BRIDGE_SYMBOL; //ENUM으로 활용 가능
import static bridge.BridgeRule.MOVABLE_SYMBOL;
import static bridge.BridgeRule.UNMOVABLE_SYMBOL;

public class PlayerStatus {
    private String movingResultSymbol;
    private Map<String, List<String>> playerStatusMap;

    public void setDefault() {
        this.playerStatusMap = new HashMap<>();
        playerStatusMap.put(DOWN_BRIDGE_SYMBOL, new ArrayList<>());
        playerStatusMap.put(UP_BRIDGE_SYMBOL, new ArrayList<>());
    }

    /** update player's status*/
    public void update(boolean movingResult, int location, String playerMoving) {
        this.movingResultSymbol = getMovingResultSymbol(movingResult);
        updatePlayerStatusMap(location, playerMoving);
    }

    public void updatePlayerStatusMap(int location, String playerMoving) {
        for (String eachBridge : playerStatusMap.keySet()) {
            addStatusToEachBridge(eachBridge, location, playerMoving);
        }
    }

    public void addStatusToEachBridge(String eachBridge, int location, String playerMoving) {
        List<String> eachBridgeStatus = playerStatusMap.get(eachBridge);

        if (playerMoving.equals(eachBridge)) {
            eachBridgeStatus.add(location, movingResultSymbol);
            return;
        }
        eachBridgeStatus.add(location, " ");
    }

    public String getMovingResultSymbol(boolean movingResult) {
        if (movingResult) {
            return MOVABLE_SYMBOL;
        }
        return UNMOVABLE_SYMBOL;
    }

    /** toString */
    @Override
    public String toString() {
        String upBridgeStatus = getEachBridgeStatus(UP_BRIDGE_SYMBOL);
        String downBridgeStatus = getEachBridgeStatus(DOWN_BRIDGE_SYMBOL);

        return upBridgeStatus + "\n" + downBridgeStatus;
    }

    public String getEachBridgeStatus(String eachBridge) {
        List<String> eachBridgeStatus = playerStatusMap.get(eachBridge);
        return eachStatusToString(eachBridgeStatus);
    }

    //util 로직
    public String eachStatusToString(List<String> eachBridgeStatus) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");

        for (String step : eachBridgeStatus) {
            sj.add(step);
        }
        return sj.toString();
    }

}

