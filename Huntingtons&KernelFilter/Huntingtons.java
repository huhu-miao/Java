/* *****************************************************************************
 *  Compilation: Huntingtons.java
 *
 *  Last modified:     4/27/2020
 **************************************************************************** */

public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        int past = 0;
        for (int i = 0; i < dna.length() - 2; i++) {
            if (dna.substring(i, i + 3).equals("CAG")) {
                if (max == 0)
                    count = 1;
                else {
                    if (i - past == 3)
                        count++;
                    else
                        count = 1;
                }
                past = i;
                if (max < count)
                    max = count;

            }
          /*  if (dna.substring(i, i + 3).equals("CAG")) {
                count = 1;
                for (int j = i + 3; j < dna.length() - 3; j += 3)
                    if (dna.substring(j, j + 3).equals("CAG"))
                        count++;
                    else
                        break;

           */
        }
        // max = Math.max(max, count);
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String newstring = s;

        newstring = newstring.replace(" ", "");
        newstring = newstring.replace("\t", "");
        newstring = newstring.replace("\n", "");


        return newstring;

    }

    // Returns one of these diagnose corresponding to the maximum number of repeats;
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        // String diagnose = "";
        if (maxRepeats >= 0 && maxRepeats < 10 || maxRepeats > 180)
            return "not human";
        else if (maxRepeats > 9 && maxRepeats < 36)
            return "normal";
        else if (maxRepeats > 35 && maxRepeats < 40)
            return "high risk";
        else
            return "Huntington's";
    }


    // Sample client.
    public static void main(String[] args) {
        String filename = args[0];
        In in;
        in = new In(filename);
        String s = in.readAll();
        String remove = removeWhitespace(s);
        int maxrepeats = maxRepeats(remove);
        StdOut.println("max repeats = " + maxrepeats);
        StdOut.println(diagnose(maxrepeats));

    }
}
