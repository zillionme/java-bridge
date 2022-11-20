package bridge;

import java.util.*;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void generate() {
            outputView.printStart();
            BridgeGame bridgeGame = createBridgeGame();
    }

    public BridgeGame createBridgeGame() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return new BridgeGame(bridge);
    }

}
