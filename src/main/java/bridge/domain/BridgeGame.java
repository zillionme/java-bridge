package bridge.domain;

import java.util.List;

import static bridge.BridgeRule.COMMAND_QUIT;
import static bridge.BridgeRule.COMMAND_RETRY;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final Player player;
    private boolean isPlaying;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        this.isPlaying = true;
    }


    public boolean judge(String playerMoving) {
        return player.compare(playerMoving, bridge);
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

    public void executeCommand(String command) {
        if(command.equals(COMMAND_RETRY)){
            retry();
        }

        if(command.equals(COMMAND_QUIT)){
            quit();
        }
    }

    // 게임 결과 (enum으로 처리가능) / movingResult도 저장할 수 있으면 좋을듯 하다.
    public boolean isSuccessfullyCompleted(){
        return player.isArrived(bridge.size());
    }
    public boolean isCompletedOrStopped() {
        return isSuccessfullyCompleted() || !isPlaying;
    }

    public String getPlayerStatus() {
        return player.getPlayerStatus();
    }

    public int getPlayerTryCount() {
        return player.getTryCount();
    }

}
