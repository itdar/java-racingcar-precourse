package packaging;

public class Name {
    private String name;

    public Name(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private boolean isValidName(String name) {
        return name.length() <= 5 && name.length() > 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
