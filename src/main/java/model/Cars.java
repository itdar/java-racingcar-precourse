package model;

import packaging.Champions;

import java.util.*;

public class Cars {
    private Map<String, Car> cars = new LinkedHashMap<>();

    public Cars(List<String> carNames) {
        for (String name : carNames) {
            cars.put(name, new Car(name));
        }
    }

    public Cars(String[] carNames) throws IllegalArgumentException {
        this(Arrays.asList(carNames));
    }

    public void race() {
        Iterator<Car> iter = cars.values().iterator();
        while(iter.hasNext()) {
            Car car = iter.next();
            car.moveOrNotWithNumber(makeRandomIntRangeZeroToNine());
        }
    }

    public String makeStatusString() {
        StringBuilder status = new StringBuilder();

        Iterator<Car> iter = cars.values().iterator();
        while(iter.hasNext()) {
            Car car = iter.next();
            status.append(car.makeStatusString() + "\n");
        }
        return status.toString();
    }

    public int makeRandomIntRangeZeroToNine() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public Car getCar(String carName) {
        return cars.get(carName);
    }

    public boolean checkSameName(String carName) {
        return cars.get(carName) != null;
    }

    /**
     * 현 상황의 가장 멀리 나가있는 차들(챔피언들)을 반환한다.
     */
    public Champions findChampions() {
        return new Champions(findFrontCarsOn(frontLine()));
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
    private List<Car> findFrontCarsOn(int front) {
        List<Car> champCars = new ArrayList<>();

        Iterator<Car> iter = cars.values().iterator();
        while(iter.hasNext()) {
            Car car = iter.next();
            addChamp(champCars, car, isOnFrontLine(car, front));
        }
        return champCars;
    }

    private boolean isOnFrontLine(Car car, int front) {
        return car.getCurrentLocation() == front;
    }

    private void addChamp(List<Car> names, Car car, boolean isChamp) {
        if (isChamp) {
            names.add(car);
        }
    }
}
