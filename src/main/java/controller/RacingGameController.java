package controller;

import java.util.Random;

public class RacingGameController {

    public RacingGameController() { }

    public int makeRandomIntRangeZeroToNine() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
