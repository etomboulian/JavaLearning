# Chapter 4 - Methods and Classes

We continue our discussion of methods and classes from Chapter 6, we look at topics relating to methods such as overloading, parameter passing and recursion. We then discuss access control, the use of static and the built in class String.

## Overloading Methods

In Java we can define two or more methods within the same class that share the same name as long as their parameter declarations are different. When this is the case the methods are said to be overloading, and this is called method overloading and is one of the ways that Java supports polymorphism.

When an overloaded method is invoked Java uses the type and number of arugments to figure out which version of the overloaded method to actually call. [OverloadDemo](code/OverloadDemo.java)

Since Overload Demo does not define test(int), when test() is called with an integer agument inside Overlaod, no matching method is found. However, Java can automatically convert an integer to a double, and this conversion can be used to resolve the call. If test(int) had been defined, it would have been called instead. Java will employ an automatic type conversion only if no exact match is found.

The value of overloading is that it allows related methods to be accessed by use of a common name. Thus the name abs() represents the general action that is being performed. It is left to the compiler to choose the right specific version for a particular circumstance.

### Overloading Constructors

Similar to methods you can also overload constructor methods. Overloaded constructors are very common. Lets recall the example Box class

```java
class Box {
    double width;
    double height;
    double depth;

    // Box constructor
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // compute and return volume
    double volume() {
        return width * height * depth;
    }
}
```

The Box ctor requires 3 parameters. This means that all declarations of Box objects must pass three ags to the Box ctor. So the following is now invalid `Box ob = new Box();` since Box() requires 3 args.

We can oveload the Box ctor so as to allow this. See [OverloadCons](code/OverloadCons.java). We can see from the results that the proper overloaded ctor is called based upon the arguments specified when new is executed.

## Using Objects as Paramaters

So far we have only used primitive types as parameters, but it is common to pass objects to methods also. Consider [PassOb](code/PassOb.java). The equalTo() method inside Test compares two objects for equality and returns the result. It compares the invoking object with the one that is passed and returns true if all properties are the same, and false otherwise.

Frequently you will want to construct a new object so that it is initiall the same as some existing object. To do this we define a ctor that takes an object of its class as a parameter. For example this version [OverloadCons2](code/OverloadCons2.java) of Box allows one object to initialize another.

Providing many forms of ctors is usually required to allow objects to be constructed in a convenient and effienient manner.

## A Closer Look at Argument Passing

In general there are two ways that a programming language can pass an argument to a subroutine. The first way is _call-by-value_. This approach copies the value of an argument into the formal parameter of the subroutine. Changes made to the parameter of the subroutine have no effect on the argument.

The second way that an argument can be passed is _call-by-reference_. In this approach a reference to the argument is passed to the parameter; within the subroutine, this reference is used to access the actual argument. This means that changes made to the parameter will affect the argument used to call the subroutine.

Although Java uses call-by-value to pass all arguments, the precise effect differs between whether a primitive type or a reference type is passed.

When you pass a primitive type to a method, it is passed by value. A copy of the argumetn is made, and what occurs to the parameter that receives the argument has no effect outside the method. Consider the following program [CallByValue](code/CallByValue.java). As you can see the operations that occur inside meth() have no effect on the values of a and b used in the call.

When you pass an object to a method, the situation changes, because objects exhibit call-by-reference behaviour. When you create a variable of a class type, you are only creating a reference ot an object. When you pass this reference to a method, the parameter that receives it will refer to the same object as that referred to by the object. Consider the following program [PassObjRef](code/PassObjRef.java) as you can see the actions inside meth() have affected the object used as an argument.

REMEMBER: When an object reference is passed to a method, the reference itself is passed by use of call-by-value. However, since the value being passed refers to an object, the copy of that value (the memory address) will still refer to the same object that is corresponding argument does

## Returning Objects

A method can return any type of data, including class types that you create. In the following program [RetOb](code/RetOb.java) the incrByTe() method returns an object in which the value of a is ten greater than it is in the invoking object

Each time incrByTen() is invoked, a new object is created and a reference to it is returned to the calling routine.

Since all objects are dynamically allocated using new, you don't need to worry about an object going out-of-scope because the method in which is was created terminates. The object will continue to exist as long as there is a reference to it somewhere in your program. When there are no references to it, the object will be reclaimed the next time garbage collection takes place.

## Recursion

Java supports Recursion. Recursion is the process of defining something in terms of itself. A method that calls itself is said to be recursive. The classic example is the computation of the factorial of a number. [Factorial](code/Factorial.java)

When fact() is called with an argument of 1, the function returns 1; otherwise it returns the result of `fact(n-1) * n`. This process repeats until equals 1 and the calls to the fact() method start returning.

See [Recursion2](code/Recursion2.java) for an example of printing an array recursively.

## Introducing Access Control

Encapsulation links data with the code that manipulates it. Access control is an important concept to understand to enforce encapsulation effectively. By controlling access, you can prevent misuse.

How a member can be accessed is determined by the access modifier attached to its declaration. Java supplies a rich set of access modifiers; public, private and protected.

When a member of a class is modified by `public`, then that member can be accessed by any other code. When a member of a class is modified by `private`, then that member can only be accessed by other members of the class. Now we can see why main() is always declared as `public` because it needs to be called from outside the class (by the Java runtime system).

So far we have only used the default access mode. See [AccessTest](code/AccessTest.java) for an example using acceess modifiers. In Test a uses default access, which in this example is the same as public. b is set as public, and member c is given private access; therefore c cannot be used directly, it must be accessed through its public methods setc() and getc()

Another example considers an improved version of the [Stack](code/Stack.java). Now both stck and tos are specified as private, which means we can only modify them through calls to push() and pop().

## Understanding static

Sometimes we need to define a class member that wil be used independently of any object of that class. It is possible to define a member that can be used by itself without a reference to a specific instance. To create such a member preceed its declaration with the keyword `static`. When a member is declared as static it can be accessed before any objects of its class are created, and without reference to any object.

The most common example of a static member is main(). main() is declared as static because it must be called before any objects exist. Instance variables declared as static are essentialy global variables. All instances of the class share the same static variables

Methods declared as static

- can only directly call other static methods of their class
- can only directly access static variables of the class
- cannot refer to this or super in any way.

If you need to do computation in order to initialize a static variable, you can declare a static block that gets executed exactly once when the class is first loaded. [UseStatic](code/UseStatic.java) shows an example. As soon as the UseStatic class is loaded, all of the static statements are run.

Outside the class in which they are defined static members can be called using the following syntax `classname.method()`. Another example [StaticDemo](code/StaticDemo.java); where callme and static variable b are accessed through their classname StaticDemo.

## Introducing final

A field can be declared as final. Doing so prevents its contents from being modified, making it a constant. You must initialize a final field when it is declared. This can be done in one of two ways.

1. Give it a value when it is declared  
   -or-
2. Assign it a value within a constructor

```java
final int FILE_NEW = 1;
final int FILE_OPEN = 2;
final int FILE_SAVE = 3;
final int FILE_SAVEAS = 4;
final int FILE_QUIT = 5;
```

Subsequent parts of the program can now use FILE_OPEN as if they were constants without worry that the value will change. Constants are typed in all uppercase as in the example.

In addition to fields both method parameters and local variables can be declared `final`. Declaring a parameter `final` prevents it from being changed within the method. Declaring a local variable `final` prevents it from being assigned a value more than once. We will look at the use of `final` with methods when we look at inheritance.

## Arrays revisited

Arrays are implemented as objects. Because of this arrays have an attribute called length, which will always hold the size of the array. Here an example demonstrating this [Length](code/Length.java). Each array tracks and can show its own length. Length doesn't have to do with the number of elements in use, only the number of elements it can hold. [TestStack](code/TestStack.java)

## Introducing Nested and Inner Classes

It is possible to define a class within another class; such classes are known as nested classes. The scope of a nested class is bounded by the scope of its enclosing class. If class B is defined within class A, then B does not exist independently of A. A nested class has access to the members, including private members of the class in which it is nested. However the enclosing class does not have access to the members of the nested class.

There are two types of nested classes `static` and `non-static`.

A static nested class is one that has the static modifier applied and because it is static it must access the non static members of its enclosing class through an object. It cannot refer to non-static members of its enclosing class directly.

The second type of nested class is the inner class. An inner clas sis a non-static nested class. It has access to all of the variables and methods of its outer class and may refer to them directly in teh same way that other non-static members of the outerclass can do.

The following demonstrates an example of defining and using an inner class [InnerClassDemo](code/InnerClassDemo.java) An inner class named Inner is defined within the scope of class Outer, so any code in class Inner can directly access the variable outer_x.

An instance of Inner can be created only in the context of class Outer. The java compiler will give an error otherwise. Members of the inner class are known only within the scope fo the inner class and may not be used by the outer class.

It is possible to define inner classes within any block scope. For edxample you can define a nested class within the block defined by a method or eve wtihin the body of a for loop as in the following demo.

```java
class Outer {
    int outer_x = 100;

    void test() {
        for(int i=0; i<10; i++) {
            class Inner {
                void display() {
                    System.out.println("display: outer_x = " + outer_x);
                }
            }
            Inner inner = new Inner();
            inner.display();
        }
    }
}

class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
    }
}
```

## Exploring the String Class

String is probably the most commonly used class in Java's class library. The obvious reason for this is that strings are an important part of programming. Since string is a class you can create an object of type String. String constants are String objects.

```java
System.out.println("This is a String, too");
```

The string constand is a String object.

Strings are immutable. Once a String object is created, its contents cannot be altered. Seems like a serious restriction but it is not because

- If you need to change a string, you can always create a new one that contains the modifications
- Java defines peer classes of String, StringBuffer and String Builder which allow strings to be altered, so all of the normal string manipulations can be made through these.

Easist way to construct a string is a statement such as

```java
String myString = "this is a test";
```

Once a string object is created it can be used anywere that a string is allowed. Java defines only one operator for String objects: +. It is used to concatenate two strings. For example:

```java
String myString = "I" + " like " + "Java.";
```

[StringDemo](code/StringDemo.java) shows a demo of things we can do with Strings.

The String calss contains several methods that can be used. Strings can be tested for equality using equals(). The length of a string can be accessed using the length() method. The character at a specific index of a string can be accessed by calling charAt(). [StringDemo2](code/StringDemo2.java) demos using these methods on Strings.

You can also have arrays of strings such as in [StringDemo3](code/StringDemo3.java). String arrays play an important part in many Java programs.

## Using Command Line Arguments

Sometimes we want to pass information into a program when we run it. This is accomplished through command-line arguments to main(). To access the command-line arguments inside a Java program is easy - they are stored as strings in a String arry passed to the args parameter of main().

The following progrma displays all of the command-line arguments that it is called with

```java
class CommandLine {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "]: " + args[i]);
    }
}

```

The output of this program looks like

```
java CommandLine.java this is a test 100 -1
args[0]: this
args[1]: is
args[2]: a
args[3]: test
args[4]: 100
args[5]: -1
```

## Varargs: Variable length arguments

Modern versions of Java include a feature that simplifies the creation of methods that need to take a variable number of arguments. This feature is called `varargs`. A method that takes a variable number of arguments is called a variable-arity method, or simply a varargs method.

Before we had varargs we would either create overloaded methods for each variation on how we can call the method, or we would put the variable args into an array and pass the array into the method; as demonstrated in [PassArray](code/PassArray.java). In this program the method vaTest() receives its argument through the array variable v, this enables vaTest() to take an arbitrary number of arguments; however it must be packed into an array prior to calling vaTest()

A variable length argument is specified by three dots. We can rewrite vaTest() using a vararg as `static void vaTest(int ...v)`. This syntax tells the compiler that vaTest() can be called with zero or more arguments, as a result v is implicitly an array of type int, so within the method v is accessed using the normal array syntax. [VarArgs](code/VarArgs.java) is rewritten to use varargs where the output is the same as the original version.

v is operated on as an Array because v is an array. The varargs sytanx tells the compiler that a variable number of arguments may be used and that these arguments will be stored in the array referred to by v.

A method can have "normal parameter along with a variable-length parameter, but the variable length parameter must be the last parameter declared by the method.

```java
int doIt(int a, int b, double c, int ... vals) {}
```

In this case the first 3 args are matched iwth the parameters, and any remaining are stuffed into the vals array. See [VarArg2](code/VarArg2.java) for an example using both normal args and varargs

### Overloading Vararg Methods

A method that takes a variable-length argument can also be overloaded, [VarArgs3](code/VarArgs3.java) shows a program that overloads vaTest() 3 times. This demonstrates both ways that a varargs method can be overloaded.

1. The type of its vararg parameter can differ
2. Adding one or more normal parameters

Note: a varargs method can also be overloaded by a non-vararg method. vaTest(int x) is a valid overload of vaTest(int ...) in the previous program. The non varargs version is invoked only when one int argument is present, if more, then the vararg version will be chosen.

### Varargs and Ambiguity

Unexpected errors can result when overloading a method that takess a variable-length argument. This happens because it is possible to create an ambiguous call to an overloaded varargs method. Consider the program in [VarArgs4](code/VarArgs4.java) Because the vararg parameter can be empty, it is unclear whether the correct version to call is vaTest(int ...) or vaTest(boolean ...) so it yields an error.

Here is another ambiguous case

```java
static void vaTest(int ... v) {}
static void vaTest(int n, int ... v) {}
```

If we have these functions and we make the following call `vaTest(1)` it is inherently unclear which version of the method to choose. This the situation is ambigous, and will result in an ambiguity error.

## Local Variable Type Inference with Reference Types

One of the benefits to LVTI is the ability to streamline code. The tradtional sytanx for declaring a FileInputStream is the following

`FileInputStream fin = new FileInputStream("Test.txt");`

This can be shortened using type inference as follows:

`var fin = new FileInputStream("test.txt")`

[RefVarDemo](code/RefVarDemo.java) Here the type of mc will be inferered to be MyClass because that is the type of the initializer.
