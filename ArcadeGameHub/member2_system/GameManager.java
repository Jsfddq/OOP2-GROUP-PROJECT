package ArcadeGameHub.member2_system;

import ArcadeGameHub.member1_core.Player;
import ArcadeGameHub.member3_minigames.GuessGame;
import ArcadeGameHub.member3_minigames.QuizGame;
import ArcadeGameHub.member3_minigames.RPSGame;
import ArcadeGameHub.member3_minigames.TicTacToe;
import ArcadeGameHub.member3_minigames.MemoryMatch;
import ArcadeGameHub.member3_minigames.Minefield;
import ArcadeGameHub.member4_output.Display;

public class GameManager {

    static final String RESET       = "\u001B[0m";
    static final String NEON_PURPLE = "\u001B[38;5;135m"; 
    static final String NEON_CYAN   = "\u001B[38;5;51m";  
    static final String NEON_LIME   = "\u001B[38;5;118m"; 
    static final String NEON_AMBER  = "\u001B[38;5;220m"; 
    static final String NEON_BLUE   = "\u001B[38;5;39m";  
    static final String NEON_PINK   = "\u001B[38;5;205m"; 
    static final String NEON_RED    = "\u001B[38;5;196m"; 
    static final String NEON_WHITE  = "\u001B[38;5;231m"; 

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
            int choice = inputHandler.getIntInputInRange("\nEnter your choice (1-7): ", 1, 7);
            processChoice(choice);
        }
    }

    private void displayMenu() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_CYAN + "▄██      ▄████  ▄▄ ▄▄ ▄▄▄▄▄  ▄▄▄▄  ▄▄▄▄   ██████ ▄▄ ▄▄ ▄▄▄▄▄   ███  ██ ▄▄ ▄▄ ▄▄   ▄▄ ▄▄▄▄  ▄▄▄▄▄ ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_CYAN + " ██     ██  ▄▄▄ ██ ██ ██▄▄  ███▄▄ ███▄▄     ██   ██▄██ ██▄▄    ██ ▀▄██ ██ ██ ██▀▄▀██ ██▄██ ██▄▄  ██▄█▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_CYAN + " ██ ▄    ▀███▀  ▀███▀ ██▄▄▄ ▄▄██▀ ▄▄██▀     ██   ██ ██ ██▄▄▄   ██   ██ ▀███▀ ██   ██ ██▄█▀ ██▄▄▄ ██ ██" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_CYAN + "\tThink fast and try to crack the hidden number before you run out of chances."+ RESET);
            System.out.println();

            Thread.sleep(600);
            System.out.println(NEON_LIME + "████▄     █████▄   ▄▄▄   ▄▄▄▄ ▄▄ ▄▄   █████▄  ▄▄▄  ▄▄▄▄  ▄▄▄▄▄ ▄▄▄▄    ▄█████  ▄▄▄▄ ▄▄  ▄▄▄▄  ▄▄▄▄  ▄▄▄  ▄▄▄▄   ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_LIME + " ▄██▀     ██▄▄██▄ ██▀██ ██▀▀▀ ██▄█▀    ██▄▄█▀ ██▀██ ██▄█▀ ██▄▄  ██▄█▄  ▀▀▀▄▄▄ ██▀▀▀ ██ ███▄▄ ███▄▄ ██▀██ ██▄█▄ ███▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_LIME + "███▄▄ ▄   ██   ██ ▀███▀ ▀████ ██ ██    ██     ██▀██ ██    ██▄▄▄ ██ ██  █████▀ ▀████ ██ ▄▄██▀ ▄▄██▀ ▀███▀ ██ ██ ▄▄██▀" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_LIME + "\tChallenge the computer in this quick battle of luck and strategy."+ RESET);
            System.out.println();

            Thread.sleep(600);
            System.out.println(NEON_AMBER + "████▄     ▄█████▄ ▄▄ ▄▄ ▄▄ ▄▄▄▄▄    ▄████   ▄▄▄  ▄▄   ▄▄ ▄▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_AMBER + " ▄▄██     ██ ▄ ██ ██ ██ ██   ▄█▀    ██  ▄▄▄██▀██ ██▀▄▀██ ██▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_AMBER + "▄▄▄█▀ ▄   ▀█████▀ ▀███▀ ██ ▄██▄▄    ▀███▀  ██▀██ ██   ██ ██▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_AMBER + "               ▀▀" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_AMBER + "\tTest your brain with questions and see how high you can score."+ RESET);
            System.out.println();

            Thread.sleep(600);
            System.out.println(NEON_BLUE + "██  ██     ██████ ▄▄  ▄▄▄▄   ██████ ▄▄▄   ▄▄▄▄   ██████ ▄▄▄  ▄▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_BLUE + "▀█████       ██   ██ ██▀▀▀ ▄▄▄ ██  ██▀██ ██▀▀▀ ▄▄▄ ██  ██▀██ ██▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_BLUE + "    ██ ▄     ██   ██ ▀████     ██  ██▀██ ▀████     ██  ▀███▀ ██▄▄▄" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_BLUE + "\tOutsmart your opponent and line up three marks to win the game."+ RESET);
            System.out.println();

            Thread.sleep(600);
            System.out.println(NEON_PINK + "███▀▀▀     ██▄  ▄██ ▄▄▄▄▄ ▄▄   ▄▄  ▄▄▄  ▄▄▄▄  ▄▄ ▄▄   ██▄  ▄██  ▄▄▄ ▄▄▄▄▄▄ ▄▄▄▄ ▄▄ ▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_PINK + "▀▀███▄     ██ ▀▀ ██ ██▄▄  ██▀▄▀██ ██▀██ ██▄█▄ ▀███▀   ██ ▀▀ ██ ██▀██  ██  ██▀▀▀ ██▄██" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_PINK + "▄▄▄██▀ ▄   ██    ██ ██▄▄▄ ██   ██ ▀███▀ ██ ██   █     ██    ██ ██▀██  ██  ▀████ ██ ██" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_PINK + "\tFlip, remember, and match pairs as you test your memory skills."+ RESET);
            System.out.println();

            Thread.sleep(600);
            System.out.println(NEON_RED + "▄██▀▀▀     ██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄ ▄▄▄▄▄ ▄▄ ▄▄▄▄▄ ▄▄    ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_RED + "██▄▄▄      ██ ▀▀ ██ ██ ███▄██ ██▄▄  ██▄▄  ██ ██▄▄  ██    ██▀██" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_RED + "▀█▄▄█▀ ▄   ██    ██ ██ ██ ▀██ ██▄▄▄ ██    ██ ██▄▄▄ ██▄▄▄ ████▀" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_RED + "\tCarefully navigate the grid and avoid hidden mines to survive the challenge."+ RESET);
            System.out.println();
            
            Thread.sleep(600);
            System.out.println(NEON_WHITE + "██████     ██████ ▄▄ ▄▄ ▄▄ ▄▄▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_WHITE + "  ▄██▀     ██▄▄   ▀█▄█▀ ██   ██  " + RESET);
            Thread.sleep(80);
            System.out.println(NEON_WHITE + " ██▀   ▄   ██▄▄▄▄ ██ ██ ██   ██  " + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_WHITE+ "\tLeave Game."+ RESET);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processChoice(int choice) {
        switch (choice) {
            case 1: playGuessGame();   break;
            case 2: playRPSGame();     break;
            case 3: playQuizGame();    break;
            case 4: playTicTacToe();   break;
            case 5: playMemoryMatch(); break;
            case 6: playMinefield();   break;
            case 7: exitGame();        break;
            default:
                System.out.println("Invalid choice. Please try again.");
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
            
        } else {
            displayMenu();
        }
    }

    private void exitGame() {
        isRunning = false;
        display.showGoodbye(player.getName(), player.getScore() + scoreManager.getScore());
    }
}