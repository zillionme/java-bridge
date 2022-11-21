package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    private final Player player = new Player();
    private final List<String> bridge = List.of("U", "U", "D", "D");

    @DisplayName("다리 길이(4) 넘어서 이동하려고 하면 예외 발생하는지 테스트")
    @Test
    void isMovableByErrorTest() {
        for(int i = 0; i<4; i++) {
            player.updatePlayerStatus(true, "U");
        }

        assertThatThrownBy(()->player.isMovableBy("U",bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 다리 끝에 성공적으로 도착했는지 여부 확인 테스트")
    @ParameterizedTest
    @MethodSource("provideMovingResult_PlayerMoving_Expected")
    void isArrivedTest(List<Boolean> movingResult,List<String> playerMoving, boolean expected) {
        for(int i = 0; i < movingResult.size(); i++) {
            player.updatePlayerStatus(movingResult.get(i), playerMoving.get(i));
        }

        assertThat(player.isArrived(bridge.size())).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMovingResult_PlayerMoving_Expected() {
        return Stream.of(
                Arguments.of(List.of(true), List.of("U"),false),
                Arguments.of(List.of(true, true, true, true), List.of("U", "U", "D", "D"),true),
                Arguments.of(List.of(true, true, true, false), List.of("U", "U", "D", "U"),false)
        );
    }
}
