package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RacingGame {
    public static final int MIN_MOVE_VALUE = 4;
    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    public void start(){

    }

    private List<Car> createCars(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<Car> prepareCars(){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }







}
