import controller.RacingGameController;

public class MainAppRacingGame {

    public static void main(String[] args) {
        RacingGameController gameController = new RacingGameController();
        gameController.initializeRacingGame();
        gameController.startGame();
    }

}
