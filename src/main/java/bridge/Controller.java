package bridge;

import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.BridgeRule.COMMAND_QUIT;
import static bridge.BridgeRule.COMMAND_RETRY;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final Player player = new Player();

    public void generate() {
        try {
            outputView.printStart();

            BridgeGame bridgeGame = createBridgeGame();
            playBridgeGame(bridgeGame);

            outputView.printResult(bridgeGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }

    }

    public BridgeGame createBridgeGame() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return new BridgeGame(bridge,player);
    }

    public void playBridgeGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isCompletedOrStopped()) {
            String playerMoving = inputView.readMoving();
            bridgeGame.move(playerMoving);
            outputView.printMap(bridgeGame);

            decideToKeepPlaying(bridgeGame);
        }
    }

    public void decideToKeepPlaying(BridgeGame bridgeGame) {
        if(!bridgeGame.getMovingResultBoolean()) { //이동결과 실패하면, 명령 받기
            String command = getCommand();
            executeCommand(bridgeGame, command);
        }
    }

    public String getCommand() {
        String command = inputView.readGameCommand();
        Validator.validateCommand(command);

        return command;
    }

    public void executeCommand (BridgeGame bridgeGame, String command) {
        if(command.equals(COMMAND_RETRY)){
            bridgeGame.retry();
        }

        if(command.equals(COMMAND_QUIT)){
            bridgeGame.quit();
        }
    }


    //완전 성공한 경우 or 실패했지만 게임 그만둔 경우
    public boolean isCompletedOrStopped(BridgeGame bridgeGame) {
        return bridgeGame.isSuccessfullyCompleted() || !bridgeGame.isPlaying();
    }

}
