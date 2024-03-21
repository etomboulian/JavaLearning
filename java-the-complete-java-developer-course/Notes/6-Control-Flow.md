### Control Flow Intro

- Looking at switch and for; while and do while loops

#### The Switch Statement

- Valid switch types: byte, short, int, char, String, enum
- Cannot use long, float or double -> will result in an error (must use integral types)

- Must include break after each case or else we will get fallthrough (it will execute each case below the matching one)

```
public class Main {
    public static void main(String[] args) {
        int value = 1;
        switch (value) {
            case 1:
                System.out.println("Value was 1);
                break;
            case 2:
                System.out.println("Value was 2);
                break;
            case 3: case 4: case 5:
                System.out.println("Was a 3, 4 or 5);
                System.out.println("Actually was a " + value);
            default:
                System.out.println("Was not 1 or 2, 3 , 4, or 5);
        }
    }
}
```

#### More switch statement

- Explore some new features of switch statement

- Enhanced Switch Statement syntax:

```
switch (value) {
    case 1 -> System.out.println("Value was 1);
    case 2 -> System.out.println("Value was 2);
    case 3,4,5 -> {
        System.out.println("Was a 3, 4 or 5");
        System.out.println("Actually was a " + value);
    }
    default -> System.out.println("Was not 1, 2, 3, 4, or 5");
}
```

- Fall through does not happen so there is no need to include the break keywords
- Not backwards compatible with code before Java 14

- Can use return instead of breaks

```
public static String getQuarter(String month) {
    switch (month) {
        case "JANUARY":
        case "FEBRUARY":
        case "MARCH":
            return 1;
        case "APRIL":
        case "MAY":
        case "JUNE":
            return 2;
        case "JULY":
        case "AUGUST":
        case "SEPTEMBER":
            return 3;
        case "OCTOBER":
        case "NOVEMBER":
        case "DECEMBER":
            return 4;
        default:
            return "bad";
    }
}
```

upgrade to enhanced switch

```
public static String getQuarter(String month) {
    return switch(month) {
        case "JANUARY", "FEBRUARY","MARCH" -> {yield "1st";}
        case "APRIL", "MAY", "JUNE" -> "2nd";
        case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
        case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
        default -> {
            String badResponse = month + "is Bad";
            yield badResponse
        }
    }
}
```

- If switch results in a single value then you don't neeed a code block
- If you use a code block you must use yield to tell what to return from that case
- yield keyword added for returning something from a multi line default case in the enhanced switch statement.

#### The FOR statement

- Looping: enables us to execute blocks of code multiple times
- Java supports several constructs that enable us to do this

- Loops

  - for: used when you are iterating over a set of values
  - while: executes until a condition becomes true or false
  - do-while: execute once, and then exit like a while loop

- Example for loop

```
for (init; expression; increment) {
    // code block
}
```

- The initialization section declares the iteration variable and the start position
- The loop will exit when the expression becomes false

#### The break statement

- A break statement transfers control out of an enclosing statement

#### The FOR Statement Challenge

- See ThePrimeNumberChallenge Project

#### The while Loop

- 2 forms while loop and do while loop

## Parsing Values and Reading input using System.console()

When reading data in, either from a file or from user input, it is common for the data to be initially a String, which we'll need to convert to an numeric value. Additionally the only operator that will work with the class String is the +.

Exercise [ReadingUserInput](../Code/Section-6/ReadingUserInput/)

Reading data from the console:

System.in

- Like System.out, Java provides System.in
- which can read user input from the console or terminal.
- Its not easy to use and lots of code has been built around it to make things easier

System.console

- This is Java's solution for easier support for reading a single line and prompting user for information
- Although it is easy to use it doesn't work with IDE's as they disable it.

Command Line Arguments

- Calling the Java program and specifying the data in the call.
- Used commonly but doesn't allow us to create an interactive application

Scanner

- Scanner class was built to be a common way to read input either from System.in or from a file
- For beginners its much easier to understand than System.in

# Catching and Handling Exceptions

An exception is an error that happens in code.

An exception is caught, first by creating a code block around the code, that might get the error. This is done with the try statement code block

```java
try {
    // statements that might get errors
} catch(Exception e) {
    // code to handle exception
}
```
