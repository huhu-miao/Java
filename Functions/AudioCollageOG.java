/* *****************************************************************************
 *  Compilation: AudioCollage.java
 *
 *  Last modified:     4/16/2020
 **************************************************************************** */

public class AudioCollageOG {

    // Returns a new array that rescales a[] by multiplicative factor of alpha
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++)
            b[i] = a[i] * alpha;
        return b;
    }

    // Returns a new array that is the reverse of a[]
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++)
            b[a.length - 1 - i] = a[i];
        return b;
    }

    // Returns a new array that is the contatenation of a[] and b[]
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i];
        for (int i = 0; i < b.length; i++)
            c[a.length + i] = b[i];
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary
    public static double[] mix(double[] a, double[] b) {

        if (a.length < b.length) {
            double[] c = new double[b.length];
            for (int i = 0; i < a.length; i++)
                c[i] = a[i];
            for (int i = 0; i < b.length; i++)
                c[i] = c[i] + b[i];
            return c;
        }
        else if (a.length > b.length) {
            double[] c = new double[a.length];
            for (int i = 0; i < b.length; i++)
                c[i] = b[i];
            for (int i = 0; i < a.length; i++)
                c[i] = c[i] + a[i];
            return c;
        }
        else {
            double[] c = new double[a.length];
            for (int i = 0; i < a.length; i++)
                c[i] = a[i] + b[i];
            return c;
        }

    }

    // Returns a new array that changes the speed by the given factor
    public static double[] changeSpeed(double[] a, double alpha) {
        double n = a.length / alpha;
        double[] b = new double[(int) (n + 1)];
        for (int i = 0; i < n; i++)
            b[i] = a[(int) (i * alpha)];
        return b;
    }

    // Creates an audio collage and plays it on standard audio

    public static void main(String[] args) {
        System.out.println("Please enter the effect:");
        String effect = StdIn.readString();
        double[] result = null;

        if (effect.equals("amplify")) {
            System.out.println("Please enter the file name and constant alpha:");
            String infile = StdIn.readString();
            double[] a = StdAudio.read(infile);
            double alpha = StdIn.readDouble();
            result = amplify(a, alpha);
        }

        else if (effect.equals("reverse")) {
            System.out.println("Please enter the file name:");
            String infile = StdIn.readString();
            double[] a = StdAudio.read(infile);
            result = reverse(a);
        }
        else if (effect.equals("merge")) {
            System.out.println("Please enter the file names:");
            String infile1 = StdIn.readString();
            String infile2 = StdIn.readString();
            double[] a = StdAudio.read(infile1);
            double[] b = StdAudio.read(infile2);
            result = merge(a, b);
        }
        else if (effect.equals("mix")) {
            System.out.println("Please enter the file names:");
            String infile1 = StdIn.readString();
            String infile2 = StdIn.readString();
            double[] a = StdAudio.read(infile1);
            double[] b = StdAudio.read(infile2);
            result = mix(a, b);
        }
        else if (effect.equals("changeSpeed")) {
            System.out.println("Please enter the file name and speed:");
            String infile = StdIn.readString();
            double alpha = StdIn.readDouble();
            double[] a = StdAudio.read(infile);
            result = changeSpeed(a, alpha);
        }
        else
            System.out.println("Unknown effect: " + effect);

        if (result != null)
            StdAudio.play(result);
    }
}
