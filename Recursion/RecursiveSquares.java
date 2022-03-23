/* *****************************************************************************
 *  Compilation: RecursiveSquares.java
 *
 *  Last modified:     4/22/2020
 **************************************************************************** */

public class RecursiveSquares {
    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, 0.5 * length);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, 0.5 * length);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) return;
        draw(n - 1, x - 0.5 * length, y + 0.5 * length, 0.5 * length);
        draw(n - 1, x + 0.5 * length, y + 0.5 * length, 0.5 * length);
        drawSquare(x, y, length);
        draw(n - 1, x - 0.5 * length, y - 0.5 * length, 0.5 * length);
        draw(n - 1, x + 0.5 * length, y - 0.5 * length, 0.5 * length);
    }

    // Takes an integer command-line arguement n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length o.5.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);

    }
}
