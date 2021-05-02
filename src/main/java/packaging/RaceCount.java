package packaging;

public class RaceCount {
    private int raceCount = 1;

    public RaceCount(int count) {
        this.raceCount = count;
    }

    public boolean hasNextRound() {
        return raceCount-- > 0;
    }

    @Override
    public String toString() {
        return Integer.toString(raceCount);
    }
}
