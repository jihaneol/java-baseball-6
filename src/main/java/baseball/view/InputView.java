package baseball.view;

import baseball.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class InputView {

    public static String readNumbers(Validator v) {
        OutputView.printNotice(Notice.INPUT_MESSAGE);
        String input = readLine();
        v.validate(input);
        return input;
    }

    public static String readRestartOrEndGame(Validator v) {
        OutputView.printNotice(Notice.GAME_START_OR_END_MESSAGE);
        String input = readLine();
        v.validate(input);
        return input;
    }
}
