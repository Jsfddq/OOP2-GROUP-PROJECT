package ArcadeGameHub.member2_system;

import ArcadeGameHub.member1_core.Player;
import ArcadeGameHub.member3_minigames.GuessGame;
import ArcadeGameHub.member3_minigames.MemoryMatch;
import ArcadeGameHub.member3_minigames.Minefield;
import ArcadeGameHub.member3_minigames.QuizGame;
import ArcadeGameHub.member3_minigames.RPSGame;
import ArcadeGameHub.member3_minigames.TicTacToe;
import ArcadeGameHub.member4_output.Display;

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
            int choice = inputHandler.getIntInputInRange("Enter your choice (1-7): ", 1, 7);
            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\nCurrent Score: " + scoreManager.getScore());
        System.out.println("\n+----------------------------------------+");
        System.out.println("|            Arcade Game Hub            |");
        System.out.println("+----------------------------------------+");
        System.out.println("|  1. Guess the Number                  |");
        System.out.println("|  2. Rock Paper Scissors               |");
        System.out.println("|  3. Quiz Game                         |");
        System.out.println("|  4. Tic-Tac-Toe                       |");
        System.out.println("|  5. Memory Match                      |");
        System.out.println("|  6. Minefield                         |");
        System.out.println("|  7. Exit                              |");
        System.out.println("+----------------------------------------+");
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
                playTicTacToe();
                break;
            case 5:
                playMemoryMatch();
                break;
            case 6:
                playMinefield();
                break;
            case 7:
                exitGame();
                break;
            default:
                System.out.println("??? Invalid choice. Please try again.");
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

    private void playTicTacToe() {
        TicTacToe game = new TicTacToe(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void playMemoryMatch() {
        MemoryMatch game = new MemoryMatch(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void playMinefield() {
        Minefield game = new Minefield(inputHandler, scoreManager, display);
        game.startGame();
        askPlayAgain();
    }

    private void askPlayAgain() {
        String choice = inputHandler.getStringInput("\nPlay another game? (y/n): ");
        if (choice.equalsIgnoreCase("n")) {
            // Return to main menu
        }
    }

    private void exitGame() {
        isRunning = false;
        display.showGoodbye(player.getName(), player.getScore() + scoreManager.getScore());
    }
}
