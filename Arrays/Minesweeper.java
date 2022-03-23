/* *****************************************************************************
 *  Compilation: Minesweeper.java
 *
 *  Last modified:     4/9/2020
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] cell = new int[m][n];
        int[][] mine = new int[m][n];

        int r = 0;
        while (r < k) {
            int i = (int) (Math.random() * m);
            int j = (int) (Math.random() * n);

            if (mine[i][j] == 0) {
                mine[i][j] = 1;
                r++;
            }

        }

        // define numbers in the cell matrix
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mine[i][j] == 0) {
                    if (i - 1 >= 0) {
                        cell[i][j] = cell[i][j] + mine[i - 1][j];
                        if (j - 1 >= 0)
                            cell[i][j] = cell[i][j] + mine[i - 1][j - 1];
                        if (j + 1 < n)
                            cell[i][j] = cell[i][j] + mine[i - 1][j + 1];
                    }
                    if (i + 1 < m) {
                        cell[i][j] = cell[i][j] + mine[i + 1][j];
                        if (j - 1 >= 0)
                            cell[i][j] = cell[i][j] + mine[i + 1][j - 1];
                        if (j + 1 < n)
                            cell[i][j] = cell[i][j] + mine[i + 1][j + 1];
                    }
                    if (j - 1 >= 0)
                        cell[i][j] = cell[i][j] + mine[i][j - 1];
                    if (j + 1 < n)
                        cell[i][j] = cell[i][j] + mine[i][j + 1];

                }


        // print out the cell matrix

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    if (mine[i][j] == 0)
                        System.out.print(cell[i][j] + "  ");
                    else
                        System.out.print("*  ");
                }
                else {
                    if (mine[i][n - 1] == 0)
                        System.out.println(cell[i][n - 1]);
                    else
                        System.out.println("*");
                }
            }

        }
    }
}
