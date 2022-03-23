/* *****************************************************************************
 *  Compilation: RandomWalkers.java
 *
 *  Last modified:     4/6/2020
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;
        int steps = 0;
        double p;

        for (int i = 1; i <= trails; i++) {
            x = 0;
            y = 0;
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
            }
        }

        double average = steps / (double) trails;

        System.out.println("average number of steps = " + average);
    }
}
