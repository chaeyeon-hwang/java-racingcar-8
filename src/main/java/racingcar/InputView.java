package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_NAME_MESSAGE = "자동차 이름을 입력해야 합니다.";
    private static final String INVALID_COUNT_MESSAGE = "시도 횟수는 숫자여야 합니다.";
    private static final String NON_POSITIVE_COUNT_MESSAGE = "시도 횟수는 1회 이상이어야 합니다.";

    private InputView() {

    }

    public static List<String> inputCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String input = Console.readLine();
        validateCarNames(input);
        return parseCarNames(input);
    }

    public static int inputAttemptCount() {
        System.out.println(COUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        return parseAttemptCount(input);
    }

    private static void validateCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
    }

    private static List<String> parseCarNames(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            carNames.add(name.trim());
        }

        return carNames;
    }

    private static int parseAttemptCount(String input) {
        int count = convertToInt(input);
        validatePositiveCount(count);
        return count;
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE);
        }
    }

    private static void validatePositiveCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_COUNT_MESSAGE);
        }
    }
}
