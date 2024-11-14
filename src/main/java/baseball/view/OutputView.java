package baseball.view;

public class OutputView {

    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void printNotice(Notice notice){
        System.out.print(notice.getMessage());
    }


}
