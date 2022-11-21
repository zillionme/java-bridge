package bridge.domain;

import bridge.util.GameResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class PlayerStatus {
    private String movingResultSymbol;
    private Map<Bridge, List<String>> playerStatusMap;

    public void setDefault() {
        this.playerStatusMap = new HashMap<>();
        Arrays.stream(Bridge.values())
                .forEach(bridge -> playerStatusMap.put(bridge, new ArrayList<>()));
    }

    /** update player's status */
    public void update(boolean isMovable, int location, String playerMoving) {
        this.movingResultSymbol = GameResult.getMovingResultBy(isMovable);
        updatePlayerStatusMap(location, playerMoving);
    }

    public void updatePlayerStatusMap(int location, String playerMoving) {
        for (Bridge eachBridge : playerStatusMap.keySet()) {
            addStatusToEachBridge(eachBridge, location, playerMoving);
        }
    }

    public void addStatusToEachBridge(Bridge eachBridge, int location, String playerMoving) {
        List<String> eachBridgeStatus = playerStatusMap.get(eachBridge);

        if (playerMoving.equals(eachBridge.getSymbol())) {
            eachBridgeStatus.add(location, movingResultSymbol);
            return;
        }
        eachBridgeStatus.add(location, " ");
    }

    /** toString */
    @Override
    public String toString() {
        return String.join("\n", getPlayerStatus());
    }

    public List<String> getPlayerStatus() {
        List<String> playerStatus = new ArrayList<>();

        for (Bridge eachBridge : Bridge.values()) {
            List<String> eachBridgeStatus = playerStatusMap.get(eachBridge);
            playerStatus.add(statusToString(eachBridgeStatus));
        }

        return playerStatus;
    }

    // 서비스 로직
    public String statusToString(List<String> eachBridgeStatus) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");

        for (String step : eachBridgeStatus) {
            sj.add(step);
        }
        return sj.toString();
    }

}

