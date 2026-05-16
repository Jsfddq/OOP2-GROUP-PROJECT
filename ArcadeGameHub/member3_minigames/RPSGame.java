package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class RPSGame extends Game {

    static final String NEON_LIME   = "\u001B[38;5;118m";  
    static final String RESET       = "\u001B[0m";

    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;
    private String[] options;

    public RPSGame(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Rock Paper Scissors");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
        this.options = new String[]{"Rock", "Paper", "Scissors"};
    }

    @Override
    public void play() {
        boolean playing = true;
        int round = 1;
        int playerWins = 0;
        int computerWins = 0;

        while (playing) {
            System.out.print(NEON_LIME);
            typeText("\n========== ROCK PAPER SCISSORS - ROUND " + round + " ==========", 15);
            System.out.print(RESET);
            System.out.println();
            
            System.out.print(NEON_LIME);
            typeText("Choose your move:", 20);
            System.out.print(RESET);
            typeText("0 - Rock", 15);
            typeText("1 - Paper", 15);
            typeText("2 - Scissors", 15);
            System.out.println();
            
            System.out.print(NEON_LIME);
            int playerChoice = inputHandler.getIntInputInRangeWithExit("Your choice (0-2): ", 0, 2);
            System.out.print(RESET);
            
            int computerChoice = random.nextInt(3);
            System.out.println();
            
            typeText("You chose: " + options[playerChoice], 20);
            typeText("Computer chose: " + options[computerChoice], 20);
            System.out.println();
            
            if (playerChoice == computerChoice) {
                System.out.print(NEON_LIME);
                typeText("==== IT'S A TIE! ====", 20);
                System.out.print(RESET);
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.print(NEON_LIME);
                typeText("==== YOU WIN THIS ROUND! ====", 20);
                System.out.print(RESET);
                playerWins++;
                scoreManager.addPoints(5);
            } else {
                System.out.print(NEON_LIME);
                typeText("==== COMPUTER WINS THIS ROUND! ====", 20);
                System.out.print(RESET);
                computerWins++;
            }
            
            System.out.print(NEON_LIME);
            typeText("\n==== Score: You " + playerWins + " - " + computerWins + " Computer ====", 15);
            System.out.print(RESET);
            
            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInputWithExit("\nPlay another round? (y/n): ");
                    if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                        validChoice = true;
                    } else {
                        typeText("\nInvalid input! Please enter 'y' for Yes or 'n' for No.", 20);
                    }
                } catch (Exception e) {
                    typeText("\nAn error occurred reading your choice. Please try again.", 20);
                }
            }

            if (again.equalsIgnoreCase("n")) {
                playing = false;
                System.out.println();
                if (playerWins > computerWins) {
                    System.out.print(NEON_LIME);
                    typeText("==== YOU WON THE MATCH! GREAT JOB! ====", 25);
                    System.out.print(RESET);
                } else if (computerWins > playerWins) {
                    System.out.print(NEON_LIME);
                    typeText("==== COMPUTER WON THE MATCH! BETTER LUCK NEXT TIME! ====", 25);
                    System.out.print(RESET);
                } else {
                    System.out.print(NEON_LIME);
                    typeText("==== THE MATCH IS A TIE! ====", 25);
                    System.out.print(RESET);
                }
            }
            round++;
        }
    }

    @Override
    public void showInstructions() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_LIME + "████▄     █████▄   ▄▄▄   ▄▄▄▄ ▄▄ ▄▄   █████▄   ▄▄▄  ▄▄▄▄  ▄▄▄▄▄ ▄▄▄▄    ▄█████  ▄▄▄▄ ▄▄  ▄▄▄▄  ▄▄▄▄  ▄▄▄  ▄▄▄▄   ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_LIME + " ▄██▀     ██▄▄██▄ ██▀██ ██▀▀▀ ██▄█▀    ██▄▄█▀ ██▀██ ██▄█▀ ██▄▄  ██▄█▄   ▀▀▀▄▄▄ ██▀▀▀ ██ ███▄▄ ███▄▄ ██▀██ ██▄█▄ ███▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_LIME + "███▄▄ ▄   ██   ██ ▀███▀ ▀████ ██ ██    ██     ██▀██ ██    ██▄▄▄ ██ ██   █████▀ ▀████ ██ ▄▄██▀ ▄▄██▀ ▀███▀ ██ ██ ▄▄██▀" + RESET);
            Thread.sleep(400);
            System.out.println();
            
            System.out.print(NEON_LIME);
            typeText("\nWELCOME TO ROCK PAPER SCISSORS GAME!", 25);
            typeText("Challenge the computer in this quick battle of luck and strategy.", 25);
            System.out.print(RESET);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print(NEON_LIME);
        typeText("\n========== ROCK PAPER SCISSORS MECHANICS & RULES ==========", 15);
        System.out.print(RESET);
        
        typeText("\nChoose: Rock (0), Paper (1), or Scissors (2)", 20);
        typeText("Rock beats Scissors", 20);
        typeText("Paper beats Rock", 20);
        typeText("Scissors beats Paper", 20);
        typeText("Win a round to earn 5 points!", 20);
        
        System.out.print(NEON_LIME);
        typeText("============================================================", 15);
        System.out.print(RESET);
    }

    @Override
    public void endGame() {
        System.out.print(NEON_LIME);
        typeText("\nThanks for playing Rock Paper Scissors!", 30);
        System.out.print(RESET);
    }
}