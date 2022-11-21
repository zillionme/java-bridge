package bridge.util.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameValidatorTest {

    @DisplayName("다리 길이가 지정된 범위 밖이면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,21,0,-1})
    void validateBridgeSizeErrorTest(int size) {
        assertThatThrownBy(()->GameValidator.validateBridgeSize(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동하려는 다리의 기호가 없으면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"K","u","d","UP_BRIDGE"})
    void validateMovingInputErrorTest(String input) {
        assertThatThrownBy(()-> GameValidator.validateMovingInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("명령이 게임룰 상수에 없으면, 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"K","q","Quit","Restart"})
    void validateCommandErrorTest(String input) {
        assertThatThrownBy(()->GameValidator.validateCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 다리 길이 이상으로 이동하려고 하면, 예외 발생 테스트")
    @ParameterizedTest
    @MethodSource("provideLocation_Bridge")
    void validatePlayerLocationErrorTest(int location, List<String> bridge) {
        assertThatThrownBy(()->GameValidator.validatePlayerLocation(location, bridge))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideLocation_Bridge() {
        return Stream.of(
                Arguments.of(10,List.of("U", "U", "D", "D")),
                Arguments.of(4,List.of("U", "D", "U", "D"))
        );
    }

}
