public class CurrentTime {
    public static void main(String[] args) {
        
        // obtain the total milliseconds since Midnight, Jan 1 1970
        long totalMilliseconds = System.currentTimeMillis();

        // total seconds
        long totalSeconds = totalMilliseconds / 1000;

        // current second
        long currentSecond = (int) (totalSeconds % 60);

        // total minutes
        long totalMinutes = totalSeconds / 60;

        // current minute
        long currentMinute = (int) (totalMinutes % 60);

        long totalHours = totalMinutes / 60;

        long currentHour = (int) (totalHours % 24) + 19;

        System.out.println("Current time is " + currentHour + ":"
            + currentMinute + ":" + currentSecond + " CST");


    }
}
