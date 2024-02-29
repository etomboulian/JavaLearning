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

Where condition is an expression that returns a boolean, and the else is optional. If `condition` is true then statement1 is executed; otherwise statement2 is executed. One of the statements is guaratueed to execute.

#### Nested ifs

A nested if is an if statemetn that is the target of another if or else. With nested ifs, the main thing to recall is that an else statement always refers to the nearest if statement that is within the same block as the else and that is not already assicated with an else

```java
if(i == 10) {
    if(j < 20) a = b;
    if(k > 100) c = d;  // this if
    else a = c;         // goes with this else
}
else a = d;             // this else refers to the top level if
```

#### The if-else-if Ladder

The if statements are executed from the top down, as soon as one condition controlling the if is true, then that statement is executed and the rest is bypassed. If no condition is true then the statements in the else will be executed. Else acts as a default condition.

```java
if(condition) statement;
else if (condition) statement;
else if (condition) statement;
else statement;
```

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

A switch can be used as part of the staetment sequence of an outer switch, this is called a nested swtich. Cases are evaluated in the inner switch independantly of the outer switch.

```java
switch(count) {
    case 1:
        switch(target) {
            case 0:
                System.out.println("target is a zero");
                break;
            case 1:
                System.out.println("target is one");
                break;
        }
        break;
    case 2:
        /// more code
}
```

When the compiler copiles a switch statement it will inspect each of the case constratins and create a "jump table" that it will use for selecting the path of execution. Thus if you need to select among a large group of values a switch statement will run much faster than the equivalent logic coded using a sequence of if-elses. We can do this because the compiler knows the case constraints are all the same type and must only be compared for equality.

### Iteration Statements

Java's iteration statements are for, while and do-while. These create what we call loops. A loop repeatedly executes a block of code until a termination condition is met.

#### while

The while loop will repeat a block of code while its controlling expression is true

```java
while(condition) {
    // body of loop
}
```

The condition can be any boolean expression. The body of the loop is executed until the condition evaluates to false. See [While](code/While.java) Since the while loop evaluates its conditional expression at the top of the loop the body of the loop will not execute eve once if the condition is false to begin with. The body of the while can be empty; since a null statement is syntactically valid in Java. See [NoBody](code/NoBody.java)

#### do-while

The do-while loop always executes its body at least once, because its condition al expression is at the bottom of the loop. Each iteration of the loop first executes the body of the loop and then evaluates the conditional expression.

```java
do {
    // body of loop
} while (condition);
```

See [DoWhile](code/DoWhile.java) for a reworked example of the "tick" program. The do-while loop pattern is especially useful when you process a menu selection, because you usually wantt he body of a menu loop to execute at least once. See [Menu](code/Menu.java) for an example of a help system using Java's selection and iteration statments. In this program the do-while loop exists to ensure that the user makes a valid choice, then that choice is used in the switch statement to determine the path of execution. Because System.in.read() is being used, the program must specify the throws java.io.IOException clause which is necessary to handle input errors.

#### for

There are two types of for loops; the traditional form and the for-each form that is added in JDK5. We discuss both types of loops here.

Generalized for statement:

```java
for(initialization; condition; iteration) {
    // body
}
```

When the loop first starts the initialization portion of the loop is executed, usually this sets the loop control variable, which acts as a counter that controls the loop. The initialization expression is executed only once. Next, the condition boolean expression is evaluated; if it is true then the body of the loop is executed, otherwise the loop terminates. Next the iteration part of for statement is executed, and the control variable is tested in the condition to determine if the loop should run again or not.

See [ForTick](code/ForTick.java) for an example of the tick program that uses a for loop.

##### Declaring Loop control Variables Inside the for loop

Often the variable that controls the for loop is needed only for the purpose of the loop and not elsewhere; in this case we can declare the iteration variable within the initialization of the for loop. Here is the for tick program rewritten to do this. When you declare the variable inside the for loop then the scope of that variable ends when teh for statement does. In otherwords the iteration variable is not accessible once the loop terminates, however it would be if it were declared outside of the loop. See [FindPrime](code/FindPrime.java)

```java
class ForTick {
    public static void main(String[] args) {
        for(int n = 10; n > 0; --n) {
            System.out.println("tick " + n);
        }
    }
}
```

##### Using the comma

Sometimes hwen you want to include more than one statemtne in the initialization and iteration portions of the for loop for example. Java permits us to include multiple statements in both the initialization and iteration portions of the for. In this program we set the value of both a and b within the initialization section of the loop using the comma:

```java
class Sample {
    public static void main(String[] args) {
        int a, b;
        for(a=1, b=4; a < b; a++) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            b--;
        }
    }
}
```

##### Some for Loop Variations

The for loop supports a number of variations. The condition controlling the for can be any Boolean expression; for example we can use a flag to control the continuation of the for loop as in the following

```java
boolean done = false;

for(int i = 1; !done; i++) {
    // ...
    if(interrupted()) done = true;
}
```

Another variation: neither the initialization nor the iteration expression require statements

```java
class ForVar {
    public static void main(String[] args) {
        int i;
        boolean done = false;

        i = 0;
        for( ;!done; ) {
            System.out.println("i is " + i);
            if(i == 10) done = true;
            i++;
        }
    }
}
```

Here the initialization and iteration expressions have been moved outside the for. This can be helpful when a complex initialization happens before the loop starts, leaving the intialization condition blank. You can also leave every part of the for loop blank to create an infinite loop.

```java
for( ; ; ;) {
    // ...
}
```

Sometimes we require infinite loops for cases like awaiting os commands, we usually will terminate an infinite loop upon reaching a special condition, and we can force the code to break out of the infinite loop using the `break` keyword.

#### The For-Each version of the For Loop

A second form of the for loop implements a for-each style loop, designed to cycle through a collection of objects, such as an array, in strictly sequential fashion from start to finish. In Java we can refer to this as the enhanced for loop. The general form of the enhanced for loop is:

```java
for(type itr-var: collection) statement-block
```

Here type and itr-var specify the variable that will receive elements from the collection one by one. Various types of collections can be used with the for-each loop, but here we will only use Arrays since they are the only collection type that we have seen so far. Because the iteration variable receives values from the collection, type must be the same or compatible with the elements stored in the collection. Here is a code fragment that uses the for-each loop to iterate through the elements of an array.

```java
int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int sum = 0;

for(int x: nums) sum += x;
```

See [ForEach](code/ForEach.java) for a whole program that demos this concept.

Although the for-each loop iterates until all elements have been examined, we can terminate the loop early using a break statement. For example, this program [ForEach2](code/ForEach2.java) sums only the first five elements of nums. The for-each loop's iteration variable is read-only as it relates to the underlying array; you cannot change the contents of the array by assigning to the iteration variable a new value. See [NoChange](code/NoChange.java) for an example of this.

##### Iterating Over Multidimensional Arrays

The enhanced for loop also works on multidimensional arrays. This is important when iterating over a multidimensional array because each iteration obtains the next array, rather than an individual element. Also the iteration variable must be of a type that is compatible with the element extracted. In general when using the for-each for to iterate over an array of N dimesions, the objects obtained will be arrays of N-1 dimensions. See [ForEach3](code/ForEach3.java) for an example of this using a two dimensional array. Notice that in the inner for-each we declare an iteration variable of a 1 dimensional array of ints to receive each "row" in our 2d array. The inner for-each loop cycles through this array producing each individual element.

##### Applying the Enhanced For

One of the most common uses of the enhanced for loop is searching. See [Search](code/Search.java) for an example to search an unsorted array for a value. It stops when the value is found. The for-each style for works in this case because searching an unsorted array involves inspecting each element of the array. If the array were sorted we could use a more advanced search such as the binary search to find more efficiently.

The enhanced for loop is useful for cycling through elements of the built in collection types. More generally the for can cycle through the elements of any collection of objects, as long as that collection satisifies a certain set of constraints.

##### Local Variable Type Inference in a for Loop

JDK10 introduced a feature called local variable type inference which allows th type of a local variable to be inferred from th etype of its initializer. Local variable type inference can be used in a for loop when declaring and initializing the loop control variable inside a traditional for loop, or when specifying the iteration variable in a for-each for. See [TypeInferenceInFor](code/TypeInferenceInFor.java) for an example showing each case.

In the example the loop control variable x is inferred to be type double since it is the type of the initializer. Iteration variable v is inferred to be of type int because that is the element type of the arry nums.

#### Nested Loops

Java allows loops to be nested. See [Nested](code/Nested.java) for an example that nests `for` loops.

## Jump Statements

Java supports three jump statements: break, continue, and return. These statements will transfer control to another part of your program. Note that another way to transfer control in your program is through the use of exception handling, but we will examine that later on.

### Using break

The `break` statement has 3 uses.

- Terminating a statement sequence in a switch
- Exiting a loop
- A "civilized" form of the goto statement

#### Using Break to Exit a Loop

Using `break` you can force the immediate termination of a loop, bypassing the conditional expression and any remaining code in the body of the loop. When a break statement is encountered inside a loop, the lloop is terminated and program control resumes at the next statement following the loop. See [BreakLoop](code/BreakLoop.java) for a simple example of this. Although the for loop is designed to run from 0 to 99, the break statement causes it to terminate early at 10.

The `break` statement can be used with any of Java's loops including intentionally infinite loops. See [BreakLoop2](code/BreakLoop2.java) for an example of the same using a while loop. When used inside a set of nested loops the `break` statement will only break out of the innermost loop, see [BreakLoop3](code/BreakLoop3.java) for an example of this. As you can see the break only terminates the inner loop, and the outer loop is unaffected.

Two more things to remember about break. First more than one break can appear in a loop. Second the break taht terminates a switch statement affects only that switch statement and not any enclosing loops.

#### Using break as a Form of Goto

Java does not have a goto statement because it provides a way to branch in arbitrary and unstructured ways. This makes code with lots of use of goto very hard to understand and maintain. There are however a few places where this behaviour is desired; for example exiting from a set of deeply nested loops. To handle this Java defines an expanded form of the break statement. This form of break allows you to break out of one or more blocks of code.

The general form of the labelled `break` statement is `break label`; where label is the name of a label that identifies a block of code. The labelled block must enclose the break statement. See [Break](code/Break.java) for an example of this usage. Or we can use it to break from a set of deeply nested loops [BreakLoop4](code/BreakLoop4.java). When the inner loop breaks to the outer loop, both loops have been terminated. Note that the example labels the for statement which has a block of code as its target. You cannot break to a label that is not an enclosing block.

See [BreakErr](code/BreakErr.java) for an invalid usage which will not compile. Since the label one does not enclose the break staement, it is not possible to transfer control in this way.

### Using continue

Sometimes it is useful to force an early iteration of a loop, the continue statement does this. A continue statement causes control to be transferred directly to the contditional expression that controls the loop. See [Continue](code/Continue.java) for an example that uses continue to cause two number to be printed on each line. This code uses the % operator to check if i is even, if it is then the loop continues without printing a newline. As with Break, continue can also specify a label to describe which enclosing loop to continue. See [ContinueLabel](code/ContinueLabel.java) for a program that uses continue to print a triangular multiplication table for 0 - 9. Good uses of continue are rare, but the continue statement provides a structured way to do this when necessary

#### return

The return statement is used to explicitly return from a method. It causes the program control to tranfer back to the caller of the method. As such it is a type of jump statement. See [Return](code/Return.java) for an example that uses return to cause execution to return to the Java runtime system; since the runtime system is what calls main()
