package baseball.validator;

public class CommendValidator implements Validator{
    private static CommendValidator validator = new CommendValidator();
    private CommendValidator(){

    }
    public static CommendValidator getInstanse() {
        return validator;
    }

    @Override
    public void validate(String input) {
        if(!input.matches("^[1-2]*$")){
            throw new IllegalArgumentException("1 or 2 숫자만 입력 가능합니다.");
        }
    }
}
