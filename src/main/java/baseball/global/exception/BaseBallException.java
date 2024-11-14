package baseball.global.exception;

public class BaseBallException extends IllegalArgumentException{

    private BaseBallException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }

    public static BaseBallException of(ErrorMessage errorMessage){
        return new BaseBallException(errorMessage);
    }
}
