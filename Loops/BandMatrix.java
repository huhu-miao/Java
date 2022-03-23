/* *****************************************************************************
 *  Compilation: BandMatrix.java
 *
 *  Last modified:     4/6/2020
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int m = 0; m < n; m++) {
                if (m >= (i - width) && m <= (i + width))
                    System.out.print("*  ");
                else
                    System.out.print("0  ");
            }
            System.out.println("\n");
        }

    }
}
