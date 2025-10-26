package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
    }


    public void moveIfPossible(int randomValue) {
        if (randomValue >= RacingGame.MIN_MOVE_VALUE) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public boolean isAtSamePosition(int comparePosition) {
        return position == comparePosition;
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }


    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

}
