package racingcar;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String NAME_SEPARATOR = ", ";
    private static final String POSITION_MARK = "-";

    private OutputView() {

    }

    public static void printExecutionStart() {
        printLine(EXECUTION_RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printLine(formatCarProgress(car));
        }
    }

    public static void printWinners(List<String> winners) {
        String result = WINNER_MESSAGE_PREFIX + String.join(NAME_SEPARATOR, winners);
        printLine(result);
    }

    private static String formatCarProgress(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.name())
                .append(" : ")
                .append(POSITION_MARK.repeat(car.position()));
        return builder.toString();
    }

    private static void printLine(String message) {
        System.out.println(message);
    }
}
