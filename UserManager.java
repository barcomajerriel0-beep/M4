import java.util.Scanner;

public class UserManager {

    UserRepository repository = new UserRepository();

    public void registerUser(Scanner scanner) {

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (Athlete/Coach/Administrator): ");
        String role = scanner.nextLine();

        User user = new User(username, password, role);

        repository.saveUser(user);
    }

    public User loginUser(Scanner scanner) {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = repository.login(username, password);

        if (user != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }

        return user;
    }
}
