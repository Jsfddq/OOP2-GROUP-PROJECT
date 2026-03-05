package arcade;

public class MainApp {
    
    public static void main(String[] args) {
        Display display = new Display();
        InputHandler inputHandler = new InputHandler();
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║        ARCADE GAME HUB                 ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        System.out.print("Enter your name: ");
        String playerName = inputHandler.getStringInput();
        
        Player player = new Player(playerName);
        
        display.showWelcome(player.getName());
        
        GameManager gameManager = new GameManager(player, display, inputHandler);
        gameManager.start();
    }
}