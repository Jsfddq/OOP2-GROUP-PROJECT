package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class MemoryMatch extends Game {

    static final String NEON_PINK   = "\u001B[38;5;205m";  
    static final String RESET       = "\u001B[0m";

    private String[] board;
    private boolean[] revealed;
    private int pairsFound;
    private int totalPairs;
    private int moves;
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;

    public MemoryMatch(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Memory Match");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
        this.totalPairs = 8;
        initializeBoard();
    }
    
    private void initializeBoard() {
        board = new String[16];
        revealed = new boolean[16];
        
        String[] symbols = {"A", "B", "C", "D", "E", "F", "G", "H"};
        
        int index = 0;
        for (int i = 0; i < totalPairs; i++) {
            for (int j = 0; j < 2; j++) {
                board[index++] = symbols[i];
            }
        }
        
        // Shuffle
        for (int i = board.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = board[i];
            board[i] = board[j];
            board[j] = temp;
        }
        
        for (int i = 0; i < revealed.length; i++) {
            revealed[i] = false;
        }
        
        pairsFound = 0;
        moves = 0;
    }

    @Override
    public void play() {
        boolean playing = true;

        while (playing) {
            System.out.print(NEON_PINK);
            typeText("\nWelcome to Memory Match!", 25);
            System.out.print(RESET);
            initializeBoard();

            while (pairsFound < totalPairs) {
                printBoard();
                
                System.out.print(NEON_PINK);
                int firstCard = inputHandler.getIntInputInRangeWithExit("\nSelect first card (1-16): ", 1, 16) - 1;
                System.out.print(RESET);
                
                if (revealed[firstCard]) {
                    System.out.print(NEON_PINK);
                    typeText("Card already revealed!", 20);
                    System.out.print(RESET);
                    continue;
                }
                
                revealed[firstCard] = true;
                printBoard();
                
                System.out.print(NEON_PINK);
                int secondCard = inputHandler.getIntInputInRangeWithExit("\nSelect second card (1-16): ", 1, 16) - 1;
                System.out.print(RESET);
                
                if (secondCard == firstCard) {
                    System.out.print(NEON_PINK);
                    typeText("Can't choose the same card!", 20);
                    System.out.print(RESET);
                    revealed[firstCard] = false;
                    continue;
                }
                
                if (revealed[secondCard]) {
                    System.out.print(NEON_PINK);
                    typeText("Card already revealed!", 20);
                    System.out.print(RESET);
                    revealed[firstCard] = false;
                    continue;
                }
                
                revealed[secondCard] = true;
                printBoard();
                moves++;
                
                if (board[firstCard].equals(board[secondCard])) {
                    System.out.print(NEON_PINK);
                    typeText("\nMATCH! +5 points", 25);
                    System.out.print(RESET);
                    pairsFound++;
                    scoreManager.addPoints(5);
                } else {
                    System.out.print(NEON_PINK);
                    typeText("\nNo match!", 25);
                    System.out.print(RESET);
                    revealed[firstCard] = false;
                    revealed[secondCard] = false;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                
                typeText("\nPairs found: " + pairsFound + "/" + totalPairs, 20);
                typeText("Moves made: " + moves, 20);
            }
        
            printBoard();
            System.out.print(NEON_PINK);
            typeText("\nCONGRATULATIONS! You found all " + totalPairs + " pairs!", 25);
            System.out.print(RESET);
            typeText("Total moves: " + moves, 20);
            
            int bonus = Math.max(0, 30 - moves);
            if (bonus > 0) {
                System.out.print(NEON_PINK);
                typeText("Bonus points for efficiency: +" + bonus, 20);
                System.out.print(RESET);
                scoreManager.addPoints(bonus);
            }
            
            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInputWithExit("\nPlay another round? (y/n): ");
                    if (again.equalsIgnoreCase("n") || again.equalsIgnoreCase("y")) {
                        validChoice = true;
                    } else {
                        typeText("Invalid input! Please enter 'y' for Yes or 'n' for No", 20);
                    }
                } catch (Exception e) {
                    typeText("An error occurred reading your choice. Please try again.", 20);
                }
            }
            if (again.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
        endGame();
    }
    
    private void printBoard() {
        System.out.print(NEON_PINK);
        System.out.println("\n╔══════════════════════════╗");
        System.out.println("║      MEMO PLAY CO.       ║");
        System.out.println("╠══════════════════════════╣");
        System.out.print(RESET);
        
        for (int i = 0; i < 4; i++) {
            System.out.print(NEON_PINK + "║" + RESET);
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                if (revealed[index]) {
                    // Prints the color-coded letter inside a matching 6-character text column
                    System.out.printf(NEON_PINK + "   %s  " + RESET, board[index]);
                } else {
                    // Prints unrevealed numbers formatted directly to a clean 6-character width
                    System.out.printf("   %2d ", index + 1);
                }
            }
            System.out.println(NEON_PINK + "  ║" + RESET);
        }
        
        System.out.print(NEON_PINK);
        System.out.println("╚══════════════════════════╝");
        System.out.print(RESET);
        typeText("Numbers = Hidden | Letters = Revealed", 15);
    }

    @Override
    public void showInstructions() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_PINK + "███▀▀▀     ██▄  ▄██ ▄▄▄▄▄ ▄▄   ▄▄  ▄▄▄  ▄▄▄▄  ▄▄ ▄▄   ██▄  ▄██  ▄▄▄ ▄▄▄▄▄▄ ▄▄▄▄ ▄▄ ▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_PINK + "▀▀███▄     ██ ▀▀ ██ ██▄▄  ██▀▄▀██ ██▀██ ██▄█▄ ▀███▀   ██ ▀▀ ██ ██▀██  ██  ██▀▀▀ ██▄██" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_PINK + "▄▄▄██▀ ▄   ██    ██ ██▄▄▄ ██   ██ ▀███▀ ██ ██   █     ██    ██ ██▀██  ██  ▀████ ██ ██" + RESET);
            Thread.sleep(400);
            System.out.println();
            
            System.out.print(NEON_PINK);
            typeText("\nWELCOME TO MEMORY MATCH!", 30);
            typeText("Flip, remember, and match pairs as you test your memory skills.", 25);
            System.out.print(RESET);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print(NEON_PINK);
        typeText("\n======= MEMORY MATCH MECHANICS & RULES =======", 15);
        System.out.print(RESET);
        
        typeText("\n1. The board has 8 pairs of letters (A-H)", 20);
        typeText("2. Reveal two cards per turn by entering their numbers (1-16)", 20);
        typeText("3. If they match, they stay revealed (+5 points)", 20);
        typeText("4. If they don't match, they flip back", 20);
        typeText("5. Find all 8 pairs to win!", 20);
        typeText("6. Fewer moves = bonus points!", 20);
        
        System.out.print(NEON_PINK);
        typeText("\n==============================================", 15);
        System.out.print(RESET);
        System.out.println();
    }

    @Override
    public void endGame() {
        System.out.print(NEON_PINK);
        typeText("\nThanks for playing Memory Match!\n", 30);
        System.out.print(RESET);
    }
}