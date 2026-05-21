package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class Minefield extends Game {

    static final String NEON_RED    = "\u001B[38;5;196m";
    static final String NEON_CYAN   = "\u001B[38;5;51m";
    static final String NEON_BLUE   = "\u001B[38;5;27m";
    static final String NEON_GREEN  = "\u001B[38;5;82m";
    static final String NEON_ORANGE = "\u001B[38;5;202m";
    static final String BG_GRAY     = "\u001B[38;5;244m";
    static final String RESET       = "\u001B[0m";

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
        int playerWins = 0;
        int totalRounds = 0;
        boolean playing = true;

        while (playing) {
            try {
                System.out.println(NEON_RED + "\nWelcome to Minefield!" + RESET);
                Thread.sleep(400);
                initializeField();
                int uncoveredCount = 0;
                boolean gameOver = false;
                totalRounds++;

                while (!gameOver && uncoveredCount < safeTiles) {
                    displayField();
                    int position = inputHandler.getIntInputInRangeWithExit("\nSelect a tile to reveal (1-25): ", 1, 25) - 1;
                    
                    if (uncovered[position]) {
                        Thread.sleep(200);
                        System.out.println(NEON_RED + "\nTile already uncovered!" + RESET);
                        continue;
                    }
                    
                    Thread.sleep(300);
                    if (mines[position]) {
                        displayField(true);
                        Thread.sleep(400);
                        System.out.println(NEON_RED + "\nBOOM! You hit a mine!" + RESET);
                        gameOver = true;
                    } else {
                        uncovered[position] = true;
                        uncoveredCount++;
                        int nearbyMines = countNearbyMines(position);
                        
                        if (nearbyMines > 0) {
                            System.out.println(NEON_RED + "\n" + nearbyMines + " mine(s) nearby! +2 points" + RESET);
                            scoreManager.addPoints(2);
                        } else {
                            System.out.println(NEON_GREEN + "\nSafe tile! +5 points!" + RESET);
                            scoreManager.addPoints(5);
                            uncoveredCount = autoUncoverSafe(position, uncoveredCount);
                        }
                    }
                }
                
                Thread.sleep(500);
                if (uncoveredCount == safeTiles && !gameOver) {
                    playerWins++;
                    displayField(true);
                    Thread.sleep(400);
                    System.out.println(NEON_GREEN + "\nVICTORY! You cleared all safe tiles!" + RESET);
                    System.out.println(NEON_GREEN + "Safe tiles cleared: " + uncoveredCount + "/" + safeTiles + RESET);
                    scoreManager.addPoints(50);
                } else if (gameOver) {
                    System.out.println(NEON_RED + "\nGAME OVER!" + RESET);
                    System.out.println(NEON_RED + "You cleared " + uncoveredCount + "/" + safeTiles + " safe tiles." + RESET);
                }

                String again = "";
                boolean validChoice = false;

                while (!validChoice) {
                    try {
                        again = inputHandler.getStringInput("\nPlay another round? (y/n): ");
                        if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                            validChoice = true;
                        } else {
                            System.out.println(NEON_RED + "\nInvalid input! Please enter 'y' for Yes or 'n' for No." + RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(NEON_RED + "\nAn error occurred reading your choice. Please try again." + RESET);
                    }
                }

                if (again.equalsIgnoreCase("n")) {
                    playing = false;
                    Thread.sleep(400);
                    System.out.println(NEON_CYAN + "\nYou won " + playerWins + " out of " + totalRounds + " round(s)! Great job!\n" + RESET);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private void displayField() {
        displayField(false);
    }
    
    private void displayField(boolean showMines) {
        try {
            System.out.println(NEON_RED + "\n╔═════════════════════════════╗"); Thread.sleep(40);
            System.out.println("║           MINEFIELD         ║"); Thread.sleep(40);
            System.out.println("╠═════════════════════════════╣" + RESET); Thread.sleep(40);
            
            for (int i = 0; i < gridSize; i++) {
                System.out.print(NEON_RED + "║    " + RESET);
                for (int j = 0; j < gridSize; j++) {
                    int index = i * gridSize + j;
                    if (uncovered[index]) {
                        int nearby = countNearbyMines(index);
                        if (nearby == 1) {
                            System.out.print(NEON_BLUE + "1    " + RESET);
                        } else if (nearby == 2) {
                            System.out.print(NEON_GREEN + "2    " + RESET);
                        } else if (nearby >= 3) {
                            System.out.print(NEON_ORANGE + nearby + "    " + RESET);
                        } else {
                            System.out.print(BG_GRAY + ".    " + RESET);
                        }
                    } else if (showMines && mines[index]) {
                        System.out.print(NEON_RED + "X    " + RESET);
                    } else {
                        System.out.print(NEON_CYAN + "?    " + RESET);
                    }
                }
                System.out.println(NEON_RED + "║" + RESET);
                Thread.sleep(40);
            }
            System.out.println(NEON_RED + "╚═════════════════════════════╝" + RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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

    @Override
    public void showInstructions() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_RED + "▄██▀▀▀     ██▄  ▄██ ▄▄ ▄▄  ▄▄ ▄▄▄▄▄ ▄▄▄▄▄ ▄▄ ▄▄▄▄▄ ▄▄    ▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_RED + "██▄▄▄      ██ ▀▀ ██ ██ ███▄██ ██▄▄  ██▄▄  ██ ██▄▄  ██    ██▀██" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_RED + "▀█▄▄█▀ ▄   ██    ██ ██ ██ ▀██ ██▄▄▄ ██    ██ ██▄▄▄ ██▄▄▄ ████▀" + RESET);
            Thread.sleep(400);
            System.out.println();
            System.out.println(NEON_RED + "\nWELCOME TO MINEFIELD!" + RESET);
            System.out.println(NEON_RED + "Carefully navigate the grid and avoid hidden mines to survive the challenge." + RESET);
            System.out.println();

            System.out.println(NEON_RED + "\n========== MINEFIELD MECHANICS & RULES ==========" + RESET);
            Thread.sleep(100);
            System.out.println("\n1. The field is a 5x5 grid containing 5 hidden mines.");
            Thread.sleep(100);
            System.out.println("2. Reveal a safe tile to uncover clues about adjacent cells.");
            Thread.sleep(100);
            System.out.println("3. Number indicators show exactly how many mines border that slot.");
            Thread.sleep(100);
            System.out.println("4. Successfully sweep all 20 safe positions to claim victory!");
            System.out.println(NEON_RED + "\n===========================================" + RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void endGame() {
        try {
            Thread.sleep(200);
            System.out.println(NEON_RED + "\nThanks for playing Minefield!\n" + RESET);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}