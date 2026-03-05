import java.util.*;

class GuessGame {
    Scanner scan = new Scanner(System.in);
    Random random = new Random();
    public void guessNumber() {
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        while (true) {
            System.out.print("Enter your guess: ");
            try {
                guess = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.next();
                continue;
            }
            attempts++;
            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }
        scan.close();
    }
}
