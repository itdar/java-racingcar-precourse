package model;

public class Car {

    private String name;
    private int currentLocation = 1;

    public Car(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int movingWithNumber(int fuel) {
        if (fuel > 3) {
            return moveForward();
        }
        return currentLocation;
    }

    public String makeStatusString() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        for (int i = 0; i < currentLocation; ++i) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    private boolean isValidName(String name) {
        return name.length() <= 5 && name.length() > 0;
    }

    private int moveForward() {
        return ++currentLocation;
    }

    public String getName() {
        return this.name;
    }

    public int getCurrentLocation() {
        return this.currentLocation;
    }
}
