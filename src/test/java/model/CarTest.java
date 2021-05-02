package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Cars cars;

    @BeforeEach
    public void setup() {
        cars = new Cars(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    public void carNameTest() {
        Car car = new Car("name");
        assertThat(car.name()).isEqualTo("name");
        car = new Car("한글이름은");
        assertThat(car.name()).isEqualTo("한글이름은");
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
        assertThat(car.movingWithNumber(3)).isEqualTo(previousLocation);
        assertThat(car.movingWithNumber(4)).isEqualTo(previousLocation + 1);
    }

    @DisplayName("차의 현재상태(이름 + 위치)를 나타낼 문자열 만드는 기능 테스트")
    @Test
    public void makeStatusStringTest() {
        Car car = new Car("car1");
        assertThat(car.makeStatusString()).isEqualTo("car1 : -");
        car.movingWithNumber(4);
        car.movingWithNumber(4);
        assertThat(car.makeStatusString()).isEqualTo("car1 : ---");
    }

    @Test
    public void getChampionsTest() {
        cars.get("car1").moveForward();
        cars.get("car1").moveForward();
        cars.get("car2").moveForward();
        cars.get("car3").moveForward();
        cars.get("car3").moveForward();

        List<String> champNames = cars.getChampions().names();
        assertThat(champNames).containsExactly("car1", "car3");
    }

    @DisplayName("0~ 9 사이의 랜덤수를 만든다.")
    @Test
    public void 전진조건을_결정하는_랜덤수_유효성_Test() {
        int i = 0;
        while (i++ < 50) {
            int number = cars.makeRandomIntRangeZeroToNine();
            assertThat(number).isGreaterThanOrEqualTo(0);
            assertThat(number).isLessThanOrEqualTo(9);
        }
    }
}
