package packaging;

public class Location {

    private int location;

    public Location() {
        this.location = 0;
    }

    public int moveForward() {
        return ++location;
    }

    public int stay() {
        return location;
    }

    public int current() {
        return location;
    }

    public String statusLine() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < location; ++i) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
