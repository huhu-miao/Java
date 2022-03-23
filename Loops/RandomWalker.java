/* *****************************************************************************
 *  Compilation: RandomWalker.java
 *
 *  Last modified:     4/6/2020
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        double p;

        while ((Math.abs(x) + Math.abs(y)) != r) {
            p = Math.random();
            if (p < 0.25)
                x = x + 1;
            else if (p >= 0.25 && p < 0.5)
                x = x - 1;
            else if (p >= 0.5 && p < 0.75)
                y = y + 1;
            else
                y = y - 1;
            steps = steps + 1;

            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
