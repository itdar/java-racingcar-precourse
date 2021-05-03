package packaging;

import model.GamePlayOptions;

public class Name {
    private String name;

    public Name(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean isValidName(String name) {
        return name.length() <= GamePlayOptions.MAXIMUM_LENGTH_OF_CAR_NAME
                && name.length() >= GamePlayOptions.MINIMUM_LENGTH_OF_CAR_NAME;
    }

    @Override
    public String toString() {
        return name;
    }
}
