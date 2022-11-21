package bridge.util.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

}
