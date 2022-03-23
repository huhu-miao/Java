/* *****************************************************************************
 *  Compilation: Clock.java
 *
 *  Last modified:     4/29/2020
 **************************************************************************** */

public class Clock {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTE_PER_HOUR = 60;

    private int hour;
    private int minute;


    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h >= HOURS_PER_DAY)
            throw new IllegalArgumentException("hours must between 0 and 23");
        if (m < 0 || m >= MINUTE_PER_HOUR)
            throw new IllegalArgumentException("minutes must between 0 and 59");
        hour = h;
        minute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5)
            throw new IllegalArgumentException("Illegal Format");

        int h = Integer.parseInt(s.substring(0, 1)) * 10 + Integer.parseInt(s.substring(1, 2));
        int m = Integer.parseInt(s.substring(3, 4)) * 10 + Integer.parseInt(s.substring(4, 5));

        if (h / HOURS_PER_DAY != 0 || m / MINUTE_PER_HOUR != 0 || !s.substring(2, 3)
                                                                    .equals(":"))
            throw new IllegalArgumentException("Illegal Format");

        hour = h;
        minute = m;


    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        if (hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("hours must between 0 and 23");
        if (minute < 0 || minute >= MINUTE_PER_HOUR)
            throw new IllegalArgumentException("minutes must between 0 and 59");

        return Integer.toString(hour / 10) + Integer.toString(hour % 10) + ":"
                + Integer.toString(minute / 10) + Integer.toString(minute % 10);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour)
            return true;
        else if (hour == that.hour && minute < that.minute)
            return true;
        return false;
    }

    // Adds 1 minutes to the time on this clock.
    public void tic() {
        minute = minute + 1;
        if (minute == MINUTE_PER_HOUR) {
            hour = hour + 1;
            minute = 0;
        }
        if (hour == HOURS_PER_DAY)
            hour = 0;
    }

    // Adds ∆ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Illegal Format");

        hour = (hour + delta / MINUTE_PER_HOUR) % HOURS_PER_DAY;
        minute = minute + delta % MINUTE_PER_HOUR;
        if (minute >= MINUTE_PER_HOUR) {
            hour = hour + 1;
            minute = minute % MINUTE_PER_HOUR;
        }
        if (hour >= HOURS_PER_DAY)
            hour = hour % HOURS_PER_DAY;

    }

    // Test client.
    public static void main(String[] args) {
        int hour = StdRandom.uniform(24);
        int minute = StdRandom.uniform(60);
        Clock time1 = new Clock(hour, minute);
        StdOut.println("time1 is " + time1);

        String time = "23:59";
        Clock time2 = new Clock(time);
        StdOut.println("time2 is " + time2);

        time1.tic();
        time2.tic();
        StdOut.println("time1 now is " + time1 + " after one minute");
        StdOut.println("time2 now is " + time2 + " after one minute");

        int delta = StdRandom.uniform(1000);

        time1.toc(delta);
        time2.toc(delta);
        StdOut.println("time1 now is " + time1 + " after " + delta + " minutes");
        StdOut.println("time2 now is " + time2 + " after " + delta + " minutes");

        boolean isEarlier = time1.isEarlierThan(time2);
        if (isEarlier)
            StdOut.println("time1 is earlier than time2");
        else
            StdOut.println("time1 is later than time2");


    }
}
