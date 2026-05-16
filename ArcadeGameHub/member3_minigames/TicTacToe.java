package ArcadeGameHub.member3_minigames;

import ArcadeGameHub.member1_core.Game;
import ArcadeGameHub.member2_system.InputHandler;
import ArcadeGameHub.member2_system.ScoreManager;
import ArcadeGameHub.member4_output.Display;
import java.util.Random;

public class TicTacToe extends Game {
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

        System.out.println("\nChoose game mode:");
        System.out.println("1. vs Computer");
        System.out.println("2. Two Player");
        int mode = inputHandler.getIntInputInRangeWithExit("Enter choice (1-2): ", 1, 2);
        vsComputer = (mode == 1);
        
        if (vsComputer) {
            player1Name = "You";
            player2Name = "Computer";
        } else {
            System.out.print("Enter Player 1 name: ");
            player1Name = inputHandler.getStringInputWithExit("");
            System.out.print("Enter Player 2 name: ");
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
                    System.out.println("\nComputer's turn (O)...");
                    int position = getComputerMove();
                    System.out.println("Computer chooses position " + position);
                    makeMove(position, 'O');
                } else {
                    String currentName = (currentPlayer == 'X') ? player1Name : player2Name;
                    System.out.println("\n" + currentName + "'s turn (" + currentPlayer + ")");
                    int position = inputHandler.getIntInputInRangeWithExit("Enter position (1-9): ", 1, 9);
                    
                    if (!isValidMove(position)) {
                        System.out.println("Position already taken! Try again.");
                        continue;
                    }
                    makeMove(position, currentPlayer);
                }
                
                moves++;
                
                if (checkWin()) {
                    printBoard();
                    if (vsComputer) {
                        if (currentPlayer == 'X') {
                            System.out.println("\nCongratulations! You won!");
                            scoreManager.addPoints(20);
                        } else {
                            System.out.println("\nComputer wins! Better luck next time!");
                        }
                    } else {
                        String winner = (currentPlayer == 'X') ? player1Name : player2Name;
                        System.out.println("\n" + winner + " wins!");
                        scoreManager.addPoints(15);
                    }
                    gameWon = true;
                } else if (moves == 9) {
                    printBoard();
                    System.out.println("\nIt's a tie!");
                    scoreManager.addPoints(10);
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // Input validation using try-catch for standard error handling
            String again = "";
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    again = inputHandler.getStringInputWithExit("\nPlay another round? (y/n): ");
                    if (again.equalsIgnoreCase("y") || again.equalsIgnoreCase("n")) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid input! Please enter 'y' for Yes or 'n' for No.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred reading your choice. Please try again.");
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
        System.out.printf("  %c  |  %c  |  %c%n", board[0], board[1], board[2]);
        System.out.println("_____|_____|_____");
        System.out.println("     |     |");
        System.out.printf("  %c  |  %c  |  %c%n", board[3], board[4], board[5]);
        System.out.println("_____|_____|_____");
        System.out.println("     |     |");
        System.out.printf("  %c  |  %c  |  %c%n", board[6], board[7], board[8]);
        System.out.println("     |     |");
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
        // Win optimization check
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
        // Blocking rule setup
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
        System.out.println("\n=== TIC-TAC-TOE INSTRUCTIONS ===");
        System.out.println("? Players take turns placing X and O");
        System.out.println("? Enter a number (1-9) to place your mark");
        System.out.println("? First to get 3 in a row wins!");
        System.out.println("? Board positions:");
        System.out.println("  1 | 2 | 3 ");
        System.out.println("  ---------");
        System.out.println("  4 | 5 | 6 ");
        System.out.println("  ---------");
        System.out.println("  7 | 8 | 9 ");
        System.out.println("================================\n");
    }

    @Override
    public void endGame() {
        System.out.println("Thanks for playing Tic-Tac-Toe!");
    }
}