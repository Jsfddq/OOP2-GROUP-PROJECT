package member3_minigames;

import java.util.Random;
import member1_core.Game;
import member2_system.InputHandler;
import member2_system.ScoreManager;
import member4_output.Display;

public class RPSGame extends Game {
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
            System.out.println("\n🎮 ROUND " + round + " 🎮");
            
            // Get player choice
            System.out.println("Choose:");
            System.out.println("0 - Rock");
            System.out.println("1 - Paper");
            System.out.println("2 - Scissors");
            int playerChoice = inputHandler.getIntInputInRange("Your choice (0-2): ", 0, 2);
            
            // Get computer choice
            int computerChoice = random.nextInt(3);
            
            // Display choices
            System.out.println("You chose: " + options[playerChoice]);
            System.out.println("Computer chose: " + options[computerChoice]);
            
            // Determine winner
            if (playerChoice == computerChoice) {
                System.out.println("🤝 It's a tie!");
            } else if ((playerChoice == 0 && computerChoice == 2) ||
                       (playerChoice == 1 && computerChoice == 0) ||
                       (playerChoice == 2 && computerChoice == 1)) {
                System.out.println("🎉 You win this round!");
                playerWins++;
                scoreManager.addPoints(5);
            } else {
                System.out.println("💻 Computer wins this round!");
                computerWins++;
            }
            
            // Show score
            System.out.println("\n📊 Score: You " + playerWins + " - " + computerWins + " Computer");
            
            // Ask to play another round
            String again = inputHandler.getStringInput("Play another round? (y/n): ");
            if (again.equalsIgnoreCase("n")) {
                playing = false;
                if (playerWins > computerWins) {
                    System.out.println("🏆 You won the match! Great job!");
                } else if (computerWins > playerWins) {
                    System.out.println("💻 Computer won the match! Better luck next time!");
                } else {
                    System.out.println("🤝 The match is a tie!");
                }
            }
            round++;
        }
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== ROCK PAPER SCISSORS INSTRUCTIONS ===");
        System.out.println("• Choose: Rock (0), Paper (1), or Scissors (2)");
        System.out.println("• Rules:");
        System.out.println("  • Rock beats Scissors");
        System.out.println("  • Paper beats Rock");
        System.out.println("  • Scissors beats Paper");
        System.out.println("• Win a round to earn 5 points!");
        System.out.println("========================================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Rock Paper Scissors!");
    }
}