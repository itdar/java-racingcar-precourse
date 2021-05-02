package controller;

import model.Cars;
import packaging.Champions;
import packaging.RaceCount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RacingGameController {

    private Cars cars;
    private RaceCount raceCount;

    public RacingGameController() { }

    public void startGame() {
        printRacingStart();
        while (raceCount.hasNextRound()) {
            cars.race();
            printProgress();
        }
        printResult(cars.getChampions());
    }

    private void printRacingStart() {
        System.out.println("\n실행 결과");
    }

    private void printProgress() {
        System.out.println(cars.makeStatusString());
    }

    private void printResult(Champions champions) {
        System.out.println(champions.namesWithComma() + "(이)가 최종 우승 했습니다.");
    }

    public void initializeRacingGame() {
        initCars();
        initTryCount();
    }

    private void initCars() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼포(,) 기준으로 구분)");
            cars = new Cars(inputCarNames());
        } catch (IllegalArgumentException | IOException e) {
            initCars(); // retry, or exit game
        }
    }

    private String[] inputCarNames() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine().split(",");
    }

    private void initTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        raceCount = new RaceCount(scanner.nextInt());
    }
}
