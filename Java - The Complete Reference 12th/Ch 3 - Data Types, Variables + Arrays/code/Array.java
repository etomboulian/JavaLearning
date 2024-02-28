
public class Array {
    public static void main(String[] args) {
        int[] month_days;
        month_days = new int[12];

        month_days[0] = 31; // Jan
        month_days[1] = 28; // Feb
        month_days[2] = 31; // Mar
        month_days[3] = 30; // Apr
        month_days[4] = 31; // May
        month_days[5] = 30; // June
        month_days[6] = 31; // Jul
        month_days[7] = 31; // Aug
        month_days[8] = 30; // Sept
        month_days[9] = 31; // Oct
        month_days[10] = 30;// Nov
        month_days[11] = 31;// Dec

        System.out.println("April has " + month_days[3] + " days.");
    }
}
