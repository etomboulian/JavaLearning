# Chapter 8 - Inheritance

Inheritance is one of the cornerstones of oop because it allows the creation of hierarchical classifications. Using inheritance we can create a genral class that defines traits common to a set of related items. This calss can then be inherited by other, more specific classes, each adding it's own unique behaviour.

A class that is inherited is called a superclass. The class that does the inheriting is called a subclass.

## Inheritance Basics

In Java you inherit from another class using the extends keyword. [SimpleInheritance](code/SimpleInheritance.java) creates a superclass called A and a subclass called B .

The subclass B includes all of the members of its superclass A. This is why subOb can access i and j and call showij(). Also inside sum() i and j can be referred to directly as if they were part of B.

Even though A is a superclass for B, it is also a completely independent stand-alone class. Being a superclass for a subclass does not mean that the superclass cannot be used by itself.

```java
class subclass-name extends superclass-name {
    // body of class
}
```

Each subclass can only have one superclass. Java supports only single inheritance.

### Member Access and Inheritance

Altought a subclass includes all of the members of its superclass, it cannot access those members of the superclass that have been declared as private. This is demonstrated in [Access](code/Access.java). A class member that has been declared as private will remain private to its calss. It is not accessible by any code outside its class, including subclasses

### A More Practical Example

Here we will further develop the Box class by extending it to include a fourth component called weight in [DemoBoxWeight](code/DemoBoxWeight.java). BoxWeight inherits all of the characteristics of Box and adds them to the weight component. We can extend Box to have any new feature that we need it to have

```java
class ColorBox extends Box {
    int color;

    ColorBox(double w, double h, double d, int c) {
        width = w;
        height = h;
        depth = d;
        color = c;
    }
}
```

Once you have created a supercalss that defines the general aspects of an object, that superclass can be inherited to form specialized classes. Each subclass simply adds its own unique attributes.

### A Superclass Variable Can Reference a Subclass Object

A reference variable of a superclass can be assigned a reference to any subclass derived from that superclass. See [RefDemo](code/RefDemo.java) for en example that shows this. Since BoxWeight is a subclass of Box, it is permissable to assign plainbox a reference to the weightbox object.

Importantly it is the type of the reference variable, not the type of the object that it refers to that determines what members can be accessed. When a reference to a subclass object is assigned to a superclass reference, you will only have access to only the parts of the class that is in the superclass.

This is why plainbox can't access weight even when it refers to a BoxWeight object. It is not possible for a Box reference to access the weight field, because Box does not define one.

## Using Super

In the prior examples, classes derived from Box were not implemented as efficiently or as robustly as they could have been. It duplicates code found in the superclass, and it means that the subclass must have access to the members it initializes. But if we wanted to mark some fields as **private**, then we cannot initialize them this way.

Whenever a subclass needs to refer to its immediate superclass it can do so by the use of the keyword super.

super has 2 general forms. The first calls the superclass' constructor. The second is used to access a member fo the superclass that has been hidden by a member of the subclass

### Using super to call Superclass Constructors

A subclass can call a constructor defined by its supercalss by use of the following form of super `super(arg-list)`.

Cosider this improved version of the BoxWeight class:

```java
class BoxWeight extends Box {
    double weight;  // weight of the box

    // initialize width, height, and depth using super()
    BoxWeight(double w, double h, double d, double m) {
        super(w,h,d);
        weight = m;
    }
}
```

Here `BoxWeight()` calls `super()` with the arguments w, h and d. This calls the Box constructor which initializes width, height and depth using these values. This leaves Box free to make these values **private** if desired.

Since constructors can be overloaded, super can be called using any constructor form that is defined by the superclass. The constructor executed will be the one that matches the arguments. [DemoSuper](code/DemoSuper.java) is a complete implementation of BoxWeight that provides various ways to construct a Box.

Pay attention to the clone ctor in BoxWeight, notice that super() is passed an object of type BoxWeight - not of type Box. This still invokes the ctor `Box(Box ob)`. This is because a superclass variable can be used to reference any object derived from that class, so we can pass a BoxWeight object to the Box ctor.

When a subclass calls super(), it is calling the ctor of its immediate superclass. super() always refers to the superclass immedately above the calling class. Also super() must always be the first statement executed inside a subclass ctor.

### A Second Use for Super

The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in which it is used. This usage has the folllowing form `super.member` where member can be either a method or an instance variable.

This usage is most applicable to situations in which member names of a subclass hide members by the same name in the superclass. Consider the example in [UseSuper](code/UseSuper.java) Although the variable i in B hides the i in A, super allows access to the i defined in teh superclass.

## Creating a Multilevel Hierarchy

To this point we have only seen hierarchies which contain a superclass and subclass, however hierarchies can build on as many layers of inheritance as you want. We demonstrate a multi level hierarchy with [DemoShipment](code/DemoShipment.java)

This example shows another important point: super() always refers to the ctor in the closest superclass. The super() in Shipment calls the ctor in BoxWeight. The super() in BoxWeight calls the ctor in Box.

## When Constructors are Executed

When a class hierarchy is created; what order are the constructors for the classes that make up the hierarchy executed?

In a class hierarchy, constructors complete their execution in order of derivation, frrom superclass to subclass. Since super() must be the first statment executed in a subclass ctor this order i sthe same whether or not super is used. See [CallingCons](code/CallingCons.java) for a demo that shows this, this shows that the ctors are executed in order of derivation.

## Method Overriding

In a class hierarchy, when a method in a subclass has the same name and type signature as a method in its superclass, then the method in the subclass is said to _override_ the method in the superclass. When an overriding method is called it will always refer to the version defined in the subclass. The version in the superclass will be hidden as in [Override](code/Override.java). If we wish to call show() from A then we must use super to enable this.

```java
class B extends A {
    int k;

    B(int a, int b, int c) {
        super.show();
        System.out.println("k: " + k);
    }
}
```

Where super.show() calls the superclass version of show(). Method overriding occurrs only when the names and the type signatures of the two methods are identical, if they are not then they are simply overloaded. Consider the example in [Override2](code/Override2.java). The version of show in B takes a string parameter which makes its signature different from the one in A; therefore it is not overriding, but overloaded.

## Dynamic Method Dispatch

### Why Overridden Methods?

### Applying Method Overriding

## Using Abstract Classes

## Using final with Inheritance

### Using final to Prevent Overriding

### Using final to Prevent Inheritance

## Local Variable Type Inference and Inheritance

## The Object Class
