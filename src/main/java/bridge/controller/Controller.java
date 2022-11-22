package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.util.validation.GameValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final Player player = new Player();

    public void generate() {
            outputView.printStart();
            BridgeGame bridgeGame = createBridgeGame();
            playBridgeGame(bridgeGame);
            outputView.printResult(bridgeGame);
    }

    public BridgeGame createBridgeGame() {
        int size = inputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return new BridgeGame(bridge, player);
    }

    private int inputBridgeSize() {
        try {
            int size = inputView.readBridgeSize();
            GameValidator.validateBridgeSize(size); //브릿지 체커로 수정....? (다리 길이 입력에 문제)

            return size;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return inputBridgeSize();
    }

    public void playBridgeGame(BridgeGame bridgeGame) {
        while (!bridgeGame.isCompletedOrStopped()) {
            moveByInput(bridgeGame);
            outputView.printMap(bridgeGame);

            decideToKeepPlaying(bridgeGame);
        }
    }

    public void moveByInput(BridgeGame bridgeGame) {
            String playerMoving = inputPlayerMoving();
            bridgeGame.move(playerMoving);
    }

    public String inputPlayerMoving() {
        try {
            String playerMoving = inputView.readMoving();
            GameValidator.validateMovingInput(playerMoving); //수정...브릿지 게임과 반복됨 (이동 입력에 문제)

            return playerMoving;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return inputPlayerMoving();
    }

    public void decideToKeepPlaying(BridgeGame bridgeGame) {
        if (player.isFailed()) { //이동결과 실패하면, 명령 받기
            String command = inputCommand();
            bridgeGame.executeCommand(command);
        }
    }

    public String inputCommand() {
        try {
            String command = inputView.readGameCommand();
            GameValidator.validateCommand(command);       //수정...브릿지 게임과 반복됨 (명령 입력에 문제)

            return command;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
        return inputCommand();
    }

}
