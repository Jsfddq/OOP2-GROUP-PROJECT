package member4_output;

public class Display {
    
    public void showWelcome(String playerName) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        ARCADE GAME HUB                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Welcome, " + playerName + "!");
        System.out.println();
    }
    
    public void showGoodbye(String playerName, int finalScore) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         THANKS FOR PLAYING!            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Final Score for " + playerName + ": " + finalScore + " points");
        System.out.println("Come back soon!\n");
    }
}