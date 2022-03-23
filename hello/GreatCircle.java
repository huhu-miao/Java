/* *****************************************************************************
 *  Compilation: GreatCircle.java
 *  Execution:   java GreatCircle double1 double2 double3 double 4
 *
 *  Four double command-arguments refer to latitude and longtitude (in degrees)
 *  of two points on the surface of the earth.
 *  Prints the great-circle distance (in kilometers) between the two points.
 *
 *  Last modified:     3/31/2020
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        double r = 6371.0;
        double temp1;
        double temp2;
        double d;

        x1 = Math.toRadians(x1);
        x2 = Math.toRadians(x2);
        y1 = Math.toRadians(y1);
        y2 = Math.toRadians(y2);

        temp1 = Math.sin((x2 - x1) / 2);
        temp1 = temp1 * temp1;
        temp2 = Math.sin((y2 - y1) / 2);
        temp2 = temp2 * temp2;

        d = temp1 + Math.cos(x1) * Math.cos(x2) * temp2;
        d = 2 * r * Math.asin(Math.sqrt(d));

        System.out.println(d + " kilometers");

    }
}
