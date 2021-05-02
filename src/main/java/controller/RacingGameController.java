package controller;

import model.Cars;
import packaging.RaceCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {

    private Cars cars;
    private RaceCount raceCount;

    public RacingGameController() { }

    public void startGame() {
        while (raceCount.hasNextRound()) {
            System.out.println("GameCount: " + raceCount);
        }
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
        raceCount = new RaceCount(scanner.nextInt());
    }
}
