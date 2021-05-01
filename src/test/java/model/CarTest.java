package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Cars cars;

    @BeforeEach
    public void setup() {
        cars = new Cars();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

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

    @Test
    public void cars_이미_들어가있는_이름인지_Test() {
        assertThat(cars.checkSameName("car2")).isTrue();
        assertThat(cars.checkSameName("car5")).isFalse();
    }

    @Test
    public void cars_전진조건_정상동작여부_위치_Test() {
        Car car = new Car("car1");
        int previousLocation = car.getCurrentLocation();
        assertThat(car.movingWithFuel(3)).isEqualTo(previousLocation);
        assertThat(car.movingWithFuel(4)).isEqualTo(previousLocation + 1);
    }
}
