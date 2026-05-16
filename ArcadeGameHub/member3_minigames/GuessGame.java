package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class GuessGame extends Game {

    static final String NEON_CYAN   = "\u001B[38;5;51m";  
    static final String RESET       = "\u001B[0m";

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

        while (playing) { 
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean won = false;
            
            System.out.print(NEON_CYAN);
            
            typeText("I'm thinking of a number between 1 and 100...", 25);
            System.out.print(RESET);
                
            while (!won) {
                System.out.print(NEON_CYAN);
                guess = inputHandler.getIntInputInRangeWithExit("\nEnter your guess (1-100): ", 1, 100);
                System.out.print(RESET);
                attempts++;

                if (guess == numberToGuess) {
                    System.out.print(NEON_CYAN);
                    typeText("[SUCCESS] Congratulations! You guessed it in " + attempts + " attempts!", 25);
                    System.out.print(RESET);
                    scoreManager.addPoints(10);
                    won = true;
                } else if (guess < numberToGuess) {
                    System.out.print(NEON_CYAN);
                    typeText("[TOO LOW] Try again!", 20);
                    System.out.print(RESET);
                } else {
                    System.out.print(NEON_CYAN);
                    typeText("[TOO HIGH] Try again!", 20);
                    System.out.print(RESET);
                }
            }
            
            String again = inputHandler.getStringInputWithExit("\nPlay another round? (y/n): ");
            if (again.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
    }

    @Override
    public void showInstructions() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_CYAN + "▄██      ▄████  ▄▄ ▄▄ ▄▄▄▄▄  ▄▄▄▄  ▄▄▄▄   ██████ ▄▄ ▄▄ ▄▄▄▄▄   ███  ██ ▄▄ ▄▄ ▄▄   ▄▄ ▄▄▄▄  ▄▄▄▄▄ ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_CYAN + " ██     ██  ▄▄▄ ██ ██ ██▄▄  ███▄▄ ███▄▄     ██   ██▄██ ██▄▄    ██ ▀▄██ ██ ██ ██▀▄▀██ ██▄██ ██▄▄  ██▄█▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_CYAN + " ██ ▄    ▀███▀  ▀███▀ ██▄▄▄ ▄▄██▀ ▄▄██▀     ██   ██ ██ ██▄▄▄   ██   ██ ▀███▀ ██   ██ ██▄█▀ ██▄▄▄ ██ ██" + RESET);
            Thread.sleep(400);
            System.out.println();
            
            System.out.print(NEON_CYAN);
            typeText("\nWELCOME TO THE GUESS THE NUMBER GAME!", 30);
            typeText("Think fast and try to crack the hidden number before you run out of chances.", 25);
            System.out.print(RESET);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print(NEON_CYAN);
        typeText("\n============= GUESS THE NUMBER MECHANICS & RULES =============", 15);
        System.out.print(RESET);
        
        typeText("\n1. A secret number between 1 and 100 has been chosen!", 20);
        typeText("2. Your goal is to guess the correct number.", 20);
        typeText("3. After every guess, you'll get a hint:", 20);
        typeText("4. Too High  -> Your guess is bigger than the number", 20);
        typeText("5. Too Low   -> Your guess is smaller than the number", 20);
        typeText("6. Guess the correct number to earn 10 points!", 20);
        
        System.out.print(NEON_CYAN);
        typeText("\n================================================================", 15);
        typeText("\nAnswer using numbers from 1-100", 20);
        System.out.print(RESET);
    }

    @Override
    public void endGame() {
        System.out.print(NEON_CYAN);
        typeText("\nThanks for playing Guess the Number!", 30);
        System.out.print(RESET);
    }
}