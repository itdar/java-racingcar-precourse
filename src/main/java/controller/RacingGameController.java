package controller;

import model.Cars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {

    private Cars cars;
    private int countTry;

    public RacingGameController() { }

    public void startGame() {
        while (countTry-- > 0) {
            System.out.println("GameCount: " + countTry);
        }
    }

    public int makeRandomIntRangeZeroToNine() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public void initCars() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼포(,) 기준으로 구분)");
            cars = new Cars(inputCarNames());
        } catch (IllegalArgumentException | IOException e) {
            initCars();
        }
    }

    private String[] inputCarNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().split(",");
    }

    public void initTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        countTry = scanner.nextInt();
    }
}
