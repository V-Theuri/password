import java.util.Scanner;

public class LoginProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the correct username and password
        String correctUsername = "myuser";
        String correctPassword = "mypassword";

        int attempts = 3; // Number of login attempts allowed

        while (attempts > 0) {
            System.out.println("Please enter your username:");
            String usernameInput = scanner.nextLine();

            System.out.println("Please enter your password (characters will be hidden):");
            String passwordInput = hidePasswordInput(scanner);

            // Check if the entered credentials are correct
            if (usernameInput.equals(correctUsername) && passwordInput.equals(correctPassword)) {
                System.out.println("Login successful!");
                break; // Exit the loop on successful login
            } else {
                System.out.println("Login failed. Please try again.");
                attempts--;

                if (attempts > 0) {
                    System.out.println("You have " + attempts + " attempts remaining.");
                } else {
                    System.out.println("No more attempts left. Account locked.");
                }
            }
        }

        scanner.close();
    }

    // Function to hide the password input with asterisks
    private static String hidePasswordInput(Scanner scanner) {
        String passwordInput = "";
        char passwordChar;

        while (true) {
            passwordChar = System.console().readPassword()[0]; // Read a single character securely

            if (passwordChar == '\n' || passwordChar == '\r') {
                break; // Stop on Enter key
            }

            System.out.print("*"); // Print an asterisk for each character
            passwordInput += passwordChar;
        }

        System.out.println(); // Print a newline after the password
        return passwordInput;
    }
}