/* *****************************************************************************
 *  Compilation: WorldMap.java
 *
 *  Last modified:     4/14/2020
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {

        int width = StdIn.readInt();
        int height = StdIn.readInt();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int v = StdIn.readInt();
            double[] plgx = new double[v];
            double[] plgy = new double[v];
            for (int i = 0; i < v; i++) {
                plgx[i] = StdIn.readDouble();
                plgy[i] = StdIn.readDouble();
            }
            StdDraw.polygon(plgx, plgy);
        }

    }
}
