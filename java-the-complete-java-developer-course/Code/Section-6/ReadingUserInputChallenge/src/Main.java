import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int validCount = 1;
        double numberSum = 0;
        do {
            System.out.println("Enter number #" + validCount + ":");
            String input = scanner.nextLine();
            try {
                double numberInput = Double.parseDouble(input);
                numberSum += numberInput;
                validCount++;
            } catch (NumberFormatException e) {
                System.out.println("Error not a valid integer, try again");
            }

        } while (validCount <= 5);

        System.out.println("The total was " + numberSum);
    }
}
