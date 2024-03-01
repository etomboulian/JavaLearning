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

## Returning Objects

## Recursion

## Introducing Access Control

## Understanding static

## Introducing final

## Arrays revisited

## Introducing Nested and Inner Classes

## Exploring the String Class

## Using Command Line Arguments

## Varargs: Variable length arguments

### Overloading the Vararg Methods

### Varargs and Ambiguity

## Local Variable Type Inference with Reference Types




