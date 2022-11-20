package bridge.domain;

import java.util.List;

public class Player {
    private PlayerStatus playerStatus = new PlayerStatus();
    private boolean movingResult;
    private int location;
    private int tryCount = 1;

    public Player() {
        setDefault();
    }

    public void setDefault() {
        location = 0;
        playerStatus.setDefault();
    }

    public void updatePlayerStatus(boolean movingResult, String playerMoving) {
        this.movingResult = movingResult;
        playerStatus.update(movingResult, location, playerMoving);
        location++;
    }

    public void retry() {
        setDefault();
        tryCount++;
    }

    public boolean isArrived(int bridgeSize) {
        return movingResult && location == bridgeSize;
    }

    public boolean compare(String playerMoving, List<String> bridge) {
        String bridgeMoving = bridge.get(location);
        return playerMoving.equals(bridgeMoving);
    }

    public boolean isFailed() {
        return !movingResult;
    }


    public int getTryCount() {
        return tryCount;
    }

    public String getPlayerStatus() {
        return playerStatus.toString();
    }
}
