package bridge;

import bridge.domain.Player;

import java.util.*;

import static bridge.BridgeRule.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private Player player;
    private boolean isPlaying; // 생성시 start()메서드로 감싸고, true로 초기화함


    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.isPlaying = true;
    }

    //Movingresult를 게임 클래스로? isMovable로 변경??
    public boolean judge(String playerMoving) {
        int location = player.getLocation();
        String bridgeMoving = bridge.get(location);

        return playerMoving.equals(bridgeMoving);
    }

    public void move(String playerMoving) {
        boolean movingResult = judge(playerMoving);
        player.updatePlayerStatus(movingResult, playerMoving);
    }

    public void retry() {
        player.retry();
    }

    public void quit() {
        isPlaying = false;
    }

}
