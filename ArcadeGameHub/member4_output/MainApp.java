package member4_output;

import member1_core.Player;
import member2_system.GameManager;
import member2_system.InputHandler;

public class MainApp {
    
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Display display = new Display();
        
        // Welcome screen
        display.showWelcome("Player");
        
        // Get player name
        String playerName = inputHandler.getStringInput("Enter your name: ");
        
        // Create player
        Player player = new Player(playerName);
        
        // Welcome the player
        System.out.println("\nHello, " + player.getName() + "! Let's play some games!");
        
        // Start the game manager
        GameManager gameManager = new GameManager(player);
        gameManager.start();
    }
}