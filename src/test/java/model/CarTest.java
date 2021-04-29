package model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void carNameTest() {
        Car car = new Car("name");
        assertThat(car.getName()).isEqualTo("name");
        car = new Car("한글이름은");
        assertThat(car.getName()).isEqualTo("한글이름은");
    }

    @Test
    public void 길어서_유효하지않은_자동차이름_Test() {
        assertThatThrownBy(() -> {
            Car car = new Car("Longer");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Car car = new Car("한글이름은?");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 짧아서_유효하지않은_자동차이름_Test() {
        assertThatThrownBy(() -> {
            Car car = new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
