/* *****************************************************************************
 *  Compilation: javac RightTriangle.java
 *  Execution:    java RightTriangle integer1 integer2 integer3
 *
 *  Prints "ture" if those three integers from the command-line can constitute
 *  the side lengths of some right triangle. Otherwise, print "false".
 *
 *  Last modified:     3/31/2020
 **************************************************************************** */

public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean isPositive;
        boolean isTriangle;

        // positive or not
        isPositive = (a > 0) && (b > 0) && (c > 0);

        // sum of the squares of two of the integers euqal the square of the third integer
        isTriangle = (a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c
                == a * a);

        isTriangle = isTriangle && isPositive;

        System.out.println(isTriangle);
    }
}
