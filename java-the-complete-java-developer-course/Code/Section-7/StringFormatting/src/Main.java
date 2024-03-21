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

        // Using printf to format a string, use the format specifier
        // %d - decimal number | %f - float number | %n - newline
        int age = 35;
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = 2024 - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);

        System.out.printf("Your age is %.2f%n", (float) age);

        // left aligned
        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing %d %n", i);
        }

        // right aligned
        for (int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }

        // Formatting using String.format static method
        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        // Formatting using the formatted instance method
        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);


    }
}
