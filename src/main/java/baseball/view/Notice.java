package baseball.view;

public enum Notice {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    GAME_SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    GAME_START_OR_END_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    GAME_END_MESSAGE("게임을 종료합니다.\n");
    private String message;

    Notice(String m) {
        message = m;
    }

    public String getMessage() {
        return message;
    }
}
