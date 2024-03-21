public class Main {

    public static void main(String[] args) {
        // statement (semi colon ends a statement
        int myVariable = 50;

        // more statements
        myVariable++;
        myVariable--;

        // yet another statement
        System.out.println("This is a test");

        // multi line statement
        System.out.println("This is" +
                " another" +
                " still more.");

        // multiple statements on one line (bad practice but allowed)
        int anotherVariable = 50; myVariable--; System.out.println("myVariable = " + myVariable);

        if (myVariable == 0) {
            System.out.println("It's now zero");
        }

    }
}
