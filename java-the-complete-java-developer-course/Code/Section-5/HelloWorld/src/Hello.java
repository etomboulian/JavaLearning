public class Hello {

    public static void main(String[] args) {
        // Simple print statement
        System.out.println("Hello, Evan");

        // Demonstrating an if then statement and conditional logic
        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an alien!");
            System.out.println("And I am scared of aliens");
        }

        // Using logical operator to determine a condition for a code block.
        int topScore = 80;
        if(topScore >= 100) {
            System.out.println("You got the high score!");
        }

        // Using the logical AND operator (&&) both conditions must be true in order to execute the code block
        // True and True = True
        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Greater than second top score and less than 100");

        }

        // Using the logical OR operator (||) only one condition must be true in order to execute the code block
        // False OR True = True
        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true");
        }

        // Mistakenly using the assignment operator instead of equals to in this case is an error
        int newValue = 50;
        if (newValue == 50) {
            System.out.println("This is an error");
        }

        // Mistakenly using the assignment operator instead of equals to in this case is NOT an error (because it is a boolean) so
        // So it works, but it doesn't do what we want it to do therefore it is a bug.
        // This will always be True
        boolean isCar = false;
        if (isCar = true) {
            System.out.println("This is not supposed to happen");
        }

        // Demo using the conditional operator
        String makeOfCar = "Volkswagens";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if (isDomestic) {
            System.out.println("This car is domestic to our country");
        }

        String s = (isDomestic) ? "This car is domestic": "This car is not domestic";
        System.out.println(s);

        // Goto: Challenge Class for result of Operator Precedence challenge

    }
}
