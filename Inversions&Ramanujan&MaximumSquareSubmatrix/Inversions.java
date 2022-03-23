/* *****************************************************************************
 *  Compilation: Inversions.java
 *
 *  Last modified:     4/23/2020
 **************************************************************************** */

public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    count++;
            }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        if (k > n * (n - 1) / 2) throw new IllegalArgumentException("k must less than n*(n-1)/2");
        int[] a = new int[n];
        int m = n - 1;
        int loop = 0;

        while (k >= 0 && m >= 0) {
            if (k < m) {
                for (int i = loop; i < m - k + loop; i++)
                    a[i] = i - loop;

                a[m - (int) (k) + loop] = m;
                for (int i = m - (int) (k) + loop + 1; i < n; i++)
                    a[i] = i - loop - 1;
                break;
            }

            else {
                a[n - 1 - m] = m;
                loop++;
                k = k - m;
                m = m - 1;
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        // double start = System.currentTimeMillis();
        int[] a = generate(n, k);
        // double time1 = System.currentTimeMillis();
        // long count = count(a);
        // double time2 = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (i < n - 1)
                StdOut.print(a[i] + " ");
            else
                StdOut.println(a[i]);
        }


        // StdOut.println(count);
        // StdOut.printf("(%.0f seconds)\n", time1 - start);
        // StdOut.printf("(%.0f seconds)\n", time2 - start);

    }
}
