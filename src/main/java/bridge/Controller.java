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
            moveByInput(bridgeGame);
            outputView.printMap(bridgeGame);

            decideToKeepPlaying(bridgeGame);
        }
    }

    public void moveByInput(BridgeGame bridgeGame) {
        String playerMoving = inputView.readMoving();
        Validator.validateMovingInput(playerMoving);

        bridgeGame.move(playerMoving);
    }

    public void decideToKeepPlaying(BridgeGame bridgeGame) {
        if(player.isFailed()) { //이동결과 실패하면, 명령 받기
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

}
