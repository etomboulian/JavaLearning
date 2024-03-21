public class SecondsAndMinutes {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println((getDurationString(-5)));
    }

    public static String getDurationString(int totalSeconds) {
        if (totalSeconds < 0) {
            return "totalSeconds=" + totalSeconds + " must be greater than or equal to 0";
        }
        int minutes = totalSeconds / 60;
        int hours = minutes / 60;

        int remainingMinutes = minutes % 60;
        int remainingSeconds = totalSeconds % 60;

        // int hours = totalSeconds / 3600; totalSeconds -= (hours * 3600);
        // int minutes = totalSeconds / 60; totalSeconds -= (minutes * 60);
        return hours + "h " + remainingMinutes + "m " + remainingSeconds + "s ";
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0) {
            return "Minutes must be greater than 0";
        }

        if (seconds < 0 || seconds > 60) {
            return "Seconds must be greater than 0 and less than 60";
        }

        int totalSeconds = (minutes * 60) + seconds;
        return getDurationString(totalSeconds);
    }

}
