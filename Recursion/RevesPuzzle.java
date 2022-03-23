/* *****************************************************************************
 *  Compilation: RevesPuzzle.java
 *
 *  Last modified:     4/21/2020
 **************************************************************************** */

public class RevesPuzzle {

    private static void hanoi3(int n, int k, String from, String temp, String to) {
        if (n - k == 0) return;
        hanoi3(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi3(n - 1, k, temp, from, to);

    }


    public static void hanoi(int n, String from, String temp1, String temp2, String to) {
        if (n == 0) return;
        int k = (int) (Math.round(n + 1 - Math.sqrt(2 * n + 1)));
        hanoi(k, from, temp2, to, temp1);
        hanoi3(n, k, from, temp2, to);
        hanoi(k, temp1, temp2, from, to);
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        hanoi(n, "A", "B", "C", "D");

    }
}
