/* *****************************************************************************
 *  Compilation: Birthday.java
 *
 *  Last modified:     4/9/2020
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);


        int[] count = new int[n + 1]; // count the number of trials
        double[] fraction = new double[n + 1];

        for (int k = 0; k < trials; k++) {
            int i = 0; // count the number of persons enter the room

            int[] birthday = new int[n + 1];
            boolean found = false;


            while (!found) {
                int r = (int) (Math.random() * n);
                birthday[i] = r;
                i++;
                for (int j = 0; j < i - 1; j++)
                    if (birthday[j] == r) {
                        found = true;
                    }
                if (found)
                    count[i - 1]++;
            }

        }


        for (int i = 0; i < n + 1; i++) {
            int total = 0;
            for (int j = 0; j <= i; j++)
                total = total + count[j];
            fraction[i] = total / (double) (trials);
        }


        int nn = 0;
        while (fraction[nn] < 0.5) {
            System.out.println(nn + 1 + "\t" + count[nn] + "\t" + fraction[nn]);

            nn++;
        }
        System.out.println(nn + 1 + "\t" + count[nn] + "\t" + fraction[nn]);

    }
}
