package bridge.domain;

import java.util.*;

//import static bridge.BridgeRule.MOVABLE_SYMBOL;
//import static bridge.BridgeRule.UNMOVABLE_SYMBOL;


public class PlayerStatus {
    private String movingResultSymbol;
    private Map<Bridge, List<String>> playerStatusMap;

    public void setDefault() {
        this.playerStatusMap = new HashMap<>();
        Arrays.stream(Bridge.values()).forEach(bridge -> {
            playerStatusMap.put(bridge, new ArrayList<>());
        });
    }

    /**
     * update player's status
     */
    public void update(boolean movingResult, int location, String playerMoving) {
        this.movingResultSymbol = getMovingResultSymbol(movingResult);
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

    public String getMovingResultSymbol(boolean movingResult) {
        return Arrays.stream(GameResult.values())
                .filter(result -> result.isEqualTo(movingResult))
                .findFirst().get().getSymbol();

//        if (movingResult) {
//            return MOVABLE_SYMBOL;
//        }
//        return UNMOVABLE_SYMBOL;
    }

    /**
     * toString
     */
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

    //util 로직
    public String statusToString(List<String> eachBridgeStatus) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");

        for (String step : eachBridgeStatus) {
            sj.add(step);
        }
        return sj.toString();
    }

}

