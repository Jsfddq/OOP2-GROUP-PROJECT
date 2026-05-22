package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member2_system.TwoPlayerGame;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class RPSGame extends Game implements TwoPlayerGame {
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;
    private String[] options;
    
    // TwoPlayerGame variables
    private String player2Name;
    private boolean player2Turn;
    private String currentPlayer;

    private static final String NEON_LIME = "\u001B[38;5;118m"; 
    private static final String RESET = "\u001B[0m";

    public RPSGame(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Rock Paper Scissors");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
        this.options = new String[]{"Rock", "Paper", "Scissors"};
        this.player2Name = null;
        this.player2Turn = false;
        this.currentPlayer = "Player 1";
    }

    private void clearScreen() {
        // Clear console screen (works in most terminals)
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    @Override
    public void play() {
        System.out.println(NEON_LIME + "\nChoose game mode:" + RESET);
        System.out.println("1. vs Computer (Single Player)");
        System.out.println("2. Two Player");
        System.out.println("0. Exit to main menu");
        
        int mode = inputHandler.getIntInputInRange("Enter choice (0-2): ", 0, 2);
        
        if (mode == 0) {
            System.out.println("Exiting to main menu...");
            return;
        } else if (mode == 1) {
            playSinglePlayer();
        } else {
            playTwoPlayer();
        }
    }

    private void playSinglePlayer() {
        boolean playing = true;
        int round = 1;
        int playerWins = 0;
        int computerWins = 0;

        while (playing) {
            System.out.println(NEON_LIME + "\nROUND " + round + " - Make your move!" + RESET);
            
            System.out.println("Choose:");
            System.out.println("0 - Rock");
            System.out.println("1 - Paper");
            System.out.println("2 - Scissors");
            System.out.println("3 - Exit to main menu");
            
            int playerChoice = inputHandler.getIntInputInRange("Your choice (0-3): ", 0, 3);
            
            if (playerChoice == 3) {
                System.out.println("Exiting to main menu...");
                return;
            }
            
            int computerChoice = random.nextInt(3);
            
            System.out.println("You chose: " + options[playerChoice]);
            System.out.println("Computer chose: " + options[computerChoice]);
            
            if (playerChoice == computerChoice) {
                System.out.println("It's a tie!");
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.println("You win this round!");
                playerWins++;
                scoreManager.addPoints(5);
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }
            
            System.out.println("\nScore: You " + playerWins + " - " + computerWins + " Computer");
            
            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInput("Play another round? (y/n): ");
                    if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid input! Please enter 'y' or 'n'.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            if (again.equalsIgnoreCase("n")) {
                playing = false;
                if (playerWins > computerWins) {
                    System.out.println("You won the match! Great job!");
                    scoreManager.addPoints(10);
                } else if (computerWins > playerWins) {
                    System.out.println("Computer won the match! Better luck next time!");
                } else {
                    System.out.println("The match is a tie!");
                }
            }
            round++;
        }
    }

    private void playTwoPlayer() {
        System.out.print("Enter Player 1 name: ");
        String player1Name = inputHandler.getStringInput("");
        System.out.print("Enter Player 2 name: ");
        String p2Name = inputHandler.getStringInput("");
        setPlayer2(p2Name);
        
        boolean playing = true;
        int round = 1;
        int player1Wins = 0;
        int player2Wins = 0;
        currentPlayer = player1Name;
        player2Turn = false;

        while (playing) {
            // Player 1's turn - hidden from Player 2
            System.out.println(NEON_LIME + "\n" + currentPlayer + ", make your move!" + RESET);
            System.out.println("Choose:");
            System.out.println("0 - Rock");
            System.out.println("1 - Paper");
            System.out.println("2 - Scissors");
            System.out.println("3 - Exit to main menu");
            
            int choice1 = inputHandler.getIntInputInRange("Your choice (0-3): ", 0, 3);
            
            if (choice1 == 3) {
                System.out.println("Exiting to main menu...");
                return;
            }
            
            // Clear screen to hide Player 1's choice from Player 2
            clearScreen();
            
            // Switch to Player 2
            switchTurn();
            currentPlayer = getCurrentPlayer();
            
            // Player 2's turn
            System.out.println(NEON_LIME + "\n" + currentPlayer + ", make your move!" + RESET);
            System.out.println("Choose:");
            System.out.println("0 - Rock");
            System.out.println("1 - Paper");
            System.out.println("2 - Scissors");
            System.out.println("3 - Exit to main menu");
            
            int choice2 = inputHandler.getIntInputInRange("Your choice (0-3): ", 0, 3);
            
            if (choice2 == 3) {
                System.out.println("Exiting to main menu...");
                return;
            }
            
            clearScreen();
            
            // Reveal both choices
            System.out.println(NEON_LIME + "\n=== RESULTS ===" + RESET);
            System.out.println(player1Name + " chose: " + options[choice1]);
            System.out.println(p2Name + " chose: " + options[choice2]);
            
            // Determine winner
            if (choice1 == choice2) {
                System.out.println("It's a tie!");
            } else if ((choice1 == 0 && choice2 == 2) ||
                       (choice1 == 1 && choice2 == 0) ||
                       (choice1 == 2 && choice2 == 1)) {
                System.out.println(player1Name + " wins this round!");
                player1Wins++;
                scoreManager.addPoints(5);
            } else {
                System.out.println(p2Name + " wins this round!");
                player2Wins++;
            }
            
            System.out.println("\nScore: " + player1Name + " " + player1Wins + " - " + player2Wins + " " + p2Name);
            
            // Switch back for next round
            switchTurn();
            currentPlayer = getCurrentPlayer();
            
            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInput("\nPlay another round? (y/n): ");
                    if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid input! Please enter 'y' or 'n'.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                }
            }

            if (again.equalsIgnoreCase("n")) {
                playing = false;
                System.out.println(NEON_LIME + "\n=== MATCH RESULT ===" + RESET);
                if (player1Wins > player2Wins) {
                    System.out.println(player1Name + " wins the match! Great job!");
                    scoreManager.addPoints(10);
                } else if (player2Wins > player1Wins) {
                    System.out.println(p2Name + " wins the match! Great job!");
                } else {
                    System.out.println("The match is a tie!");
                }
            }
            round++;
        }
    }

    @Override
    public void showInstructions() {
        System.out.println(NEON_LIME + "\n=== ROCK PAPER SCISSORS INSTRUCTIONS ===" + RESET);
        System.out.println("Choose: Rock (0), Paper (1), or Scissors (2)");
        System.out.println("\nRules:");
        System.out.println("? Rock beats Scissors");
        System.out.println("? Paper beats Rock");
        System.out.println("? Scissors beats Paper");
        System.out.println("\nModes:");
        System.out.println("? Single Player: vs Computer");
        System.out.println("? Two Player: Play with a friend!");
        System.out.println("\nWin a round to earn 5 points!");
        System.out.println("Win the match to earn 10 bonus points!");
        System.out.println("Type 3 at any time to exit to main menu");
        System.out.println(NEON_LIME + "========================================\n" + RESET);
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Rock Paper Scissors!");
    }

    // TwoPlayerGame Interface Methods
    @Override
    public void setPlayer2(String name) {
        this.player2Name = name;
    }

    @Override
    public String getPlayer2() {
        return player2Name;
    }

    @Override
    public void switchTurn() {
        player2Turn = !player2Turn;
    }

    @Override
    public String getCurrentPlayer() {
        return player2Turn ? player2Name : "Player 1";
    }

    @Override
    public boolean isPlayer2Turn() {
        return player2Turn;
    }
}
