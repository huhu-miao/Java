/* *****************************************************************************
 *  Compilation: Ramanujan.java
 *
 *  Last modified:     4/24/2020
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        boolean isRamanujan = false;
        int count = 0;
        double b = 0;
        long cube = 0;
        for (long i = 1; i <= (long) (Math.cbrt(n)); i++) {

            cube = i * i * i;
            // StdOut.print(cube + " ");
            b = Math.cbrt(n - cube);
            // StdOut.println(i + " " + b + " ");

            if (Math.abs(b - Math.round(b)) == 0) {
                count++;

                //   StdOut.println(count);
            }
        }
        if (count / 2 >= 2)
            isRamanujan = true;
        // StdOut.print(count);
        return isRamanujan;
    }

    // Takes an long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));

    }
}
