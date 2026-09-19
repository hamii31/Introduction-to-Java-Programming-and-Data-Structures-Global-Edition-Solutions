public class CurrentTimeInGMT { 
    public static void main (String[] args) {
        // Obtain total miliseconds since the UNIX epoc (January 1, 1970)
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds 
        long totalSeconds = totalMilliseconds / 1000;

        // Compute the current second as the remainder
        long currentSecond = totalSeconds % 60;

        // Get the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minutes
        long currentMinute = totalMinutes % 60;

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = totalHours % 60;

        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond);
    }
}
