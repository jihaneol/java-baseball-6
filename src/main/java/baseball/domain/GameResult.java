package baseball.domain;

import baseball.global.exception.BaseBallException;
import baseball.global.exception.ErrorMessage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public record GameResult(int ballCount, int strikeCount) {
    public boolean isSuccess() {
        return strikeCount == 3;
    }

    public static GameResult create(Numbers computer, Numbers player) {
        int ball = computer.countBall(player);
        int strike = computer.countStrike(player);
        Queue<Integer> q = new ArrayDeque<>();
        Deque<Integer> q1 = new ArrayDeque<>();



        return new GameResult(ball, strike);
    }


    public String getResultMessage() {
        ResultType resultType = inspectResultType();
        return convertResultTypeToString(resultType);
    }

    private String convertResultTypeToString(ResultType resultType) {
        return switch (resultType) {
            case BALL_MESSAGE -> String.format(resultType.getMessage(),ballCount);
            case STRIKE_MESSAGE -> String.format(resultType.getMessage(),strikeCount);
            case NOTHING_MESSAGE -> resultType.getMessage();
            case BALL_STRIKE_MESSAGE -> String.format(resultType.getMessage(),ballCount,strikeCount);
        };
    }

    private ResultType inspectResultType() {
        if (isNoting()) {
            return ResultType.NOTHING_MESSAGE;
        }
        if (isBallAndStrike()) {
            return ResultType.BALL_STRIKE_MESSAGE;
        }
        if (hasStrike()) {
            return ResultType.STRIKE_MESSAGE;
        }
        if (hasBall()) {
            return ResultType.BALL_MESSAGE;
        }

        throw BaseBallException.of(ErrorMessage.SYSTEM_MESSAGE);
    }

    private boolean isBallAndStrike() {
        return hasBall() && hasStrike();
    }

    private boolean isNoting() {
        return !hasBall() && !hasStrike();
    }

    private boolean hasStrike() {
        return strikeCount > 0;
    }

    private boolean hasBall() {
        return ballCount > 0;
    }


    @Override
    public String toString() {
        return "GameResult{" +
                "ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }


}
