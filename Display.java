package arcade;

public class Display {
    
    public void showWelcome(String playerName) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        ARCADE GAME HUB                   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Welcome, " + playerName + "!");
        System.out.println();
    }
    
    public void showMenu() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║            MAIN MENU                   ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Guess the Number Game              ║");
        System.out.println("║  2. Rock Paper Scissors                ║");
        System.out.println("║  3. Quiz Game                          ║");
        System.out.println("║  4. View Current Score                 ║");
        System.out.println("║  5. Exit                               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Enter your choice (1-5): ");
    }
    
    public void showInstructions(String gameName) {
        System.out.println("\n=== " + gameName + " ===");
        
        if (gameName.equals("Guess the Number")) {
            System.out.println("Instructions:");
            System.out.println("• I'm thinking of a number between 1 and 100");
            System.out.println("• Enter your guess");
            System.out.println("• I'll tell you if it's too high or too low");
        }
        else if (gameName.equals("Rock Paper Scissors")) {
            System.out.println("Instructions:");
            System.out.println("• Enter 0 for Rock");
            System.out.println("• Enter 1 for Paper");
            System.out.println("• Enter 2 for Scissors");
            System.out.println("Rock beats Scissors");
            System.out.println("Paper beats Rock");
            System.out.println("Scissors beats Paper");
        }
        else if (gameName.equals("Quiz Game")) {
            System.out.println("Instructions:");
            System.out.println("• Answer multiple-choice questions");
            System.out.println("• Each correct answer earns points");
            System.out.println("• Choose the option number (1-4)");
        }
        System.out.println();
    }
    
    public void showResult(Result result) {
        System.out.println("\n════════════════════════════════════════");
        System.out.println("GAME RESULT:");
        System.out.println("  Game: " + result.getGameName());
        System.out.println("  Outcome: " + result.getOutcome());
        System.out.println("  Points: +" + result.getPointsEarned());
        
        if (result.getAttempts() > 0) {
            System.out.println("  Attempts: " + result.getAttempts());
        }
        System.out.println("════════════════════════════════════════\n");
    }
    
    public void showScore(int score) {
        System.out.println("\n⭐ CURRENT SCORE: " + score + " points ⭐\n");
    }
    
    public void showGoodbye(String playerName, int finalScore) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         THANKS FOR PLAYING!              ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println("Final Score for " + playerName + ": " + finalScore + " points");
        System.out.println("Come back soon!\n");
    }
    
    public void showDivider() {
        System.out.println("----------------------------------------");
    }
    
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
    
    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }
    
    public void askPlayAgain() {
        System.out.print("Play again? (y/n): ");
    }
}