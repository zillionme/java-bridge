package bridge.domain;

public class Player {
    private PlayerStatus playerStatus = new PlayerStatus();
    private int location;
    private int tryCount = 1;

    public Player() {
        setDefault();
    }

    public void setDefault() {
        location = 0;
        playerStatus.setDefault();
    }
}
