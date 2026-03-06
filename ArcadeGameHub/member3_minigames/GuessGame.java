package member3_minigames;

import java.util.Random;
import member1_core.Game;
import member2_system.InputHandler;
import member2_system.ScoreManager;
import member4_output.Display;

public class GuessGame extends Game {
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;

    public GuessGame(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Guess the Number");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
    }

    @Override
    public void play() {
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        boolean won = false;

        System.out.println("\n🎲 I'm thinking of a number between 1 and 100...");

        while (!won) {
            guess = inputHandler.getIntInputInRange("Enter your guess (1-100): ", 1, 100);
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts!");
                scoreManager.addPoints(10);
                won = true;
            } else if (guess < numberToGuess) {
                System.out.println("📈 Too low! Try again.");
            } else {
                System.out.println("📉 Too high! Try again.");
            }
        }
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== GUESS THE NUMBER INSTRUCTIONS ===");
        System.out.println("• I'll pick a random number between 1-100");
        System.out.println("• Enter your guess");
        System.out.println("• I'll tell you if it's too high or too low");
        System.out.println("• Guess correctly to earn 10 points!");
        System.out.println("=====================================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Guess the Number!");
    }
}