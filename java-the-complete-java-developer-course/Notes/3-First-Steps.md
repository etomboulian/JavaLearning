### Wrapper CLasses

- Only the wrapper classes for int and char differ from the capitalized primitive type name

| Primitive | Wrapper Class |
| --------- | ------------- |
| byte      | Byte          |
| short     | Short         |
| char      | Character     |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| boolean   | Boolean       |

### Integer Wrapper Class

Integer Max and Min values are stored on the wrapper class:

Integer.MIN_VALUE and Integer.MAX_VALUE;

`System.out.print("Busted Max value = " + (Integer.MAX_VALUE + 1))` -- overflows

- Overflowing the max value wraps around to the minimum value and keeps on going
- Underflowing the min value wraps around to the maximum value and keeps on going

- Java compiler will notice if we assign a literal value that is outside the allowed range of the type

```
jshell> int myMaxIntTest = 2147483648;
|  Error:
|  integer number too large
|  int myMaxIntTest = 2147483648;
```

### Byte, Short, Long

| Data Type | Wrapper Class | Range                                       | Bit Width |
| --------- | ------------- | ------------------------------------------- | --------- |
| byte      | Byte          | -128 to 127                                 | 8         |
| short     | Short         | -32768 to 32767                             | 16        |
| int       | Integer       | -2147483648 to 2147483647                   | 32        |
| long      | Long          | -9223372036854775808 to 9223372036854775807 | 64        |

##### Long literal

```
jshell> long myLong = 100L;
myLong ==> 100
```

### Casting in Java

- Casting means to treat or covnver a number, from one type to another
  - `(byte) (myMinByteValue / 2);`

### Floating point and Decimal Numbers

- Floating point or real numbers
- use data types `float` or `double`
- Float
  -Range: 1.4E-45 to 3.4028235E38
  - 32 bits store float
- Double

  - Range: 4.9E-324 to 1.7976931348623157E308
  - 64 bits store a double

- Double can represent a much smaller and larger decmimal value and for this reason is referred to as being more precise.
- The double data tyhpe is Java's default type for real numbers (ie 10.5 literal is a double)
- Double literals can be a numeric literal with d or D appended, but this is optional since that is the default
- Float literals must be a numeric literal with an f or an F appended in order to specify that it is a float literal

```
jshell> float myOtherFloatValue = 5.25;
|  Error:
|  incompatible types: possible lossy conversion from double to float
|  float myOtherFloatValue = 5.25;
|                            ^--^

jshell> float myOtherFloatValue = (float)5.25;
myOtherFloatValue ==> 5.25

jshell> float myOtherFloatValue = 5.25f;
myOtherFloatValue ==> 5.25
```

- Real numbers can be expressed in scientific notation
- Floats are not recommended to use much these days (since we are not so memory constrained)

### Floating Point Precision + Challenge

Ints

```
jshell> int myIntValue = 5/2;
myIntValue ==> 2
```

Floats

```
jshell> float myFloatValue = 5f/2f;
myFloatValue ==> 2.5
```

Doubles

```
jshell> double myDoubleValue = 5d/2d;
myDoubleValue ==> 2.5
```

```
jshell> myFloatValue = 5f/3f;
myFloatValue ==> 1.6666666

jshell> myDoubleValue = 5d/3d;
myDoubleValue ==> 1.6666666666666667
```

#### Why is the double better is most cases?

- Its actually faster to process on many modern computers
- Java libraries are written to process doubles in most cases and to return results as doubles
- The creators of Java selected the double because its more precise and can handle a larger range of numbers

Challenge: Create a variable to hold pounds, calculate kilograms and store in second variable, print result

- In general fload and double are good for general floating point operations
- Neither should be used when precise calculations are required (because of how floating point numbers are stored)
- Java has a class called BigDecimal that overcomes this

### Char and Boolean primitives

- char specifies a variable to hold a single character
- Literal enclosed in single quotes `'a'`
- chars are less relevant today than when Java was first created
- A char occupies two bytes of memory or 16 bits
- a char is stored as a two byte number, similar to the short (which gets mapped to a single character in Java)

- 3 ways to store a char
  - a literal character (`char myChar = 'D';`)
  - a Unicode value (`char myChar = '\u0044';`)
  - an integer value (`char myChar = 68;`)

### String Data Type

- A string is a sequence of characters

```
jshell> {
   ...>     String numberString = "250.55";
   ...>     numberString = numberString + "49.45";
   ...>     System.out.print(numberString);
   ...> }
250.5549.45
```

#### String concatenation

- In Java the + symbol is an operator
  - If used with numbers it means addition
  - If used with strings it means concatenation

#### Strings are immutable

- Immutable means that you cannot change a String after it is created.
- So in the case of concatenation, the second string is technically not appended to the contents of the first
- Instead a new string is created from both and the original is discarded.
- Since appending to a string creates a whole new string it is inefficient if you do it a lot

#### String vs StringBuilder

- String class is immutable but it can be used like a primitive data type
- StringBuilder class is mutable but does not share the String's special features such as being able to assign it a string literal or to use the + operator on it
- Both as classes but the String class is in a special category in the Java language

### Operators, Operands and Expressions

#### What are Opeators

- Operators in Java are special symbols that perform specific operations on one, two or three operands, and then return a result
- Example showing usage of + and _ operators
  `long longTotal = 50000L + 10L _ (byteValue + shortValue + intValue)`

#### What is an Operand

- Operand is used to describve any object that is manipulated by an operator
- So if we consider this:
  `int myVar = 15 + 12;`
- The + is the operator and 15 and 12 are operands.
- Variables can also be operands

#### What is an Expression

- An Expression is formed by combining varabiles, literals, and method return values, and operators
- They are a way of forming and combining those values to produce a result
  `int myVar = 15 + 12`
- Here 15 plus 12 is the expression which returns avalue of 27

#### The + Operator on char

- chars are stored as 2 byte numbers in memor
- When the + operator is used on chars it is these numbers in memory that get added together
- The character values are not concatenated (like would with strings)

```
jshell> char firstChar = 'A'; char secondChar = 'B';
jshell> System.out.print(firstChar + secondChar);
131
jshell> System.out.print("" + firstChar + secondChar);      // coerce to string to force concatenation
AB
```

#### The remainder Operator

- The remainder operator is represented in Java by the %
- The remainder operator can also be called modulus, modulo or just mod
- The remainder operator returns the remaining value from a division operatorion
- If there is no remainder then the result is 0; eg: `10 % 3 = 1`

```
jshell> result = 5;
result ==> 5

jshell> result = result % 3;
result ==> 2
```

### Abbreviation Operators

```
jshell> {
   ...>     int result = 1;
   ...>     result = result + 1;                    // Long form
   ...>     System.out.print("result = " + result);
   ...> }
result = 2
jshell>
```

```
jshell> {
   ...>     int result = 1;
   ...>     result++;                               // Abbreviated using the postfix increment op
   ...>     System.out.print("result = " + result);
   ...> }
result = 2
```

- When using the += or -= operators with different data types, then an implicit data conversion happens.
- x -= y
  is really
- x = (data type of x) (x - y)

#### Abbreviating operator summary

| Shorthand Operator                 | Code Sample  |
| ---------------------------------- | ------------ |
| Postfix Increment Operator         | result++;    |
| Post-fix Decrement Operator        | result--;    |
| Addition Compound Assignment       | result += 5; |
| Subtraction Compound Assignment    | result -=5;  |
| Multiplication Compound Assignment | result \*=5; |
| Division Compound Assignment       | result \=5;  |
