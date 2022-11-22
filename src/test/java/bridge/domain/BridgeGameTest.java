package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    private static Stream<Arguments> providePlayerMovings_And_ExpectedStatus() {
        return Stream.of(
                Arguments.of(List.of("U"), "[ O ]\n[   ]"),
                Arguments.of(List.of("U", "U"), "[ O | O ]\n[   |   ]"),
                Arguments.of(List.of("U", "U", "D"), "[ O | O |   ]\n[   |   | X ]"),
                Arguments.of(List.of("U", "U", "D", "D"), "[ O | O |   |   ]\n[   |   | X | O ]")
        );
    }

    private static Stream<Arguments> providePlayerMovings_And_RetriedStatus() {
        return Stream.of(
                Arguments.of(List.of("U"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U", "D"), "[  ]\n[  ]"),
                Arguments.of(List.of("U", "U", "D", "D"), "[  ]\n[  ]")
        );
    }

    private static Stream<Arguments> providePlayerMovings() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "U", "D", "D")),
                Arguments.of(List.of("U", "U", "U", "D", "D", "U"))

        );
    }

    @BeforeEach
    void set() {
        List<String> bridge = List.of("U", "U", "U", "D");
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
    @ValueSource(strings = {"K", "R"})
    void judgeErrorTest(String playerMoving) {
        assertThatThrownBy(() -> bridgeGame.judge(playerMoving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 후, 플레이어 상태가 업데이트 되는지 확인 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerMovings_And_ExpectedStatus")
    void moveTest(List<String> playerMovings, String expectedStatus) {
        for (String playingMoving : playerMovings) {
            bridgeGame.move(playingMoving);
        }
        assertThat(bridgeGame.getPlayerStatus()).contains(expectedStatus);
    }

    @DisplayName("이동 시, 다리 길이 이상 이동하려고 하면 예외 발생 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerMovings")
    void moveErrorTest(List<String> playerMovings) {

        assertThatThrownBy(() -> {
            for (String moving : playerMovings) {
                bridgeGame.move(moving);
            }
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("retry시, 플레이어 상태 테스트")
    @ParameterizedTest
    @MethodSource("providePlayerMovings_And_RetriedStatus")
    void retryTest(List<String> playerMovings, String expectedStatus) {
        for (String playingMoving : playerMovings) {
            bridgeGame.move(playingMoving);
        }
        bridgeGame.retry();
        assertThat(bridgeGame.getPlayerStatus()).contains(expectedStatus);
    }

    @DisplayName("잘못된 명령이 들어왔을 때, 예외발생하는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q,k,h"})
    void executeCommandErrorTest(String command) {
        assertThatThrownBy(() -> bridgeGame.executeCommand(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 명령이 들어왔을 때, 예외발생 메시지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"q,k,h"})
    void executeCommandErrorMessageTest(String command) {
        try {
            bridgeGame.executeCommand(command);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("[ERROR]");
        }
    }

}
