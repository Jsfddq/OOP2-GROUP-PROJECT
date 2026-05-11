import java.util.Scanner;

public class Minefield extends Game {
    private boolean[] mines;
    private boolean[] uncovered;
    private Scanner scanner;

    public Minefield() {
        super("Minefield");
        this.mines = new boolean[25];
        this.uncovered = new boolean[25];
        this.scanner = new Scanner(System.in);
        
        // Place 5 mines randomly
        for (int i = 0; i < 5; i++) {
            int pos = (int)(Math.random() * 25);
            mines[pos] = true;
        }
    }

    private void printField() {
        System.out.println("\n+-------------------+");
        System.out.print("    1  2  3  4  5");
        System.out.println("\n+-------------------+");
        
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 5; j++) {
                int index = i * 5 + j;
                if (uncovered[index]) {
                    if (mines[index]) {
                        System.out.print("X  ");
                    } else {
                        System.out.print(".  ");
                    }
                } else {
                    System.out.print("?  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------------------+");
    }

    private void revealTile(int position) {
        uncovered[position] = true;
    }

    private boolean isMine(int position) {
        return mines[position];
    }

    private int countNearbyMines(int position) {
        int row = position / 5;
        int col = position % 5;
        int count = 0;
        
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) continue;
                int newRow = row + dr;
                int newCol = col + dc;
                if (newRow >= 0 && newRow < 5 && newCol >= 0 && newCol < 5) {
                    int newPos = newRow * 5 + newCol;
                    if (mines[newPos]) count++;
                }
            }
        }
        return count;
    }

    private int getSafeTilesCount() {
        int count = 0;
        for (int i = 0; i < uncovered.length; i++) {
            if (uncovered[i] && !mines[i]) count++;
        }
        return count;
    }
}