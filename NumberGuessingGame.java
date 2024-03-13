import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        int maxAttempts = 10;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between " + lowerBound + " and " + upperBound +
                ". Try to guess it within " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            if (playerGuess < lowerBound || playerGuess > upperBound) {
                System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                continue;
            }

            attempts++;

            if (playerGuess == randomNumber) {
                hasGuessedCorrectly = true;
                break;
            } else if (playerGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the correct number " + randomNumber +
                    " in " + attempts + " attempts.");
        } else {
            System.out.println("Sorry! You've run out of attempts. The correct number was " + randomNumber + ".");
        }

        scanner.close();
    }
}
