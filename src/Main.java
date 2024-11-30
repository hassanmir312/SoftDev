import ca.sheridancollege.project.WarGame;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WarGame game = new WarGame("War Card Game");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the War Card Game!");

        // Register Player 1
        String player1Name = getUsername(scanner, 1);
        game.registerPlayer(player1Name);

        // Register Player 2
        String player2Name = getUsername(scanner, 2);
        game.registerPlayer(player2Name);

        // Proceed with the game setup and play
        game.play();
        game.declareWinner();

        scanner.close();
    }

    // Method to handle username validation for each player
    private static String getUsername(Scanner scanner, int playerNumber) {
        String username = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter name for Player " + playerNumber + ": ");
            username = scanner.nextLine();

            if (isValidUsername(username)) {
                valid = true;
            } else {
                System.out.println("Error: Username must contain at least one letter, one number, and one special character. Please try again.");
            }
        }
        return username;
    }

    // Method to validate the username based on the defined rules
    private static boolean isValidUsername(String username) {
        // Regular expression to check for at least one letter, one number, and one special character
        return username.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).+$");
    }
}
