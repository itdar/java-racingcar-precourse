import controller.RacingGameController;

public class MainAppRacingGame {

    public static void main(String[] args) {
        RacingGameController gameController = new RacingGameController();
        gameController.initCars();
        gameController.initTryCount();
        System.out.println("\n실행 결과");
        gameController.startGame();
    }

}
