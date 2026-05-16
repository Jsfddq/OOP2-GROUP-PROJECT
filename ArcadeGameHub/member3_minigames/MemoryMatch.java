package ArcadeGameHub.member3_minigames;

import java.util.Random;
import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;

public class MemoryMatch extends Game {
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
        System.out.println("\n???? Welcome to Memory Match!");
        initializeBoard();
        
        while (pairsFound < totalPairs) {
            printBoard();
            
            int firstCard = inputHandler.getIntInputInRangeWithExit("\nSelect first card (1-16): ", 1, 16) - 1;
            
            if (revealed[firstCard]) {
                System.out.println("??? Card already revealed!");
                continue;
            }
            
            revealed[firstCard] = true;
            printBoard();
            
            int secondCard = inputHandler.getIntInputInRangeWithExit("\nSelect second card (1-16): ", 1, 16) - 1;
            
            if (secondCard == firstCard) {
                System.out.println("??? Can't choose the same card!");
                revealed[firstCard] = false;
                continue;
            }
            
            if (revealed[secondCard]) {
                System.out.println("??? Card already revealed!");
                revealed[firstCard] = false;
                continue;
            }
            
            revealed[secondCard] = true;
            printBoard();
            moves++;
            
            if (board[firstCard].equals(board[secondCard])) {
                System.out.println("\n??? MATCH! +5 points ???");
                pairsFound++;
                scoreManager.addPoints(5);
            } else {
                System.out.println("\n??? No match! ???");
                revealed[firstCard] = false;
                revealed[secondCard] = false;
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("\nPairs found: " + pairsFound + "/" + totalPairs);
            System.out.println("Moves made: " + moves);
        }
        
        printBoard();
        System.out.println("\n???? CONGRATULATIONS! You found all " + totalPairs + " pairs! ????");
        System.out.println("Total moves: " + moves);
        
        int bonus = Math.max(0, 30 - moves);
        if (bonus > 0) {
            System.out.println("Bonus points for efficiency: +" + bonus);
            scoreManager.addPoints(bonus);
        }
        
        endGame();
    }
    
    private void printBoard() {
        System.out.println("\n+-------------------+");
        System.out.println("|   MEMORY MATCH    |");
        System.out.println("+-------------------+");
        
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                if (revealed[index]) {
                    System.out.print(" " + board[index] + "  ");
                } else {
                    System.out.printf(" %2d ", index + 1);
                }
            }
            System.out.println(" |");
        }
        System.out.println("+-------------------+");
        System.out.println("Numbers = Hidden | Letters = Revealed");
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== MEMORY MATCH INSTRUCTIONS ===");
        System.out.println("??? The board has 8 pairs of letters (A-H)");
        System.out.println("??? Reveal two cards per turn by entering their numbers (1-16)");
        System.out.println("??? If they match, they stay revealed (+5 points)");
        System.out.println("??? If they don't match, they flip back");
        System.out.println("??? Find all 8 pairs to win!");
        System.out.println("??? Fewer moves = bonus points!");
        System.out.println("==================================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Memory Match!\n");
    }
}
