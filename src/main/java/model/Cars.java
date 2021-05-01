package model;

import java.util.HashMap;
import java.util.Map;

public class Cars {
    private Map<String, Car> cars = new HashMap<>();

    public Cars() { }

    public Cars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        cars.put(car.getName(), car);
    }

    public void remove(Car car) {
        cars.remove(car);
    }

    public boolean checkSameName(String carName) {
        return cars.get(carName) != null;
    }

}
