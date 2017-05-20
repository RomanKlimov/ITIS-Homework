import java.util.Scanner;

/**
 * Created by klimo on 20.05.2017.
 */
public class UserFire {
    public static int userFire(String[][] board, int hits, int torps) {
        Scanner input = new Scanner(System.in);
        int row, col;

        System.out.println("You have: " + torps + " torpedos left!");
        System.out.println("Select a row to fire in: ");

        row = input.nextInt();

        while (row > 8 || row < 1) {

            System.out.println("Enter a valid row (1 -> 8)");
            row = input.nextInt();
        }

        System.out.println("Select a column to fire in: ");

        col = input.nextInt();

        while (col > 8 || col < 1) {
            System.out.println("Enter a valid col (1 -> 8)");
            col = input.nextInt();
        }

        if (board[row - 1][col - 1].equals("S")) {
            hits++;
            System.out.println("~~~~~~~ HIT ~~~~~~~");
            board[row - 1][col - 1] = "!";
        }
        else {
            System.out.println("~~~~~~~ MISS ~~~~~~~");
            board[row - 1][col - 1] = "M";
        }

        return hits;
    }

    public static void ending(int hits, int torps) {
        if (hits < 4) {
            System.out.println("Sorry, but you lost because you didn't sink the ship.");
        }
        if (torps < 1) {
            System.out.println("You have lost all your torpedos");
        }
        else{
            if (hits >= 4) {
                System.out.println("You have beaten the game battleship, Thanks for playing!");
            }
        }

        System.out.println("Good game, well played!");
    }

}
