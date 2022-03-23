/* *****************************************************************************
 *  Compilation: ShannonEntropy.java
 *
 *  Last modified:     4/14/2020
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        int[] count = new int[m];
        int n = 0;

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            n++;
            count[x - 1]++;
        }

        double h = 0.0;
        for (int i = 0; i < m; i++) {
            double p = count[i] / (double) (n);
            if (p != 0)
                h = h - p * (Math.log(p) / Math.log(2));
        }

        StdOut.printf("%.4f\n", h);

    }
}
