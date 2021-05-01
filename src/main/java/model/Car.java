package model;

public class Car {

    private String name;
    private int currentLocation;

    public Car(String name) {
        if (notValid(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.currentLocation = 1;
    }

    public int movingWithFuel(int fuel) {
        if (fuel > 3) {
            return ++currentLocation;
        }
        return currentLocation;
    }

    private boolean notValid(String name) {
        return name.length() > 5 || name.length() <= 0;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }
}
