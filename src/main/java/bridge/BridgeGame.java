package bridge;

import java.util.*;

import static bridge.BridgeRule.*;
import static bridge.Exception.ERROR_MESSAGE_INVALID_MOVE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private Map<String, List<String>> playerStatusMap;
    private int pointer;
    private boolean movingResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        setDefaultPlayerStatus();
    }

    public void setDefaultPlayerStatus() {
        this.pointer = 0;
        this.playerStatusMap = new HashMap<>();
        playerStatusMap.put(DOWN_BRIDGE_SYMBOL, new ArrayList<>());
        playerStatusMap.put(UP_BRIDGE_SYMBOL, new ArrayList<>());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String playerMoving) {
    }

    public boolean judgePlayerMoving(String playerMoving) {
        String bridgeMoving = bridge.get(pointer);

        if(playerMoving.equals(bridgeMoving)){
            return true;
        }
        return false;
    }

    public void updatePlayerStatusMap(String playerMoving) {

        for(String eachBridge : playerStatusMap.keySet()) {
            addStatusToEachBridge(eachBridge, playerMoving);
        }
    }

    public void addStatusToEachBridge(String eachBridge, String playerMoving) {
        List<String> eachBridgeStatus = playerStatusMap.get(eachBridge);

        if (playerMoving.equals(eachBridge)) {
            eachBridgeStatus.add(pointer, getMovingResultSymbol());
        }

        eachBridgeStatus.add(pointer, " ");
    }

    public String getMovingResultSymbol() {
        if(movingResult) {
            return MOVABLE_SYMBOL;
        }
        return UNMOVABLE_SYMBOL;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }


}
