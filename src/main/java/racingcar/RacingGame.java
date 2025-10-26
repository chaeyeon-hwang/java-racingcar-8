package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class RacingGame {
    public static final int MIN_MOVE_VALUE = 4;
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    public void start(){
        List<Car> cars = prepareCars();
        int attemptCount = InputView.inputAttemptCount();

        OutputView.printExecutionStart();
        race(cars, attemptCount);
        announceWinners(cars);
    }

    private List<Car> createCars(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<Car> prepareCars(){
        List<String> names = InputView.inputCarNames();
        return createCars(names);
    }
    private void moveCars(List<Car> cars){
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_START, RANDOM_END);
            car.moveIfPossible(randomValue);
        }
    }

    private void race(List<Car> cars, int attemptCount){
        for (int i = 0; i < attemptCount; i++) {
            moveCars(cars);
            OutputView.printRoundResult(cars);
            System.out.println();
        }
    }

    private int getMaxPosition(List<Car> cars){
        int max = 0;
        for (Car car : cars) {
            if (car.position() > max) {
                max = car.position();
            }
        }
        return max;
    }

    private List<String> extractWinners(List<Car> cars, int maxPosition){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAtSamePosition(maxPosition)) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    private List<String> findWinners(List<Car> cars){
        int maxPosition = getMaxPosition(cars);
        return extractWinners(cars, maxPosition);
    }

    private void announceWinners(List<Car> cars){
        List<String> winners = findWinners(cars);
        OutputView.printWinners(winners);
    }
}
