/* *****************************************************************************
 *  Compilation: ActivationFunction.java
 *
 *  Last modified:     4/15/2020
 **************************************************************************** */

public class ActivationFunction {

    // Returns the Heaviside function of x
    public static double heaviside(double x) {
        if (x < 0) return 0;
        else if (x == 0) return 0.5;
        else if (x > 0) return 1;
        else return Double.NaN;
    }

    // Returns the sigmoid function of x
    public static double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x
    public static double tanh(double x) {
        double t = Math.exp(x) - Math.exp(-x);
        if (t == Double.POSITIVE_INFINITY)
            return 1;
        else if (t == Double.NEGATIVE_INFINITY)
            return -1;
        else
            return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x
    public static double softsign(double x) {
        if (x == Double.POSITIVE_INFINITY)
            return 1;
        else if (x == Double.NEGATIVE_INFINITY)
            return -1;
        else
            return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x
    public static double sqnl(double x) {
        if (x <= -2) return -1;
        else if (x > -2 && x < 0) return x + x * x / 4;
        else if (x >= 0 && x < 2) return x - x * x / 4;
        else if (x >= 2) return 1;
        else return Double.NaN;
    }

    // Takes a double command-line argument x and prints each activation

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside(" + x + ") = " + heaviside(x));
        StdOut.println("  sigmoid(" + x + ") = " + sigmoid(x));
        StdOut.println("     tanh(" + x + ") = " + tanh(x));
        StdOut.println(" softsign(" + x + ") = " + softsign(x));
        StdOut.println("     sqnl(" + x + ") = " + sqnl(x));
    }
}
