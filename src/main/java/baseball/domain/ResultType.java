package baseball.domain;

public enum ResultType {

    BALL_MESSAGE("%d볼"),
    STRIKE_MESSAGE("%d스트라이크"),
    NOTHING_MESSAGE("낫싱"),
    BALL_STRIKE_MESSAGE("%d볼 %d스트라이크");

    private String message;

    ResultType(String m) {
        message = m;
    }

    @Override
    public String toString() {
        return message;
    }
    public String getMessage(){
        return message;
    }
}
