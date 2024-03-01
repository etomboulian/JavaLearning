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

In general there are two ways that a programming language can pass an argument to a subroutine. The first way is *call-by-value*. This approach copies the value of an argument into the formal parameter of the subroutine. Changes made to the parameter of the subroutine have no effect on the argument. 

The second way that an argument can be passed is *call-by-reference*. In this approach a reference to the argument is passed to the parameter; within the subroutine, this reference is used to access the actual argument. This means that changes made to the parameter will affect the argument used to call the subroutine. 

Although Java uses call-by-value to pass all arguments, the precise effect differs between whether a primitive type or a reference type is passed. 

When you pass a primitive type to a method, it is passed by value. A copy of the argumetn is made, and what occurs to the parameter that receives the argument has no effect outside the method. Consider the following program [CallByValue](code/CallByValue.java). As you can see the operations that occur inside meth() have no effect on the values of a and b used in the call. 

When you pass an object to a method, the situation changes, because objects exhibit call-by-reference behaviour. When you create a variable of a class type, you are only creating a reference ot an object. When you pass this reference to a method, the parameter that receives it will refer to the same object as that referred to by the object. Consider the following program [PassObjRef](code/PassObjRef.java) as you can see the actions inside meth() have affected the object used as an argument.

REMEMBER: When an object reference is passed to a method, the reference itself is passed by use of call-by-value. However, since the value being passed refers to an object, the copy of that value (the memory address) will still refer to the same object that is corresponding argument does

## Returning Objects

A method can return any type of data, including class types that you create. In the following program [RetOb](code/RetOb.java) the incrByTe() method returns an object in which the value of a is ten greater than it is in the invoking object

Each time incrByTen() is invoked, a new object is created and a reference to it is returned to the calling routine. 

Since all objects are dynamically allocated using new, you don't need to worry about an object going out-of-scope because the method in which is was created terminates. The object will continue to exist as long as there is a reference to it somewhere in your program. When there are no references to it, the object will be reclaimed the next time garbage collection takes place. 

## Recursion

Java supports Recursion.

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




