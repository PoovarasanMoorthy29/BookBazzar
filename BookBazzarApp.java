import com.bookbazzar.features.Login.LoginView;
import com.bookbazzar.features.SignUp.SignUpView;
import java.util.Scanner;
public class BookBazzarApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- Welcome to Book Bazzar ---");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    new LoginView().show();
                    break;
                case "2":
                    new SignUpView().show();
                    break;
                case "3":
                    System.out.println("Thank you for using Book Bazzar.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
