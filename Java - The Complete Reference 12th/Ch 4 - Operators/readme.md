# Chapter 4: Operators

Java operators can be classed as one of

- arithmetic
- bitwise
- relational
- logical

Here we describe all of Java's operators except for the type comparison operator `instanceof` and the arrow operator `->`

## Arithmetic Operators

The following table lists the arithmetic operators.

| Operator | Result                         |
| -------- | ------------------------------ |
| +        | Addition (also unary plus)     |
| -        | Subtraction (also unary minus) |
| \*       | Multiplication                 |
| /        | Division                       |
| %        | Modulus                        |
| ++       | Increment                      |
| +=       | Addition Assignment            |
| -=       | Subtraction Assignment         |
| \*=      | Multiplication Assignment      |
| /=       | Division Assignment            |
| %=       | Modulus Assignment             |
| --       | Decrement                      |

The operands of the arithmetic operators must be of a numeric type. They cannot be used with booleans; but you can use them on char types since char is a subset of int

### The Basic Arithmetic Operators

The basic arithmetic operatror - addition, subtraction, multiplication and division - all behave as you would expect for numeric types. The unary minus negates its single operand. The unary plus operator simply returns the value of its operand. Recall that when the division operator is applied to int types there will be no fractional component attached to the result. See [BasicMath](code/BasicMath.java)

### The Modulus Operator

The modulus operator % returns the remainder of a division operation. It can be used with both integer types as well as floating point types. See [Modulus](code/Modulus.java)

### Arithmetic Compound Assignment Operators

Some operators can be used to combine an arithmetic operation with an assignment. We can rewrite the statement `a = a + 4` as `a += 4`. Using the += compound assignment operator enables us to shorten the code that we write. Another example might be to rewrite the expresssion `a = a % 2;` to `a %= 2;`. This code obtains the remainder of a/2 and stores the result in a. See [OpEquals](code/OpEquals.java)

### Increment and Decrement

The ++ and -- are Java's increment and decrement operators.

Increment Operator: `x = x + 1` -> `x++`

Decrement Operator: `x = x - 1` -> `x--`

These operators can be used in either prefix or postfix form, and it can create subtle differences when the inc/dec operator is used as part of an expression.

See [IncDec](code/IncDec.java)

### The Bitwise Operators

Java defines several bitwise operators that can be applied to the integer types; they act upon the indivisual bits of their operands

| Operator | Result                           |
| -------- | -------------------------------- |
| ~        | Bitwise unary NOT                |
| &        | Bitwise AND                      |
| \|       | Bitwise OR                       |
| ^        | Bitwise exclusive OR             |
| >>       | Shift right                      |
| >>>      | Shift right zero fill            |
| <<       | Shift left                       |
| &=       | Bitwise AND assignment           |
| \|=      | Bitwise OR assignment            |
| ^=       | Bitwise Exclusive OR assignment  |
| >>=      | Shift right assignment           |
| >>>=     | Shift right zero fill assignment |
| <<=      | Shift left assignment            |

All of the integer types are represented by binary numbers of varying bit widths. All of the integer types are signed integers which can represent both positive and negative numbers. Java uses an encoding called two's compliment, which means that the negative numbers are represented by inverting (all 1's to 0s and vice versa) all of the bits in a value and adding 1 to the result.

Example - byte 42 in bits is 00101010 (42) -> 11010110 (-42)

To decode a negative number, first invert all the bits, then add 1

Java uses two's complement to ensure that 0 and -0 are the same since mathematically they are and in doing twos complement -0 ends up being 1 beyond the range of the type, or all 0's or the same when viewed in the width of the type.

Because Java uses two's complement to store negative numbers, applying the bitwise operators can easily produce unexpected results. Turning on the high order bit will cause the resulting value to be interpreted as a negative number, intended or not.

### The Bitwise Logical Operators

The bitwise logical operators are & | ^ and ~. The bitwise operators are applied to each individual bit within each operand.

| A   | B   | A \| B | A & B | A^B | ~A  |
| --- | --- | ------ | ----- | --- | --- |
| 0   | 0   | 0      | 0     | 0   | 1   |
| 1   | 0   | 1      | 0     | 1   | 0   |
| 0   | 1   | 1      | 0     | 1   | 1   |
| 1   | 1   | 1      | 1     | 0   | 0   |

#### The Bitwise NOT

Also called the bitwise compliment, the unary NOT operator, ~, inverts all fo the bits of its operand. For example the number 42 which has the following bit pattern:

~00101010 = 11010101

#### The Bitwise AND

The And operator & produces a 1 bit if both operands are also 1, 0 in all other cases

Example: 00101010 (42) & 00001111 (15) = 00001010 (10)

#### The Bitwise OR

The OR operator combines bits such that if any bit is 1 then its a 1, only both 0's produces a 0

00101010 (42) | 00001111 (15) = 00101111 (47)

#### The Bitwise XOR

The XOR operator combines bits such that if exactly one operand is 1 then the result is 1; otherwise 0

00101010 (42) ^ 00001111 (15) = 00100101 (37)

#### Using the Bitwise Logical Operators

See [BitLogic](code/BitLogic.java)
