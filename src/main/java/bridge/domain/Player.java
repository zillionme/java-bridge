package bridge.domain;

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

    public int getLocation() {
        return location;
    }
}
