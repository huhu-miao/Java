/* *****************************************************************************
 *  Compilation: MaximumSquaresubmatrix.java
 *
 *  Last modified:     4/24/2020
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int max = 0;
        int sum = 0;
        int loop = 0;

        int[][] size = new int[a.length][a[0].length];
        if (a.length == 1) {
            if (a[0][0] == 1)
                loop = 1;
            return loop;
        }
        // failed if 1 appears only at the last line
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a[0].length - 1; j++)
                if (a[i][j] == 1) {
                    loop = 1;
                    if (a[i][j + 1] == 1 && a[i + 1][j] == 1 && a[i + 1][j + 1] == 1) {
                        size[i][j] = 1;
                        sum++;
                        max = 2;
                    }
                }
        // StdOut.println(max + " " + sum);
        if (sum == 0)
            return loop;

      /*  for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++) {
                if (j != a.length - 1)
                    StdOut.print(size[i][j] + " ");
                else
                    StdOut.println(size[i][j]);
            }

        StdOut.println();
      */

        while (sum != 0) {
            a = size;
            sum = 0;
            for (int i = 0; i < a.length - 1; i++)
                for (int j = 0; j < a[0].length - 1; j++)
                    if (a[i][j] == 1) {
                        if (a[i][j + 1] == 1 && a[i + 1][j] == 1 && a[i + 1][j + 1] == 1) {
                            size[i][j] = 1;
                            sum++;
                            max = loop + 2;
                        }
                        else size[i][j] = 0;
                    }
            // StdOut.println(max + " " + sum);
            loop++;
             /*   for (int i = 0; i < a.length; i++)
                    for (int j = 0; j < a[0].length; j++)
                        if (j < a.length - 1)
                            StdOut.print(size[i][j] + " ");
                        else
                            StdOut.println(size[i][j]);
                StdOut.println();

              */

        }

        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        StdOut.println(size(a));

    }
}
