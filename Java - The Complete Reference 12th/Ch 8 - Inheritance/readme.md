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

Method overriding forms the basis for one of Java's most powerful concepts: dynamic method dispatch. DMD is the mechanism by which a call to an overriden method is resolved at run time rather than at compile time. DMD is important because it is how Java implements run-time polymorphism.

A superclass reference varaiable can refer to a subclass object. Java uses this to reolve calls to overriden methods at run time.

When an overriden method is called through a superclass reference, Java determines which version of that method to execute based on the type of the object being referred to a the time the call occurrs. Thus the determination of which actual method to call is made at run-time.

The type of the object being referred to is what determins what version of an overriden method will be executed. Therefore if a superclass contains a method that is overriden by a subclass, a different version of the method will be executed based on the type that is pointed to. See [Dispatch](code/Dispatch.java) for an example showing this. The version of the method that is called depends on the actual objct we are calling it on, not the type of the reference.

### Why Overridden Methods?

Overridden methods allow Java to support run-time polymorphism. Polymorphism enables a general class to specify methods that will be common to all of its derivatives, while allowing subclasses to define the specific implementation of some or all of those methods. One way that Java implements the "one interface, multiple methods" aspect of polymorphism.

The superclass provides all elements that a subclass can use directly. It also defines those methodst aht the derived class must implement on its own. This allows the subclass to define its own methods, but enforces a consistent interface.

The abilty of existing code libraries to call methods on instances of new classes without recompiling while maintaining a clean abstract inteface is a profoundly powerful tool.

### Applying Method Overriding

The following program creates a supercalss called Figure that stores the dimensions of a 3d object. It also defines area().

In [FindAreas](code/FindAreas.java) 2 Sub classes of Figure are defined, Rectangle and Triangle, each provides its own implementation of area() so that it can return the correct area based on the actual shape.

## Using Abstract Classes

There are situations in which you will want to define a superclass that declares the structure of a given abstration without providing a complete implementation of every method. One reason is when a superclass is unable to create a meaningful implementation for a method. For example with Figure from the previous example, the definition of area() is only a placeholder, it doesn't make sense and it will not compute the area of a Figure.

This can be handled by either printing a warning message as we did in the previous example, but a better way to handle this is to use the abstract method.

You can require that certain method be overridden by subclasses by specifying the abstract type modifier. To declare an abstract method we use this general form.

```java
abstract type name(parameter-list);
```

Intentionally, no method body is present. Any class that contains one or more abstract methods must also be declared abstract. To declare a class as abstract simply use the abstract keyword in front of the class keyword in the class declaration.

There can be no objects of an abstract class. An abstract class cannot be directly instantiated with the new operator. It would be useless to allow since the abstract class is not fully defined. Also you cannot declare abstract constructors or abstract static methods.

Any subclass of an abstract class must either implement all of the abstract methods in the superclass, or be declared abstract itself.

[AbstractDemo](code/AbstractDemo.java) shows a simple example of a class with an abstract method, followed by a class that impelments that method. Abstract classes may include as much implementation as they see fit.

Although abstract classes cannot be used to instantiate objects, they can be used to declare object references, since Java' approach to run-time polymorphim is implemented via the use of superclass references.

Using an abstract class we can include the Figure class shown earlier, since there is no meaninful concept of area for an undefined two-dimensional figure, so [AbstractAreas](code/AbstractAreas.java) declares area as abstract.

## Using final with Inheritance

The keyword final has three uses.

1. It can be used to create the equivalent of a named constant
2. It prevents a method from being overriden
3. It prevents a class from being inherited from.

### Using final to Prevent Overriding

To disallow a method from being overriden, specify final as a modifier at the start of its declaration. Methods declared as final cannot be overridden.

```java
class A {
    final void meth() {
        System.out.println("This is a final method");
    }
}

class B extends A {
    void meth() {
        System.out.println("Illegal"); // this is an Error
    }
}
```

Because meth() is declared as `final`, it cannot be overridden in B. It will be a compile time error if you do.

Methods declared as `final` can sometimes provide a performance boost as the compiler is free to inline calls to them because it knows that they will not be overridden by a subclass.

Inlining is an option only with `final` methods. Normally Java resolves calls to methods dynamically, at run time. This is called _late binding_. However since `final` methods cannot be overridden, a call to one can be resolved at compile time. This is called _early binding_.

### Using final to Prevent Inheritance

Sometimes we want to prevent a class from being inherited. To do this we preceede the class declaration with final. Declaring a class as final implicitly declares all of its methods as final too.

It is illegal to declare a class as both abstract and final since an abstract class is incomplete and requires subclassing to provide complete implementation.

```java
final class A {
    //
}

// The following class is illegal
class B extends A { // ERROR!! Cannot subclass A
    //
}
```

## Local Variable Type Inference and Inheritance

Recall that a superclass reference can refer to a derived class object, and this is part of Java's support for polymorphism. However when using LVTI, the inferred type of a variable is based on the declared type of its initializer. If the initializer is of the superclass type, that will be the inferred type of the variable.

[TypeInferenceAndInheritance](code/TypeInferenceAndInheritance.java) gives an example which demonstrates this. Because the function which returns one of the polymorphic classes has a return type of MyClass, every object reference created by a return value from that function will be MyClass regardless if the actual object is a derived class object.

## The Object Class

There is one special class, Object, defined by Java. All other classes are subclasses of Object. Object is a superclass of all other classes. A reference variable of type Object can refer to an object of any other class.

Object defines the following methods:

| Method                                                                                           | Purpose                                                          |
| ------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------- |
| Object clone()                                                                                   | Creates a new object that is the same as the object being cloned |
| boolean equals(Object object)                                                                    | Determines whether one object is equal to another.               |
| void finalize()                                                                                  | Called before an unused object is recycled (Before JDK9)         |
| Class<?> getClass                                                                                | Obtains the class name of an object at runtime                   |
| int hashCode()                                                                                   | Returns the hash code associated with the invoking object        |
| void notify()                                                                                    | Resumes execution of a thread waiting on the invoking object     |
| void notifyAll()                                                                                 | Resumes execution of all threads waiting on the invoking object  |
| String toString()                                                                                | Returns a string that describes the object                       |
| void wait() <br> void wait(long milliseconds) <br> void wait(long milliseconds, int nanoseconds) | Waits on another thread of execution                             |

The methods getClass(), notify(), notifyAll(), and wait() are declared as final. The others all may be overridden.

The equals() method compares two objects; it returns true if the objects are equal, and false otherwise. The exact definition of equality can vary depending on the objects being compared.

The toString() method returns a string that contains a description
