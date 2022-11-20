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


    public void judge(String playerMoving) {
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }



    public boolean isSuccessfullyCompleted() {
        return movingResult && pointer == bridge.size();
    }
    public void quit() {
        isPlaying = false;
    }
    public boolean isPlaying() {
        return isPlaying;
    }

    public boolean getMovingResultBoolean() {
        return movingResult;
    }
    public int getTryCount() {
        return tryCount;
    }

}
