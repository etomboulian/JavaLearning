public class Main {
    public static void main(String[] args) {
        // Using standard string concatenation method
        String bulletIt = "Print a Bulleted List:%n" +
                "\t\u2022 First Point%n" +
                "\t\t\u2022 Second Point";
        System.out.println(bulletIt);

        // Using the JDK15 textBlock feature (""" text """)
        String textBlock = """
                Print a Bulleted List: 
                        \u2022 First Point
                            \u2022 Sub Point""";
        System.out.println(textBlock);

        // Using printf to format a string
        int age = 35;
        System.out.printf("Your age is %f%n", age);

        int yearOfBirth = 2024 - age;
        System.out.printf("Age = %d, Birth year = %d", age, yearOfBirth);


    }
}
