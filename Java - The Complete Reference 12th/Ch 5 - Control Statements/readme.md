# Chapter 5 - Control Statements

Programming languages use control statemetns to cause the flow of execution to advance and branch based on changes to the state of a program. Java's program control statements can be put into the following categories: selection, iteration, and jump.

## Java's Selection Statements

Java supports two selection statements: `if` and `switch`. They allow you to drive execution based on the conditions at run time.

### if

The if statement is Java's conditional branch statement. It can be used to route program execution through two (or more) different paths

```java
if (condition) statement1;
else statement2;
```

Where condition is an expression that returns a boolean, and the else is optional.

[IfElse](code/IfElse.java)

### The Traditional Switch

The switch is Java's multiway branch statement, it provides an easy way to dispatch execution to different parts of your code based on the value of an expression. It can provide a better alternative to a large series of if - else if statements.

In JDK14 the switch statement was enhanced and expanded with new features that go beyond the traditional form. Here we will look only at the traditional one

```java
switch (expression) {
    case value1:
        // statements
        break;
    case value2:
        // statemenets
        break;
    case value3:
        // statements
        break;
    case valueN:
        // statements
        break;
    default:
        // default statement sequence
}
```

Prior to JDK 7 expression must resolve to byte, short, int, char or Enum. Today expression can also be of type String. Each case value must be a unique constant expression; like a literal value. Duplicate case values are not allowed. The type of each value must be compatible with the type of expression

The value of the expression is compared with each of the values in the case statements; if a match is found, the code sequence following the case is executed. If none match then we will get the default case. The break statement is used inside the switch to terminate a statement sequence, when break is encountered we break out of the entire switch statement. See [SampleSwitch](code/SampleSwitch.java). Sometimes we want to group case actions by omitting the break statement [MissingBreak](code/MissingBreak.java)

A more realistic usage of the switch with fall through is an improved version of the seasons program from before [Switch](code/Switch.java). We can also use a string to control the switch statement [StringSwitch](code/StringSwitch.java). Being able to use strings in a switch statement streamlines many situations, often its easier than using equal set of if/else statements.

#### Nested swtich
