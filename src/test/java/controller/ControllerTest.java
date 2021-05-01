package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

    private RacingGameController controller;

    @BeforeEach
    public void setup() {
        controller = new RacingGameController();
    }

    @DisplayName("0~ 9 사이의 랜덤수를 만든다.")
    @Test
    public void 전진조건을_결정하는_랜덤수_유효성_Test() {
        int i = 0;
        while (i++ < 50) {
            int number = controller.makeRandomIntRangeZeroToNine();
            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThanOrEqualTo(9);
        }
    }
}
