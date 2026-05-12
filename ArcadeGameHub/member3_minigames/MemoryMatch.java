import java.util.Scanner;

public class MemoryMatch extends Game {
    private String[] board;
    private boolean[] revealed;
    private Scanner scanner;

    public MemoryMatch() {
        super("Memory Match");
        this.board = new String[]{"A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H"};
        this.revealed = new boolean[16];
        this.scanner = new Scanner(System.in);
    }

    private void printBoard() {
        System.out.println("\n+-------------------+");
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
    }

    private void revealCard(int position) {
        revealed[position] = true;
    }

    private void hideCard(int position) {
        revealed[position] = false;
    }

    private boolean isMatch(int pos1, int pos2) {
        return board[pos1].equals(board[pos2]);
    }

    private boolean allRevealed() {
        for (boolean b : revealed) {
            if (!b) return false;
        }
        return true;
    }
}