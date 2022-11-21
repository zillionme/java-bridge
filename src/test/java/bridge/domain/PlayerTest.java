package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
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

}
