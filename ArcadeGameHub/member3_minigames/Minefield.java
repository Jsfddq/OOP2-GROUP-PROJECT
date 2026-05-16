package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class Minefield extends Game {
    private boolean[] mines;
    private boolean[] uncovered;
    private int gridSize;
    private int totalMines;
    private int safeTiles;
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;

    public Minefield(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Minefield");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
        this.gridSize = 5;
        this.totalMines = 5;
        this.safeTiles = (gridSize * gridSize) - totalMines;
        initializeField();
    }
    
    private void initializeField() {
        mines = new boolean[gridSize * gridSize];
        uncovered = new boolean[gridSize * gridSize];
        
        for (int i = 0; i < mines.length; i++) {
            mines[i] = false;
            uncovered[i] = false;
        }
        
        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int position = random.nextInt(mines.length);
            if (!mines[position]) {
                mines[position] = true;
                minesPlaced++;
            }
        }
    }

    @Override
    public void play() {
        System.out.println("\nWelcome to Minefield!");
        initializeField();
        String playAgain;
        int uncoveredCount = 0;
        boolean gameOver = false;
        
        while (!gameOver && uncoveredCount < safeTiles) {
            displayField();
            int position = inputHandler.getIntInputInRangeWithExit("\nSelect a tile to reveal (1-25): ", 1, 25) - 1;
            
            if (uncovered[position]) {
                System.out.println("Tile already uncovered!");
                continue;
            }
            
            if (mines[position]) {
                displayField(true);
                System.out.println("\nBOOM! You hit a mine!");
                gameOver = true;
            } else {
                uncovered[position] = true;
                uncoveredCount++;
                int nearbyMines = countNearbyMines(position);
                
                if (nearbyMines > 0) {
                    System.out.println(nearbyMines + " mine(s) nearby! +2 points");
                    scoreManager.addPoints(2);
                } else {
                    System.out.println("Safe tile! +5 points!");
                    scoreManager.addPoints(5);
                    uncoveredCount = autoUncoverSafe(position, uncoveredCount);
                }
            }
        }
        
        
        if (uncoveredCount == safeTiles && !gameOver) {
            displayField(true);
            System.out.println("\nVICTORY! You cleared all safe tiles!");
            System.out.println("Safe tiles cleared: " + uncoveredCount + "/" + safeTiles);
            scoreManager.addPoints(50);
        } else if (gameOver) {
            System.out.println("\nGAME OVER!");
            System.out.println("You cleared " + uncoveredCount + "/" + safeTiles + " safe tiles.");
        }
        endGame();
    }
    
    private int countNearbyMines(int position) {
        int row = position / gridSize;
        int col = position % gridSize;
        int count = 0;
        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int newRow = row + dr;
                int newCol = col + dc;
                if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < gridSize) {
                    int newPos = newRow * gridSize + newCol;
                    if (mines[newPos]) count++;
                }
            }
        }
        return count;
    }
    
    private int autoUncoverSafe(int position, int uncoveredCount) {
        int nearbyMines = countNearbyMines(position);
        
        if (nearbyMines == 0) {
            int row = position / gridSize;
            int col = position % gridSize;
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    int newRow = row + dr;
                    int newCol = col + dc;
                    if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < gridSize) {
                        int newPos = newRow * gridSize + newCol;
                        if (!uncovered[newPos] && !mines[newPos]) {
                            uncovered[newPos] = true;
                            uncoveredCount++;
                            uncoveredCount = autoUncoverSafe(newPos, uncoveredCount);
                        }
                    }
                }
            }
        }
        return uncoveredCount;
    }
    
    private void displayField() {
        displayField(false);
    }
    
    private void displayField(boolean showMines) {
        System.out.println("\n+-------------------+");
        System.out.println("|    MINEFIELD      |");
        System.out.println("+-------------------+");
        System.out.print("      1   2   3   4   5\n");
        
        for (int i = 0; i < gridSize; i++) {
            System.out.print("  " + (i + 1) + "   ");
            for (int j = 0; j < gridSize; j++) {
                int index = i * gridSize + j;
                if (uncovered[index]) {
                    int mines = countNearbyMines(index);
                    if (mines > 0) {
                        System.out.print(" " + mines + "  ");
                    } else {
                        System.out.print(" .  ");
                    }
                } else if (showMines && mines[index]) {
                    System.out.print(" X  ");
                } else {
                    System.out.print(" ?  ");
                }
            }
            System.out.println();
        }
        System.out.println("+-------------------+");
    }

    @Override
    public void showInstructions() {
        System.out.println("\n=== MINEFIELD INSTRUCTIONS ===");
        System.out.println("? The field is 5x5 with 5 hidden mines");
        System.out.println("? Reveal tiles by entering their number (1-25)");
        System.out.println("? Numbers show how many mines are adjacent");
        System.out.println("? Clear all 20 safe tiles to win!");
        System.out.println("================================\n");
    }
    @Override
    public void endGame() {
        System.out.println("Thanks for playing Minefield!");
    }
}

