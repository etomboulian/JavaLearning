public class Challenge {
    public static void main(String[] args)
    {
        double firstDouble = 20.00d;
        double secondDouble = 80.00d;

        double result = (firstDouble + secondDouble) * 100.00d;
        double remainder = result % 40.00d;
        System.out.println("Remainder = " + remainder);
        boolean noRemainder = (remainder == 0);

        if (!noRemainder) {
            System.out.println("Got some remainder");
        }
    }

}
