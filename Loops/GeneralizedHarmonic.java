/* *****************************************************************************
 *  Compilation: GeneralizedHarmonic.java
 *
 *  Last modified:     4/6/2020
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double H = 0;

        for (int i = 1; i <= n; i++) {
            H = H + 1 / Math.pow(i, r);
        }

        System.out.println(H);


    }
}
