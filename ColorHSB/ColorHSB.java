/* *****************************************************************************
 *  Compilation: ColorHSB.java
 *
 *  Last modified:     4/29/2020
 **************************************************************************** */

public class ColorHSB {

    private final int hu;
    private final int sa;
    private final int br;

    // Creates a color with hue h, saturations, and brightness b.
    public ColorHSB(int h, int s, int b) {
        hu = h;
        sa = s;
        br = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        if (hu < 0 || hu >= 360)
            throw new IllegalArgumentException("the hue must between 0 and 359");
        else if (sa < 0 || sa > 100)
            throw new IllegalArgumentException("the saturation must between 0 and 100");
        else if (br < 0 || br > 100)
            throw new IllegalArgumentException("the brightness must between 0 and 100");
        else
            return "(" + hu + ", " + sa + ", " + br + ")";
    }

    // is this color a shade of gray?
    public boolean isGrayscale() {
        return (sa == 0 || br == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("the compared color expected");
        return Math.min((hu - that.hu) * (hu - that.hu),
                        (360 - Math.abs(hu - that.hu)) * (360 - Math.abs(hu - that.hu)))
                + (sa - that.sa) * (sa - that.sa) + (br - that.br) * (br
                - that.br);
    }

    // Sample client.
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB colorOriginal = new ColorHSB(h, s, b);


        String colorName = StdIn.readString();
        int h1 = StdIn.readInt();
        int s1 = StdIn.readInt();
        int b1 = StdIn.readInt();
        ColorHSB color = new ColorHSB(h1, s1, b1);
        int distance = colorOriginal.distanceSquaredTo(color);
        String colorNameCloset = colorName;
        ColorHSB colorCloset = color;

        while (!StdIn.isEmpty()) {
            colorName = StdIn.readString();
            h1 = StdIn.readInt();
            s1 = StdIn.readInt();
            b1 = StdIn.readInt();
            color = new ColorHSB(h1, s1, b1);
            if (colorOriginal.distanceSquaredTo(color) < distance) {
                distance = colorOriginal.distanceSquaredTo(color);
                colorNameCloset = colorName;
                colorCloset = color;
            }
        }

        StdOut.println(colorNameCloset + " " + colorCloset);

    }
}
