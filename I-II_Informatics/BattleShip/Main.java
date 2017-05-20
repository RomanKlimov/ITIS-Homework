/**
 * Created by klimo on 20.05.2017.
 */
public class Main {
    public static void main(String[] arg) {
        Table table = new Table();
        UserFire userFire = new UserFire();

        String[][] board = new String[8][8];
        table.createBoard(board);
        table.createShip(board, 4);
        int torps = 15;
        int hits = 0;

        while (torps > 0 && hits < 4) {
            table.showBoard(board);
            hits = userFire.userFire(board, hits, torps);
            torps--;
        }

        userFire.ending(hits, torps);
    }
}
