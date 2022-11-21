package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void set() {
        List<String> bridge = List.of("U","U","U","D");
        Player player = new Player();
        bridgeGame = new BridgeGame(bridge, player);
    }

    @DisplayName("이동 가능 여부를 예상한대로 판별하는지 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void judgeTest(String playerMoving, boolean expected) {
        assertThat(bridgeGame.judge(playerMoving)).isEqualTo(expected);
    }

    @DisplayName("다리 기호가 아닌, 이동 값을 입력하는 경우 예외 발생하는지 테스트한다.")
    @ParameterizedTest
    @ValueSource (strings = {"K", "R"})
    void judgeErrorTest(String playerMoving) {
        assertThatThrownBy(()-> bridgeGame.judge(playerMoving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
    }

    @Test
    void retry() {
    }

    @Test
    void quit() {
    }

    @Test
    void executeCommand() {
    }

    @Test
    void getGameResult() {
    }

    @Test
    void isSuccessfullyCompleted() {
    }

    @Test
    void isCompletedOrStopped() {
    }

    @Test
    void getPlayerStatus() {
    }

    @Test
    void getPlayerTryCount() {
    }
}
