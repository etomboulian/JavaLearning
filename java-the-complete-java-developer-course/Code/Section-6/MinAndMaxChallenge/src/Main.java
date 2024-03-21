import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasInputChar = false;
        int loopCount = 0;

        double minNumber = 0;
        double maxNumber = 0;

        while(!hasInputChar) {
            System.out.println("Please enter a number, or any character to quit.");
            String numberInput = scanner.nextLine();
            try {
                double number = Double.parseDouble(numberInput);
                if (loopCount == 0 || number < minNumber) {
                    minNumber = number;
                }
                if (loopCount == 0 || number > maxNumber) {
                    maxNumber = number;
                }
                loopCount++;
            }  catch (NumberFormatException nfe) {
                hasInputChar = true;
            }
        }

        if (loopCount > 0) {
            System.out.println("Max entered: " + maxNumber);
            System.out.println("Min entered: " + minNumber);
        } else {
            System.out.println("No valid data entered");
        }
    }
}
