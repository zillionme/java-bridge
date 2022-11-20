package bridge;

import java.util.List;

import static bridge.BridgeRule.COMMAND_QUIT;
import static bridge.BridgeRule.COMMAND_RETRY;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void generate() {
        outputView.printStart();
        BridgeGame bridgeGame = createBridgeGame();

        //최종 결과가 false이고, 게임 중인 동안만
        while (true) {
            playBridgeGame(bridgeGame);
        }

    }

    public BridgeGame createBridgeGame() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return new BridgeGame(bridge);
    }

    public void playBridgeGame(BridgeGame bridgeGame) {
        String playerMoving = inputView.readMoving();
        bridgeGame.move(playerMoving);
        outputView.printMap(bridgeGame);

        decideToKeepPlaying(bridgeGame);
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

}
