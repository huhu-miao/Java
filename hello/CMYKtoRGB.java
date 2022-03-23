/* *****************************************************************************
 *  Compilation: CMYKtoRGB.java
 *  Execution:   java CMYKtoRGB double-cyan double-magenta double-yellow double-black
 *
 *  Prints corresponding RGB values.
 *
 *  Last modified:     3/31/2020
 **************************************************************************** */

public class CMYKtoRGB {
    public static void main(String[] args) {
        double C = Double.parseDouble(args[0]);
        double M = Double.parseDouble(args[1]);
        double Y = Double.parseDouble(args[2]);
        double K = Double.parseDouble(args[3]);
        double W;
        int R;
        int G;
        int B;

        W = 1 - K;
        R = (int) Math.round(255 * W * (1 - C));
        G = (int) Math.round(255 * W * (1 - M));
        B = (int) Math.round(255 * W * (1 - Y));


        System.out.println("red   = " + R);
        System.out.println("green = " + G);
        System.out.println("blue  = " + B);

    }
}
