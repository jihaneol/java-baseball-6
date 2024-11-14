package baseball.controller;

import baseball.domain.GameResult;
import baseball.domain.Numbers;
import baseball.validator.CommendValidator;
import baseball.view.InputView;
import baseball.view.Notice;
import baseball.view.OutputView;

import static baseball.view.OutputView.printNotice;

public class BaseBallGame {
    private final String RESTART = "1";
    public void gameStart() {
        printNotice(Notice.GAME_START_MESSAGE);
        do{
            gamePlay(Numbers.createComputerNumbers());
        }while (restart());
        printNotice(Notice.GAME_END_MESSAGE);
    }

    private boolean restart() {

        return RESTART.equals(InputView.readRestartOrEndGame(CommendValidator.getInstanse()));
    }

    private void gamePlay(Numbers computerNumbers) {
        GameResult result;
        do {
            Numbers playerNumbers = Numbers.createPlayerNumber();
            result =GameResult.create(computerNumbers, playerNumbers);
            OutputView.printMessage(result.getResultMessage());
        }while (!result.isSuccess());
        printNotice(Notice.GAME_SUCCESS_MESSAGE);

    }

}
