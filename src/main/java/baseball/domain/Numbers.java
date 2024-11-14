package baseball.domain;

import baseball.validator.NumbersValidator;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {

    private List<Integer> numbers;

    private Numbers(List<Integer> computerNumbers) {
        numbers = computerNumbers;
    }

    private Numbers(String input) {
        numbers = convertInputNumber(input);
    }

    private List<Integer> convertInputNumber(String input) {
        return Arrays.stream(input.split("")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public static Numbers createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return new Numbers(computerNumbers);
    }

    public static Numbers createPlayerNumber() {
        String input = InputView.readNumbers(NumbersValidator.getInstance());
        return new Numbers(input);
    }

    public int countBall(Numbers comparableNumber) {
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> comparableNumber.isBall(numbers.get(i), i))
                .count();
    }

    private boolean isBall(int num, int digit) {
        return !isStrike(num, digit) && numbers.contains(num);
    }

    public int countStrike(Numbers comparableNumber) {
        return (int) IntStream.range(0,numbers.size())
                .filter(i -> comparableNumber.isStrike(numbers.get(i),i))
                .count();
    }

    private boolean isStrike(int num, int i) {
        return numbers.get(i) == num;
    }
}
