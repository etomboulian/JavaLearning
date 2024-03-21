public class Main {
    public static void main(String[] args) {
        System.out.println("Printing the days of the week:");
        // print all the days of the week + 1
        for (int i = 0; i < 8; ++i) {
            printDayOfWeek(i);
        }
    }

    public static void printDayOfWeek(int day) {
        String dayOfTheWeek = switch(day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };

        System.out.println(day + " : " + dayOfTheWeek);
    }


}
