/* *****************************************************************************
 *  Compilation: AudioCollage.java
 *
 *  Last modified:     4/16/2020
 **************************************************************************** */

public class AudioCollage {

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
        double[] b = new double[(int) (n)];
        for (int i = 0; i < (int) (n); i++)
            b[i] = a[(int) (i * alpha)];
        return b;
    }

    // Creates an audio collage and plays it on standard audio

    public static void main(String[] args) {

        double[] chimes = StdAudio.read("chimes.wav");
        double[] piano = StdAudio.read("piano.wav");
        double[] harp = StdAudio.read("harp.wav");
        double[] scrach = StdAudio.read("scratch.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] silence = StdAudio.read("silence.wav");

        double[] start = merge(chimes, amplify(harp, 0.5));
        double[] part1 = mix(amplify(changeSpeed(piano, 0.75), 0.8),
                             merge(silence, amplify(scrach, 0.5)));
        double[] part2 = mix(changeSpeed(piano, 0.75), merge(silence, harp));
        double[] part3 = merge(silence, amplify(reverse(cow), 0.5));
        part3 = merge(changeSpeed(part3, 0.8), amplify(chimes, 0.5));
        double[] end = mix(singer, part3);

        double[] result = merge(start, part1);
        result = merge(result, part2);
        result = merge(result, end);


        StdAudio.play(result);

    }
}
