package baseball.validator;

import java.util.Arrays;

import static baseball.global.exception.ErrorMessage.*;

public class NumbersValidator implements Validator {
    private final int INPUT_DIGIT = 3;
    private final int MIN_RANGE_NUM = 1;
    private final int MAX_RANGE_NUM = 9;

    private static NumbersValidator validator = new NumbersValidator();

    private NumbersValidator() {

    }

    public static NumbersValidator getInstance() {
        return validator;
    }

    @Override
    public void validate(String input) {
        validateDigit(input);
        validateRange(input);
        validateNonNumeric(input);
        validateDuplicateNumber(input);
    }

    private void validateNonNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(String.valueOf(NON_NUMERIC_ERROR_MESSAGE));
        }

    }

    private void validateDigit(String input) {
        if (input.length() != INPUT_DIGIT) {
            throw new IllegalArgumentException(String.valueOf(INVALID_DIGIT_ERROR_MESSAGE));
        }
    }

    private void validateDuplicateNumber(String input) {
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATE_ERROR_MESSAGE));
        }
    }

    private void validateRange(String input) {
        String[] numbers = input.split("");
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN_RANGE_NUM || Integer.parseInt(number) > MAX_RANGE_NUM) {
                throw new IllegalArgumentException(String.valueOf(OUT_RANGE_ERROR_MESSAGE));
            }
        }
    }
}
