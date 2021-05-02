package model;

import packaging.Name;
import packaging.Location;

public class Car {

    private Name name;
    private Location location;

    public Car(String name) throws IllegalArgumentException {
        this.name = new Name(name);
        this.location = new Location();
    }

    public int movingWithNumber(int fuel) {
        if (fuel > 3) {
            return location.moveForward();
        }
        return location.stay();
    }

    public int moveForward() {
        return location.moveForward();
    }

    public String makeStatusString() {
        return name + " : " + location.statusLine();
    }

    public String name() {
        return name.toString();
    }

    public int getCurrentLocation() {
        return location.current();
    }
}
