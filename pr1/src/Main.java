import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static void main(String[] args) {
        Predicate predicate = email -> pattern.matcher(email).matches();

        Scanner in = new Scanner(System.in);

        System.out.println("Введите email");
        String email = in.nextLine();

        System.out.println(predicate.test(email) ?"Это email" :"Это не email");
    }
}
