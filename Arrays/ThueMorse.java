/* *****************************************************************************
 *  Compilation: ThueMorse.java
 *
 *  Last modified:     4/9/2020
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = 1;

        int[] line = new int[n];
        line[0] = 0;

        String[][] thuemorse = new String[n][n];

        while (Math.pow(2, m - 1) < n) {
            for (int i = 0; i < Math.pow(2, m - 1); i++) {
                if (i + (int) Math.pow(2, m - 1) < n)
                    line[i + (int) Math.pow(2, m - 1)] = 1 - line[i];
            }
            m++;
        }

        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++) {
                if (line[j] == line[k])
                    thuemorse[j][k] = "+";
                else
                    thuemorse[j][k] = "-";
                System.out.print(thuemorse[j][k]);
                if (k != (n - 1))
                    System.out.print("  ");
                else
                    System.out.println();
            }

    }
}
