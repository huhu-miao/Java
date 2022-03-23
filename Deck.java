/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Deck {

    public static void q4(int n) {
        if (n <= 0) return;
        StdOut.println(n);
        q4(n - 2);
        q4(n - 3);
        StdOut.println(n);

    }

    public static int q5(int n) {
        int[] b = new int[n + 1];
        b[0] = 1;
        for (int i = 2; i <= n; i++) {
            b[i] = 0;
            for (int j = 0; j < i; j++)
                b[i] += b[j];
        }
        return b[n];
    }

    public static void main(String[] args) {

        // int n = StdIn.readInt();
        // double m = Double.parseDouble(args[0]);
        // q4(n);

        //  StdOut.println(q5(n));
        //  StdOut.println(Math.round(m));

        // String a = "0";
        //   int t = Integer.parseInt(a);
        StdOut.println(Integer.compare(3, 6));
        StdOut.println(Integer.compare(3, 3));
        StdOut.println(Integer.compare(6, 3));
       /* while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            if (!StdIn.isEmpty()) x += StdIn.readInt();
            StdOut.print(x + " ");
        }

        StdOut.println();


        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;

        int[] total = new int[n + 1];
        total[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            total[i] = total[i - 1] + Integer.parseInt(args[i]);
        }

        for (int i = 0; i < m; i++) {
            int x = (int) (Math.random() * total[n]);
            for (int j = 0; j < n; j++) {
                if (x >= total[j] && x < total[j + 1])
                    System.out.print(j + 1 + " ");
            }
        }

        String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        String[] suit = { "♠️", "♣️", "♥️", "♦️" };

        String[] deck = new String[52];
        for (int j = 0; j < 4; j++)
            for (int i = 0; i < 13; i++)
                deck[i + 13 * j] = rank[i] + suit[j];

        for (int i = 0; i < 52; i++)
            System.out.print(deck[i] + " ");
        System.out.println(); */


    }
}
