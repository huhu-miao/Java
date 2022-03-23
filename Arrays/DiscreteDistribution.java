/* *****************************************************************************
 *  Compilation: DiscreteDistribution.java
 *
 *  Last modified:     4/9/2020
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;

        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(args[i]);
        }

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sum[n]);
            for (int j = 0; j < n; j++) {
                if (r >= sum[j] && r < sum[j + 1])
                    System.out.print(j + 1 + " ");
            }
        }
        System.out.println();

    }
}
