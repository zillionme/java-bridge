package bridge;

import static bridge.BridgeRule.RESULT_FAIL;
import static bridge.BridgeRule.RESULT_SUCCESS;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static String MESSAGE_TO_OUTPUT_START = "다리 건너기 게임을 시작합니다.";
    public static String MESSAGE_TO_OUTPUT_FINAL_RESULT = "\n최종 게임 결과";
    public static String MESSAGE_TO_OUTPUT_RESULT_SUCCESS = "게임 성공 여부: ";
    public static String MESSAGE_TO_OUTPUT_RESULT_TRYCOUNT = "총 시도한 횟수: ";


    public void printStart() {
        System.out.println(MESSAGE_TO_OUTPUT_START);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.getPlayerStatusMap());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(MESSAGE_TO_OUTPUT_FINAL_RESULT);

        printMap(bridgeGame);
        printSuccessOrFail(bridgeGame);
        printTrtCount(bridgeGame);
    }

    public void printSuccessOrFail(BridgeGame bridgeGame) {
        if (bridgeGame.isSuccessfullyCompleted()) {
            System.out.println(MESSAGE_TO_OUTPUT_RESULT_SUCCESS + RESULT_SUCCESS);
            return;
        }
        System.out.println(MESSAGE_TO_OUTPUT_RESULT_SUCCESS + RESULT_FAIL);
    }

    public void printTrtCount(BridgeGame bridgeGame) {
        System.out.println(MESSAGE_TO_OUTPUT_RESULT_TRYCOUNT+ bridgeGame.getTryCount());
    }

}
