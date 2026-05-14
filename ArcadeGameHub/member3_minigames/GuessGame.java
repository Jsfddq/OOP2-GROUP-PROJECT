package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

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
        int guess;
        boolean playing = true;

        while(playing){ // changed this
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;
            System.out.println("\n[GUESS THE NUMBER]");
            System.out.println("I'm thinking of a number between 1 and 100...");
                
            while (!won) {
            guess = inputHandler.getIntInputInRange("Enter your guess (1-100): ", 1, 100);
            attempts++;

                if (guess == numberToGuess) {
                    System.out.println("[SUCCESS] Congratulations! You guessed it in " + attempts + " attempts!");
                    scoreManager.addPoints(10);
                    won = true;
                } else if (guess < numberToGuess) {
                    System.out.println("[TOO LOW] Try again!");
                } else {
                    System.out.println("[TOO HIGH] Try again!");
                }
            }
            String again = inputHandler.getStringInput("Play another round? (y/n): "); // added this
            if(again.equalsIgnoreCase("n")){
                playing = false;
            }
        }
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== GUESS THE NUMBER INSTRUCTIONS ===");
        System.out.println("I'll pick a random number between 1-100");
        System.out.println("Enter your guess and I'll tell you if it's too high or too low");
        System.out.println("Guess correctly to earn 10 points!");
        System.out.println("=====================================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Guess the Number!");
    }
}
