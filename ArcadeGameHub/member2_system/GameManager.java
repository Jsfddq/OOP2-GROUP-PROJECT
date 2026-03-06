package member2_system;

import member1_core.Player;
import member3_minigames.GuessGame;
import member3_minigames.QuizGame;
import member3_minigames.RPSGame;
import member4_output.Display;


public class GameManager {
    private Player player;
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private boolean isRunning;

    public GameManager(Player player) {
        this.player = player;
        this.inputHandler = new InputHandler();
        this.scoreManager = new ScoreManager();
        this.display = new Display();
        this.isRunning = true;
    }

    public void start() {
        while (isRunning) {
            displayMenu();
            int choice = inputHandler.getIntInputInRange("Enter your choice (1-5): ", 1, 5);
            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            MAIN MENU                   ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. Guess the Number Game              ║");
        System.out.println("║  2. Rock Paper Scissors                ║");
        System.out.println("║  3. Quiz Game                          ║");
        System.out.println("║  4. View Current Score                 ║");
        System.out.println("║  5. Exit                               ║");
        System.out.println("╚════════════════════════════════════════╝");
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                playGuessGame();
                break;
            case 2:
                playRPSGame();
                break;
            case 3:
                playQuizGame();
                break;
            case 4:
                scoreManager.showScore();
                break;
            case 5:
                exitGame();
                break;
        }
    }

    private void playGuessGame() {
        GuessGame game = new GuessGame(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void playRPSGame() {
        RPSGame game = new RPSGame(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void playQuizGame() {
        QuizGame game = new QuizGame(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void askPlayAgain() {
        String choice = inputHandler.getStringInput("\nPlay again? (y/n): ");
        if (choice.equalsIgnoreCase("n")) {
            displayMenu();
        }
    }

    private void exitGame() {
        isRunning = false;
        display.showGoodbye(player.getName(), player.getScore() + scoreManager.getScore());
    }
}