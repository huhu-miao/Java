/* *****************************************************************************
 *  Compilation: Kernelfilter.java
 *
 *  Last modified:     4/28/2020
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {

    // Returns the red matrix of a given picture.
    private static int[][] red(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        int[][] red = new int[width][height];

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                red[col][row] = color.getRed();
            }
        return red;
    }

    // Returns the blue matrix of a given picture.
    private static int[][] blue(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        int[][] blue = new int[width][height];

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                blue[col][row] = color.getBlue();
            }
        return blue;
    }

    // Returns the green matrix of a given picture.
    private static int[][] green(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        int[][] green = new int[width][height];

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                Color color = picture.get(col, row);
                green[col][row] = color.getGreen();
            }
        return green;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {

        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] red = red(picture);
        int[][] blue = blue(picture);
        int[][] green = green(picture);

        int targetRed = 0;
        int targetGreen = 0;
        int targetBlue = 0;

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                int leftcol = (width + col - 1) % width;
                int rightcol = (width + col + 1) % width;
                int uprow = (height + row - 1) % height;
                int downrow = (height + row + 1) % height;

                targetRed = (int) (Math
                        .round((red[leftcol][uprow] + 2 * red[leftcol][row] + red[leftcol][downrow]
                                + 2 * red[col][uprow] + 4 * red[col][row] + 2 * red[col][downrow]
                                + red[rightcol][uprow] + 2 *
                                red[rightcol][row] + red[rightcol][downrow]) / 16.0));
                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                targetGreen = (int) (Math
                        .round((green[leftcol][uprow] + 2 * green[leftcol][row]
                                + green[leftcol][downrow]
                                + 2 * green[col][uprow] + 4 * green[col][row]
                                + 2 * green[col][downrow]
                                + green[rightcol][uprow] + 2 *
                                green[rightcol][row] + green[rightcol][downrow]) / 16.0));
                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                targetBlue = (int) (Math
                        .round((blue[leftcol][uprow] + 2 * blue[leftcol][row]
                                + blue[leftcol][downrow]
                                + 2 * blue[col][uprow] + 4 * blue[col][row]
                                + 2 * blue[col][downrow]
                                + blue[rightcol][uprow] + 2 *
                                blue[rightcol][row] + blue[rightcol][downrow]) / 16.0));
                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                Color targetColor = new Color(targetRed, targetGreen, targetBlue);
                target.set(col, row, targetColor);
            }
        return target;
    }


    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] red = red(picture);
        int[][] blue = blue(picture);
        int[][] green = green(picture);

        int targetRed = 0;
        int targetGreen = 0;
        int targetBlue = 0;

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                int leftcol = (width + col - 1) % width;
                int rightcol = (width + col + 1) % width;
                int uprow = (height + row - 1) % height;
                int downrow = (height + row + 1) % height;

                targetRed = 5 * red[col][row] - red[leftcol][row] - red[col][uprow]
                        - red[col][downrow] -
                        red[rightcol][row];
                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                targetGreen = 5 * green[col][row] - green[leftcol][row] - green[col][uprow]
                        - green[col][downrow] -
                        green[rightcol][row];
                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                targetBlue = 5 * blue[col][row] - blue[leftcol][row] - blue[col][uprow]
                        - blue[col][downrow] -
                        blue[rightcol][row];
                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                Color targetColor = new Color(targetRed, targetGreen, targetBlue);
                target.set(col, row, targetColor);
            }
        return target;

    }


    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {

        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] red = red(picture);
        int[][] blue = blue(picture);
        int[][] green = green(picture);

        int targetRed = 0;
        int targetGreen = 0;
        int targetBlue = 0;

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                int leftcol = (width + col - 1) % width;
                int rightcol = (width + col + 1) % width;
                int uprow = (height + row - 1) % height;
                int downrow = (height + row + 1) % height;

                targetRed = 8 * red[col][row] - red[leftcol][uprow] - red[leftcol][row]
                        - red[leftcol][downrow] - red[col][uprow] - red[col][downrow]
                        - red[rightcol][uprow] - red[rightcol][row] - red[rightcol][downrow];
                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                targetGreen = 8 * green[col][row] - green[leftcol][uprow] - green[leftcol][row]
                        - green[leftcol][downrow] - green[col][uprow] - green[col][downrow]
                        - green[rightcol][uprow] - green[rightcol][row] - green[rightcol][downrow];
                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                targetBlue = 8 * blue[col][row] - blue[leftcol][uprow] - blue[leftcol][row]
                        - blue[leftcol][downrow] - blue[col][uprow] - blue[col][downrow]
                        - blue[rightcol][uprow] - blue[rightcol][row] - blue[rightcol][downrow];
                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                Color targetColor = new Color(targetRed, targetGreen, targetBlue);
                target.set(col, row, targetColor);
            }
        return target;
    }

    // Returns a new picture that applies emboss filter to the given picture.
    public static Picture emboss(Picture picture) {

        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] red = red(picture);
        int[][] blue = blue(picture);
        int[][] green = green(picture);

        int targetRed = 0;
        int targetGreen = 0;
        int targetBlue = 0;

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                int leftcol = (width + col - 1) % width;
                int rightcol = (width + col + 1) % width;
                int uprow = (height + row - 1) % height;
                int downrow = (height + row + 1) % height;

                targetRed = red[col][row] - 2 * red[leftcol][uprow] - red[leftcol][row]
                        - red[col][uprow] + red[col][downrow]
                        + red[rightcol][row] + 2 * red[rightcol][downrow];
                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                targetGreen = green[col][row] - 2 * green[leftcol][uprow] - green[leftcol][row]
                        - green[col][uprow] + green[col][downrow]
                        + green[rightcol][row] + 2 * green[rightcol][downrow];
                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                targetBlue = blue[col][row] - 2 * blue[leftcol][uprow] - blue[leftcol][row]
                        - blue[col][uprow] + blue[col][downrow]
                        + blue[rightcol][row] + 2 * blue[rightcol][downrow];
                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                Color targetColor = new Color(targetRed, targetGreen, targetBlue);
                target.set(col, row, targetColor);
            }
        return target;
    }

    // Returns a new picture that applies an motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture target = new Picture(width, height);

        int[][] red = red(picture);
        int[][] blue = blue(picture);
        int[][] green = green(picture);

        int targetRed = 0;
        int targetGreen = 0;
        int targetBlue = 0;

        for (int col = 0; col < width; col++)
            for (int row = 0; row < height; row++) {
                int leftcol1 = (width + col - 1) % width;
                int leftcol2 = (width + col - 2) % width;
                int leftcol3 = (width + col - 3) % width;
                int leftcol4 = (width + col - 4) % width;


                int rightcol1 = (width + col + 1) % width;
                int rightcol2 = (width + col + 2) % width;
                int rightcol3 = (width + col + 3) % width;
                int rightcol4 = (width + col + 4) % width;


                int uprow1 = (height + row - 1) % height;
                int uprow2 = (height + row - 2) % height;
                int uprow3 = (height + row - 3) % height;
                int uprow4 = (height + row - 4) % height;

                int downrow1 = (height + row + 1) % height;
                int downrow2 = (height + row + 2) % height;
                int downrow3 = (height + row + 3) % height;
                int downrow4 = (height + row + 4) % height;


                targetRed = (int) (Math.round((red[leftcol1][uprow1] + red[leftcol2][uprow2]
                        + red[leftcol3][uprow3]
                        + red[leftcol4][uprow4] + red[col][row] + red[rightcol1][downrow1]
                        + red[rightcol2][downrow2]
                        + red[rightcol3][downrow3] + red[rightcol4][downrow4]) / 9.0));
                if (targetRed < 0) targetRed = 0;
                if (targetRed > 255) targetRed = 255;

                targetGreen = (int) (Math.round((green[leftcol1][uprow1] + green[leftcol2][uprow2]
                        + green[leftcol3][uprow3]
                        + green[leftcol4][uprow4] + green[col][row] + green[rightcol1][downrow1]
                        + green[rightcol2][downrow2]
                        + green[rightcol3][downrow3] + green[rightcol4][downrow4]) / 9.0));
                if (targetGreen < 0) targetGreen = 0;
                if (targetGreen > 255) targetGreen = 255;

                targetBlue = (int) (Math.round((blue[leftcol1][uprow1] + blue[leftcol2][uprow2]
                        + blue[leftcol3][uprow3]
                        + blue[leftcol4][uprow4] + blue[col][row] + blue[rightcol1][downrow1]
                        + blue[rightcol2][downrow2]
                        + blue[rightcol3][downrow3] + blue[rightcol4][downrow4]) / 9.0));
                if (targetBlue < 0) targetBlue = 0;
                if (targetBlue > 255) targetBlue = 255;

                Color targetColor = new Color(targetRed, targetGreen, targetBlue);
                target.set(col, row, targetColor);
            }
        return target;
    }


    // Test client.
    public static void main(String[] args) {

        // String filter = StdIn.readString();
        Picture picture = new Picture("baboon.png");
        // Picture target = new Picture(picture.width(), picture.height());
       /* if (filter.equals("gaussian"))
            target = gaussian(picture);
        else if (filter.equals("sharpen"))
            target = sharpen(picture);
        else if (filter.equals("laplacian"))
            target = laplacian(picture);
        else if (filter.equals("emboss"))
            target = emboss(picture);
        else if (filter.equals("motionblur"))
            target = motionBlur(picture);
        else
            target = picture;
 */
        picture.show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();


    }
}
