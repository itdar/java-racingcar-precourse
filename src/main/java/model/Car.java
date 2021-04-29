package model;

public class Car {

    private String name;

    public Car(String name) {
        if (notValid(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean notValid(String name) {
        return name.length() > 5 || name.length() <= 0;
    }

    public String getName() {
        return this.name;
    }
}
