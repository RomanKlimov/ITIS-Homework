/**
 * Created by klimo on 20.05.2017.
 */
public class Table {
    public static final boolean DEBUG = true;

    public static void createShip(String[][] board, int size) {
        if (Math.random() < 0.5) {
            int col = (int) (Math.random() * 5);
            int row = (int) (Math.random() * 7);
            for (int i = 0; i < size; i++) {
                board[row][col + i] = "S";
            }
        }
        else {
            int col = (int) (Math.random() * 7);
            int row = (int) (Math.random() * 5);
            for (int i = 0; i < size; i++) {
                board[row + i][col] = "S";
            }
        }
    }

    public static void breakln() {
        System.out.println("_____________________________");
        System.out.println("");
    }

    public static void createBoard(String[][] board) {
        int i = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                board[r][c] = "~";
            }
        }
    }

    public static void showBoard(String[][] board) {
        breakln();

        System.out.println("   1 2 3 4 5 6 7 8");

        for (int r = 0; r < board.length; r++) {
            System.out.print(r + 1 + " ");

            if (DEBUG == true) {
                for (int c = 0; c < board[0].length; c++) {
                    System.out.print(" " + board[r][c]);
                }

                System.out.print("\n");
            }
            else {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c].equals("S")) {
                        System.out.print(" " + "~");
                    }
                    else {
                        System.out.print(" " + board[r][c]);
                    }
                }

                System.out.println("");
            }
        }

        breakln();
    }
}
