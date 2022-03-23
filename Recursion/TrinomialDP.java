/* *****************************************************************************
 *  Compilation: TrinomialDP.java
 *
 *  Last modified:     4/21/2020
 **************************************************************************** */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n,k)
    public static long trinomial(int n, int k) {
        if ((n == 0 && k == 0))
            return 1;
        if (k < -n || k > n)
            return 0;
        long[][] coefficient = new long[n + 1][2 * n + 1];
        coefficient[0][n] = 1;  // T(0,0)
        coefficient[0][n - 1] = 0; // T(0,-1)
        coefficient[0][n + 1] = 0; // T(0,1)
        coefficient[1][n] = 1;  // T(1,0)
        coefficient[1][n + 1] = 1;  // T(1,1)
        coefficient[1][n - 1] = 1; // T(1,-1)
        for (int i = 2; i < n + 1; i++) {
            for (int j = n; j < 2 * n + 1; j++) {
                if (j > i + n)
                    coefficient[i][j] = 0;
                else if (j == 2 * n)
                    coefficient[i][j] = coefficient[i - 1][j - 1] + coefficient[i - 1][j];
                else
                    coefficient[i][j] = coefficient[i - 1][j - 1] + coefficient[i - 1][j]
                            + coefficient[i - 1][j + 1];
            }
            for (int j = 0; j < n; j++)
                coefficient[i][j] = coefficient[i][2 * n - j];
        }

        return coefficient[n][k + n];
    }

    // Take two integer command-line arguments n and k and prints T(n,k)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
