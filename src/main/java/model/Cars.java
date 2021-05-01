package model;

import java.util.*;

public class Cars {
    private Map<String, Car> cars = new LinkedHashMap<>();

    public Cars(List<String> carNames) {
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    public Cars(String[] carNames) {
        this(Arrays.asList(carNames));
    }

    public void add(Car car) {
        cars.put(car.getName(), car);
    }

    public Car get(String carName) {
        return cars.get(carName);
    }

    public boolean checkSameName(String carName) {
        return cars.get(carName) != null;
    }

    public List<String> getChampions() {
        return findNamesOn(frontLine());
    }

    /**
     * 가장 멀리간 차들의 위치를 찾는다.
     */
    private int frontLine() {
        int front = 0;
        Iterator<Car> iter = cars.values().iterator();
        while(iter.hasNext()) {
            front = checkFront(front, iter.next().getCurrentLocation());
        }
        return front;
    }

    private int checkFront(int front, int carLocation) {
        if (front < carLocation) {
            return carLocation;
        }
        return front;
    }

    /**
     * 가장 멀리간 위치에 있는 차들의 이름을 찾는다.
     */
    private List<String> findNamesOn(int front) {
        List<String> names = new ArrayList<>();

        Iterator<Car> iter = cars.values().iterator();
        while(iter.hasNext()) {
            Car car = iter.next();
            addChamp(names, car, isOnFrontLine(car, front));
        }
        return names;
    }

    private boolean isOnFrontLine(Car car, int front) {
        return car.getCurrentLocation() == front;
    }

    private void addChamp(List<String> names, Car car, boolean isChamp) {
        if (isChamp) {
            names.add(car.getName());
        }
    }
}
