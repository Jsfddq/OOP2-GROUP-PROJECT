package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class TicTacToe extends Game {

    static final String NEON_BLUE   = "\u001B[38;5;45m";  
    static final String NEON_RED    = "\u001B[38;5;196m"; 
    static final String RESET       = "\u001B[0m";

    private char[] board;
    private InputHandler inputHandler;
    private ScoreManager scoreManager;
    private Display display;
    private Random random;
    private char currentPlayer;
    private boolean vsComputer;
    private String player1Name;
    private String player2Name;

    public TicTacToe(InputHandler inputHandler, ScoreManager scoreManager, Display display) {
        super("Tic-Tac-Toe");
        this.inputHandler = inputHandler;
        this.scoreManager = scoreManager;
        this.display = display;
        this.random = new Random();
        this.board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        this.currentPlayer = 'X';
    }

    @Override
    public void play() {
        boolean playing = true;

        System.out.print(NEON_BLUE);
        typeText("\nChoose game mode:", 25);
        System.out.print(RESET);
        typeText("1. vs Computer", 20);
        typeText("2. Two Player", 20);
        System.out.println();
        
        System.out.print(NEON_BLUE);
        int mode = inputHandler.getIntInputInRangeWithExit("Enter choice (1-2): ", 1, 2);
        System.out.print(RESET);
        vsComputer = (mode == 1);
        
        if (vsComputer) {
            player1Name = "You";
            player2Name = "Computer";
        } else {
            System.out.print(NEON_BLUE);
            typeText("\nEnter Player 1 name: ", 20);
            System.out.print(RESET);
            player1Name = inputHandler.getStringInputWithExit("");
            
            System.out.print(NEON_RED);
            typeText("Enter Player 2 name: ", 20);
            System.out.print(RESET);
            player2Name = inputHandler.getStringInputWithExit("");
        }

        while (playing) {
            resetBoard();
            currentPlayer = 'X';
            boolean gameWon = false;
            int moves = 0;
            
            while (!gameWon && moves < 9) {
                printBoard();
                
                if (vsComputer && currentPlayer == 'O') {
                    System.out.print(NEON_RED);
                    typeText("\nComputer's turn (O)...", 25);
                    System.out.print(RESET);
                    
                    int position = getComputerMove();
                    typeText("Computer chooses position " + position, 20);
                    makeMove(position, 'O');
                } else {
                    String currentName = (currentPlayer == 'X') ? player1Name : player2Name;
                    System.out.print((currentPlayer == 'X') ? NEON_BLUE : NEON_RED);
                    typeText("\n" + currentName + "'s turn (" + currentPlayer + ")", 25);
                    System.out.print(RESET);
                    
                    System.out.print((currentPlayer == 'X') ? NEON_BLUE : NEON_RED);
                    int position = inputHandler.getIntInputInRangeWithExit("Enter position (1-9): ", 1, 9);
                    System.out.print(RESET);
                    
                    if (!isValidMove(position)) {
                        System.out.print(NEON_RED);
                        typeText("Position already taken! Try again.", 20);
                        System.out.print(RESET);
                        continue;
                    }
                    makeMove(position, currentPlayer);
                }
                
                moves++;
                
                if (checkWin()) {
                    printBoard();
                    if (vsComputer) {
                        if (currentPlayer == 'X') {
                            System.out.print(NEON_BLUE);
                            typeText("\nCongratulations! You won!", 25);
                            System.out.print(RESET);
                            scoreManager.addPoints(20);
                        } else {
                            System.out.print(NEON_RED);
                            typeText("\nComputer wins! Better luck next time!", 25);
                            System.out.print(RESET);
                        }
                    } else {
                        String winner = (currentPlayer == 'X') ? player1Name : player2Name;
                        System.out.print((currentPlayer == 'X') ? NEON_BLUE : NEON_RED);
                        typeText("\n" + winner + " wins!", 25);
                        System.out.print(RESET);
                        scoreManager.addPoints(15);
                    }
                    gameWon = true;
                } else if (moves == 9) {
                    printBoard();
                    System.out.print(NEON_BLUE);
                    typeText("\nIt's a tie!", 25);
                    System.out.print(RESET);
                    scoreManager.addPoints(10);
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInputWithExit("\nPlay another round? (y/n): ");
                    if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                        validChoice = true;
                    } else {
                        typeText("\nInvalid input! Please enter 'y' for Yes or 'n' for No.", 20);
                    }
                } catch (Exception e) {
                    typeText("\nAn error occurred reading your choice. Please try again.", 20);
                }
            }

            if (again.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
        endGame();
    }
    
    private void resetBoard() {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }
    
    private void printBoard() {
        System.out.println("\n     |     |");
        System.out.printf("  %s  |  %s  |  %s%n", formatCell(board[0]), formatCell(board[1]), formatCell(board[2]));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |");
        System.out.printf("  %s  |  %s  |  %s%n", formatCell(board[3]), formatCell(board[4]), formatCell(board[5]));
        System.out.println("_____|_____|_____");
        System.out.println("     |     |");
        System.out.printf("  %s  |  %s  |  %s%n", formatCell(board[6]), formatCell(board[7]), formatCell(board[8]));
        System.out.println("     |     |");
    }

    private String formatCell(char cell) {
        if (cell == 'X') return NEON_BLUE + "X" + RESET;
        if (cell == 'O') return NEON_RED + "O" + RESET;
        return String.valueOf(cell);
    }
    
    private void makeMove(int square, char mark) {
        board[square - 1] = mark;
    }
    
    private boolean isValidMove(int position) {
        return board[position - 1] != 'X' && board[position - 1] != 'O';
    }
    
    private boolean checkWin() {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == board[i+1] && board[i+1] == board[i+2]) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i+3] && board[i+3] == board[i+6]) return true;
        }
        if (board[0] == board[4] && board[4] == board[8]) return true;
        if (board[2] == board[4] && board[4] == board[6]) return true;
        return false;
    }
    
    private int getComputerMove() {
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(i)) {
                makeMove(i, 'O');
                if (checkWin()) {
                    undoMove(i);
                    return i;
                }
                undoMove(i);
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(i)) {
                makeMove(i, 'X');
                if (checkWin()) {
                    undoMove(i);
                    return i;
                }
                undoMove(i);
            }
        }
        if (isValidMove(5)) return 5;
        int[] corners = {1, 3, 7, 9};
        for (int corner : corners) {
            if (isValidMove(corner)) return corner;
        }
        for (int i = 1; i <= 9; i++) {
            if (isValidMove(i)) return i;
        }
        return 1;
    }
    
    private void undoMove(int position) {
        board[position - 1] = (char) ('0' + position);
    }

    @Override
    public void showInstructions() {
        try {
            Thread.sleep(600);
            System.out.println(NEON_BLUE + "██  ██     ██████ ▄▄  ▄▄▄▄   ██████ ▄▄▄   ▄▄▄▄   ██████ ▄▄▄  ▄▄▄▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_BLUE + "▀█████       ██   ██ ██▀▀▀ ▄▄▄ ██  ██▀██ ██▀▀▀ ▄▄▄ ██  ██▀██ ██▄▄" + RESET);
            Thread.sleep(80);
            System.out.println(NEON_BLUE + "    ██ ▄     ██   ██ ▀████     ██  ██▀██ ▀████     ██  ▀███▀ ██▄▄▄" + RESET);
            Thread.sleep(400);
            System.out.println();
            
            System.out.print(NEON_BLUE);
            typeText("\nWELCOME TO TIC-TAC-TOE!", 30);
            typeText("Outsmart your opponent and line up three marks to win the game.", 25);
            System.out.print(RESET);
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print(NEON_BLUE);
        typeText("\n========== TIC-TAC-TOE MECHANICS & RULES ==========", 15);
        System.out.print(RESET);

        typeText("\nPlayers take turns placing X and O", 20);
        typeText("Enter a number (1-9) to place your mark", 20);
        typeText("First to get 3 in a row wins!", 20);
        System.out.println();
        
        typeText("\tBoard positions:", 15);
        typeText("\t1 | 2 | 3 ", 10);
        typeText("\t ---------", 10);
        typeText("\t4 | 5 | 6 ", 10);
        typeText("\t ---------", 10);
        typeText("\t7 | 8 | 9 ", 10);
        System.out.println();
        typeText("You earn points based on the outcome:", 20);
        typeText("- Win against Computer: 20 points", 20);
        typeText("- Win against Player: 15 points", 20);
        typeText("- Tie: 10 points", 20);
        System.out.println();
        
        System.out.print(NEON_BLUE);
        typeText("===================================================", 15);
        System.out.print(RESET);
        
        
    }

    @Override
    public void endGame() {
        System.out.print(NEON_BLUE);
        typeText("\nThanks for playing Tic-Tac-Toe!", 30);
        System.out.print(RESET);
    }
}