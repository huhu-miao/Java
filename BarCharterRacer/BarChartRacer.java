/* *****************************************************************************
 *  Compilation: BarChartRacer.java
 *
 *  Last modified:     5/01/2020
 **************************************************************************** */


import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("cow.wav");
        String filename = args[0];
        int barNumber = Integer.parseInt(args[1]);
        In in;
        in = new In(filename);

        StdDraw.enableDoubleBuffering();


        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        StdDraw.setCanvasSize(1000, 700);
        //  StdOut.println(title + " " + xAxis + " " + source);

        while (in.hasNextLine()) {
            in.readLine();
            int recordNumber = Integer.parseInt(in.readLine());
            // StdOut.print(recordNumber + "  ");
            BarChart chart = new BarChart(title, xAxis, source);
            Bar[] records = new Bar[recordNumber];

            for (int i = 0; i < recordNumber; i++) {
                String[] barRecord = in.readLine().split(",");
                chart.setCaption(barRecord[0]);
                records[i] = new Bar(barRecord[1], Integer.parseInt(barRecord[3]), barRecord[4]);
            }

            Arrays.sort(records);

            for (int i = 0; i < barNumber; i++) {
                String name = records[recordNumber - 1 - i].getName();
                int value = records[recordNumber - 1 - i].getValue();
                String catergory = records[recordNumber - 1 - i].getCategory();
                chart.add(name, value, catergory);
            }


            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            chart.reset();

        }


    }
}
