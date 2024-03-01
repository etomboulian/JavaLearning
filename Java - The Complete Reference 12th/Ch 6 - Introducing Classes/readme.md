# Chapter 6 - Introducing Classes

The class is at the core of Java. It forms the basis for object-oriented programming in Java. Any concept that you implement in Java must be encapsulated within a class

## Class Fundamentals

The classes created so far exist only to encapsulate the main() method. But classes are much more powerful than the limited cases that we have used so far.

A class defines a new data type, once defined this new type can be used to create objects of that type. A class is a template for an object, and an object is an instance of a class.

### The General Form on a Class

A class is declared by use of the class keyword. A simplified general form of a class definition is shown here:

```java
class className {
    type instance-var1;
    type instance-var2;
    type instance-varN;

    type method-name1(parameter-list) {
        // method body
    }

    type method-name2(parameter-list) {
        // method body
    }

    type method-nameN(paramater-list) {
        // method body
    }

}
```
The data defined within a class is called instance variables. The code is contained within methods. Collectively the methods and variables defined within a class are called the members of the class. As a general rule it is the methods of the class that determine how the data can be used. 

### A Simple Class

[Box](Box.java) is a sample class Box with some data but no methods. This class defines a new data type called Box, we use this to declare objects of type Box.

To create an actual box object we use a statement like the one that follows to create a Box object. 

```java
Box mybox = new Box(); // create a Box object called mybox
```

When we create a class we are creating an object that contains its own copy of each instance varaible defined by the class. To access these variables we will use the dot (.) operator as follows

```java
mybox.width = 100;
```

This tells the compiler to assign the copy of width that is contained within the mybox object the value of 100. The dot operator is used to access both instance variables and methods. 

Here is a complete program that uses the Box class [BoxDemo](BoxDemo.java) and another that uses multiple instances of the Box class. [BoxDemo2](BoxDemo2.java). We can see from this example that mybox1's data is completely separate from the data in mybox2.

## Declaring Objects

When you create a class you are creating a new data type. You can use this type to declare objects of that type. 

1. Declare a variable of the class type
2. Acquire a copy of the object and assign it to the variable using the new operator.

These can be done in a combined step as follows:

```java
Box mybox = new Box();

Box mybox1;
mybox1 = new Box();
```

In the two step process the first line declares mybox1 as a reference to an object of type Box. At this time there is no actual Box object here yet. After the second statement executes then mybox1 will hold the memory address of the actual Box object, and we can use this to call the instance vars or methods. 

### A Closer Look at new

The new operator dynamically allocates memory for an object. It has this general form `class-var = new classname();`. The classname followed by () specifies the constructor for the class. A constructor defines what occurs when an object of a class is created. Ctors are an important part of all classes and have many significant attributes. If no explicit constructor exists for the class then the Java compiler will create a default ctor. That is the case with class Box. Soon we will define our own constructors. 

We don't use new with primitive types because Java's primitive types are not implemented as objects, but normal variables. This is done for efficiency. Not having the same overhead as Java objects allows java to implement the primitive types more efficiently. 

New allocates memory for an object at runtime. But since memory is finite, it is possible that new may not be able to allocate memory for an object because insufficient meory exists, this will raise a run-time error. 

A class creates a new data type that can be used to create objects. When you declare an object of a class you are creating and instance of that class. A class is a logical construct, an object has physical reality. 

## Assigning Object Reference Variables

Object reference variables act differently than you might expect when an assignment takes place. For example consider this code. 

```java
Box b1 = new Box();
Box b2 = b1;
```

b1 and b2 will both refer to the same object. The assignment does not perform any copying action, it only makes b2 refer to the same object as does b1. Any changes made to the object through b2 will affect the object to which b1 is referring since they refer to the same object. 

Reassinging b2 to something else won't do anything to the object but change the item that b2 is pointing to 

```java
Box b1 = new Box()
Box b2 = b1;
// ...
b1 = null;
```
Here b1 is set to null, but b2 still points to the original object

## Introducing Methods

The general form of a method is 

```java
type name(parameter-list) {
    // body
    return value // return something
}
```
type specifies the data type returned by the method, it can be any valid type including class types that you create. If a method does not return a value then its return type must be void. The parameter-list is a sequence of type and identifier pairs separated by commas. Parameters are varaiables that receive the value of the arguments passed to the method when it is called. If the method has no parameters then the parameter list will be empty. 

Methods that return other than void must have a return statement where we specify what to return, in the example value is returned. 

### Adding a method to the Box Class

It might have occured that the computation of a box's volume was something best handled by the Box class rather than the BoxDemo class. To do this we add a method to Box as shown here [BoxDemo3](BoxDemo3.java)

We use the volume method on each Box instance to tell it to calculate its volume and report it. Notice that inside the volume method that the instance variables width, depth, and height are referred to without preceeding them with an object name or the dot operator. When a method uses it's class's instance variables it can do so without explicit referenc to an object. 

### Returning a value

A better way to implement volume() is to have it compute the volume of the box and to return the result to the caller. [BoxDemo4](BoxDemo4.java) does just this. When volume() is called it is put on the right side of an assignment statement. On the left side is a variable that receives the value returned by the method call. 

2 things to understand about returning values. 
1. the type of data returned by a method must be compatible with the return type of the method
2. The variable receiving the value returned by a method must also be compatible with the return type of the method. 

### Adding a method that takes paramters

Parameters allow a method to be generalized. Here is a mehtod that returns the square of the nmber 10:

```java
int square() {
    return 10 * 10;
}
```

While this works it would be more useful to generalize it so that we can square any number we want. 

```java
int square(int i) {
    return i * i;
}
```

It is important to keep the terms parameter and argument straight. A parameter is a variable defined by a method that revies a value when the method is called.

An agument is a value tha tis passed to a method when it is invoked. 

We can use a parameterized method to improve the Box class. For example to set the dimensions since setting them from outside the class is bad practice and error prone, and makes it so that we cannot change the box class internals. 

We implemente a better approach in [BoxDemo5](BoxDemo5.java) where we use the setDim() method to set the dimensions for each box. 

## Constructors

It would however be better to do all of the setup that we need at the time that the object is first created. Initialization of an object is performed through the object's constructor. The constructor is called automatically when the object is created, before the new operator completes. 

Constructors don't have a return type, because the implicit return type of a ctor is the class type itself. We can rework the Box example so that the dimensions of a box are automatically initialized when the object is constructed. We do this by replacing setDim() with a constructor. [BoxDemo6](BoxDemo6.java)

We can see that box boxes use the Box constructor, but since the constructor only allows us to construct a cube of size 10 all boxes are the same size. 

When we do not explicitly define a constructor for a class then Java creates a default constructor for the class. This is why the past versions of box did not define a ctor. 

When using the default ctor all non-initialized instance variables will have their default values which are zero, null, and false for numeric types, reference types and boolean respectively. Once you define your own constructor then the default constructor is no longer used. 

### Parameterized Constructors

While the Box ctor does inititalize a box, it would be more helpful if we could set the dimensions of the box when we initialize it. [BoxDemo7](BoxDemo7.java) contains a version that enables us to do this. 

The output from this program is

```
Volume is 3000.0
Volume is 162.0
```

## The this keyword

Someitmes a method will need to refer to the object that invoked it; we use the `this` keyword to enable this. `this` can be used inside any method ot refer to the current object. Consider the following

```java
Box(double w, double h, double d) {
    this.width = w;
    this.height = h;
    this.depth = d;
}
```

The use of `this` in the example is redundant, but perfectly correct, inside the object `this` will always refer to the invoking object. 

### Instance Variable Hiding

Java does not allow two local variables with the same name in enclosing scopes. However you can have local variables with the same name as the instance variables of a class. When this happens, the local variable hides the instance variable. Because this lets you refer directly to the object you can use it to resolve any such namespace collisions. 

```java
Box(double width, double height, double depth) {
    this.width = width;
    this.height = height;
    this.depth = depth;
}
```

Either approach is perfectly valid, but some programmers argue that using this is more clear about what is coming in. 

## Garbage Collection

Since objects are allocated dynamically, they must also be destroyed dynamically also. Java handles such deallocations for you automatically, this is called garbage collection. 

When no reference to an object exist, that object is assumed to be unreachable, and no longer needed; thus the memory occupied by that object can be reclaimed. Garbage collection happens sporadically during the execution of a program. 

## A Stack Class

Now we look at a more practical example of a class. A stack stores data using first-in, last-out ordering. Like a stack of plates. Stacks usually implement only two methods, push and pop. To put an item on the stack, we push it onto the stack, to take an item off the stack we use pop to pop the item off the stack. 

[Stack](Stack.java) The stack class defines two data items, two methods and a ctor. The stack of integers is held by the array stack. This array is indexed by the variable topOfStack, which always containst he index of the top of the stack.

One issue which we will address later is that the array that holds the stack can be manipulated from outside the stack class which leaves it open for misuse. 








