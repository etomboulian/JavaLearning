### Keywords

https://docs.oracle.com/javase/specs/jls/se17/html/jls-3.html#jls-3.9

#### Java's Code Units

- Writing code is similar to writing a document. It consists of special hierarchical units, which together form a whole
  - Expression: An Expression computes to a single value
  - Statement: Statements are stand alone units of work
  - Code Blocks: A code block is a set of some statemtnst usually grouped together in some way to achieve a goal.

### Statements Whitespace and Indentation

- Whitespace is any extra spacing, horizontally or vertically , placed around Java source code.
- Usually for human readabiliy purpose
- All extra spaces are ignored by the compiler.

https://google.github.io/styleguide/javaguide.html#s4.6-whitespace

- Indentation does not matter to the compiler, only formatting for readability of code

### Code Blocks and If-Then-Else

- if statement

```
if (condition) {
    // code in this block will only ever execute if the cotition is true
}
```

- if else statement

```
if (condition) {
    // code in block will execute only if condition is true
} else {
    // code in block will execute only if condition is false
}
```

- if elseif else statement

```
if (condition) {
    // code in block will execute only if condition is true
} else if (secondCondition) {
    // code in block will execute if firstCondition is false and secondCondition is true
    // There can be any number of else if conditions
} else {
    // code in block will execute only if all other conditions are false
    // else must be last, but is optional
}
```

### Methods in Java

- A method declares executable code that can be invoked , passing a fixed number of values as arguments.

- We have been using the main method all along

#### Structure of the method

- Here is a simple method declaration

```
public static void methodName() {
    // statements which form the method body
}
```

- It has a name, methodName; but takes in no parameters and returns nothing as signified by the keyword void.

### Method Overloading

- Method overloading occurs when a class has multiple methods, with the same name, bu t the method are declared with different paramters.

  - So you can execute a method with one name, but call it with different arguments
  - Java can resolve which method it needs to execute, based on the arguments being passed, whent he method is invoked.

- A method signature consistas of the name of th method, and the uniqueness of the declaration of its paramters

  - A signature is unique not by the method name but in combination with the number of parameters the types and the order in which they are declared
  - A method's return type is not part of the signature
  - A parameter name is also not part of the signature.

- A unique methjod signature is the key for Java to be able to figure out which overload to call

#### Valid Overloaded method examples

```
public static void doSomething (int paramterA) {
    // body
}

public static void doSomething(float parameterA) {
    // body
}

public static void doSomething(int parameterA, int parameterB) {
    // body
}

public static void doSomething(float parameterA, int parameterB) {
    // body
}

public static void doSomething(int paramterA, int parameterB, float parameterC) {
    // body
}
```
