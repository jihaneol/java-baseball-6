package baseball.global.exception;

public enum ErrorMessage {

    INVALID_DIGIT_ERROR_MESSAGE("입력 길이는 3입니다."),
    NON_NUMERIC_ERROR_MESSAGE("숫자로만 이루어진 값을 입력해주세요."),
    DUPLICATE_ERROR_MESSAGE ("중복된 숫자가 포함되어 있습니다."),
    OUT_RANGE_ERROR_MESSAGE("숫자는 1과 9 사이의 숫자입니다."),
    SYSTEM_MESSAGE("시스템 이상");
    private String message;
    ErrorMessage(String m){
        message = m;
    }

    public String getMessage() {
        return message;
    }
}
