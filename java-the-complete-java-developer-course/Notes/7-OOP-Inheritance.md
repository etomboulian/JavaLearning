# Chapter 7 - Object Oriented Programming and Inheritance

## Introduction to classes and objects

- Object oriented programming is a way to model real world objects as software objects which contain both data and code, aka class based programming.

Real world objects have two components

- state
- behaviour

Modelling real world objects as software objects is a fundamental part of OOP. A software object stores its state in fields, or attributes. It exposes behaviour through methods.

### Organizing classes

- classes can be organized into logical grouping which are called packages
- You declare a pcakage name int he class using the package statement
- If you don't declare a package, then class implicitly belongs to the default package

### Access modifiers for the class

- A class is a top-level class if it is defined in teh source code file and not enclosed in the code block of another class type or method
- A top level class has two valid access modifiers:
  - Public - any other class in any package can access this class
  - none - Package private, meaning that the class is only accessible to classes in the same package

### Access modifiers for class memebers

- access modifier at the member level allows granular control over class members
- valid access modifiers are
  - public - public means any other class in any package can access this class
  - protected - allows classes in the same package, and any sub classes in other packages to have access to the member
  - none - allows only classes in the same package to access the member (package private)
  - private - no other class can access this member

### Encapsulation

- The bundling of behaviour on a class
- hiding field or methods from public access

## Constructors

- A constructor is used in the gration of an object.
- It's a special type of code block that has a specific name and parameters, like a method.
- It has the same name as the calss itself and doesn't return any value (implicitly returns this)
- Access modifier can and should be included to specify who can use it.

```java
public class Account {
    public Account() { // This is the constructor declatation
        // Constrcutor code is code to be executed as the object is created
    }
}
```

### The default constructor

- If a class contains no constructor declarations, then a default ctor is implicitly declared
- This ctor has no parameters and is often called the no-args ctor
- If a class contains any other ctor declarations, then a default ctor is NOT implicitly declared

### Constructor overloading

- ctor overloading is declaring multiple ctors, with different formal parameters.
- The number of paramters can be different between the ctors
- If the numbe rof parameters is the same between two ctors, their types or order of the types must differ.

### Constructor chaining with this()

- Ctor chaining is when one ctor explicitly calls another overloaded ctor
- You can call a ctor only from another ctor
- You must use the special statement this() to execute another ctor, passing it arguments if required
- And this() must be the first executable statement, if its used from another ctor

[BankAccount](../Code/Section-7/ClassesChallenge/src/BankAccount.java) demonstrates this.

- With ctors, don't call any methods except for other ctors (including setters)

## Static vs Instance Variables

### Static Variables

- Declared by using the keyword static
- Static variables are also known as static member variables
- Every instance of the class shares the same static variable
- If a change is made to a static variable, then all other instances of that class will see the effect of that change.

- It is considered best practice to use thec lassname, and not a reference variable to access a static variable.

```java
class Dog {
    static String genus = "Canis";
    void printData() {
        Dog d = new Dog();
        System.out.println(d.genus);    // Confusing
        System.out.println(Dog.genus);  // Clearer!
    }
}
```

- An instance isn't required to exist to access the value of a static variable

### Instance variables

- Don't use the static keyword
- known as fields or member variables
- Instance variables belong to a specific instance of a class
- Instance variabvles represent the state of a specific instance of a class

```java
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("name = " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog rex = new Dog("rex");           // create instance (rex)
        Dog fluffy = new Dog("fluffy");     // create instance (fluffy)
        rex.printName();                    // prints rex
        fluffy.printName90;                 // print fluffy
    }
}
```

## Static v Instance Methods

### Static Methods

- Static methods are declared using a static modifier
- Static methods can't acces instance methods and instance variables directly
- They are used for operations that don't reuqire any data from an instnace of the class (this is not available)
- In a static method we cannot use the this keyword
- When you have a method that doesn't use instance variables, it should be declared as a static method.

### Instance Methods

- Instance methods can access instance methods and variables directly
- Instance method can also access static methods and variable directly.

## Plain Old Java Object

- A plain old Java Object (POJO) is a class that generally only has instance fields
- Its used to house data, and pass data between funtional classes.
- It usually has few if any method other than getters and setters.
- Many DB frameworks use POJOs to read data from or write data to databases, files or streams

### Examples of POJOs

- A POJO might be called a bean or a JavaBean
- A JavaBean is just a POJO with some extra rules applied to it
- A POJO can be called an Entity because it mirrors database entities
- Another acronymm is DTO (Data Transfer Object)
- Its a description of an objec that can be modeled as just data

### Support for POJO Creation

There are many generation tools that will turn a data model into generated POJO's or JavaBeans. We've seen an example of similar code generation in IntelliJ, which allowed us to generate getters and setters and ctors.

### Annotation

- Annotations are a type of metadat
- Metadata is a way of formally describing additional information about our code
- Annotations are more structured and have more meaning than comments
- They can be used by the compiler or other types of pre-processing functions to get more information about hte code
- Metadata doesn't effect how the code runs, so this code will still run with or without the annotation.

@Override -> Tell the compiler that this is an overriden method

## The implicit POJO Type -> Records

- We saw with manual POJO's we have a lot of repetitive code
- Record was introduced in JDK114 and officially part of Java in JDK16
- Purpose is to replace the boilerplate code of the POJO but to be more restrictive
- Java calls them "plain data carriers"

### The Record type

- The record is a special class that contains data, and that is not meant to be altered
- It seeks to achieve immutability for the data in its members
- It contain only the most fundamental methods such as constructors and accessors
- We don't have to write any of this code

## Inheritance - Part 1

Is a way to organize classes into a parent- child hierarchy, which lets the child inherit (re-use), fields and methods from its parent.

The Animal class

Animal
type: String
size: String
weight: double
move(String speed)
makeNoise()

Using extends specifies the superclass of the class that we are declaring

- Thus Dog is a subclass or child class of ANimal
- Animal is a parent or super class of Dog
- Only one class can be specified in the extends clause

Super()

- Super() is a lot like this()
- Its a way to call the constructor on the super class directly from the sub class's constructor
- Like this() it has to be the first staement of the constructor
- this() and super() cannot be called in the same ctor

Overriding a method

- Overriding a method is when you create a method on a subclass which has the same signature as a method on a super class

Overriden methods can do one of three things

- It can implement completely different behavior overriding that of the parent
- It can simply call the parent class's method, which is redundant
- Or it can call the parent class's method and then implement custom extra behaviour that only makes sense for the child class.

Polymorphism

- Means many forms
- makes code simpler
- encourages extensibility

## What is java.lang.Object?

### When do we really use inheritance

- We use inheritance every time we create a class
- Every custom class extends class Object implicitly.

[TheObjectClass](../Code/Section-7/TheObjectClass)

## This vs Super

The keyword super is used to access or call the parent class members (vars and methods)

The keyword this is used to call the current class members (vars and methods)

Using this is requried, when we have a parameter of the same name as an instance variable or field. Either can be used anywhere in a class except for within a static method.

this - Commonly used with constructors and setters and optionally with getters

super - Comonly used with method overriding, when we call a method with the same name from the parent class.

### this() vs super() call

- Another form these can take is the this() and super() call
- Each of these is a call to a constructor
- this() means call a constructor in the same class
- super() means call a constructor in the parent class

## Method Overriding vs Method Overloading

### Overloading

Method Overloading means providing two or more methods in a class with the same name but different parameters. Method return types may or may not be different.

Overloading is helpful because it reduces code duplication and we don't have to remeber multiple method names.

For the calling code it looks like a single method can be called with different sets of arguments, but its actually calling separate methods. Method overloading can be referred to as compile-time polymorphism, since the compiler is determining what version of the method to call based on the method name and argument list.

Overloading usually happens within a single class, but it can happen in an inheritance hierarchy as well.

### Overriding

Method Overriding means defining a method in a child class that already exists in the parent class with the same signature. Also knowns as Runtime Polymorphism, or Dynamic Method Dispatch, since the method that is going to be called is decided at runtime by the JVM.

When we override a method it is recommended to put the @Override annotation immediately above the method definition. It is not required but it helps to get the compiler to flag issues if you don't actually overrid the method properly.

Static methods cannot be overriden, only instance methods can

A method is Overridden if we follow these rules:

- It has the same name and same arguments
- The return type can be a subcalss of the return type in the parent class
- It can't have a lower access modifier
- Only inherited methods can be overridden
- Constructors an private methods cannot be overriden
- Methods that are final cannot be overridden
- A subclass can use super.methodName to call the superclass verison of the method

### Examples

```java
// Overriding
class Dog {
    public void bark() {
        System.out.println("woof");
    }
}

class GermanShepherd extends Dog {
    public void bark() {
        System.out.println("woof, woof, woof");
    }
}
```

```java
// Overloading
class Dog {
    public void bark() {
        System.out.println("woof");
    }

    public void bark(int number) {
        for(int i = 0; i < number; i++) {
            System.out.print("woof ");
        }
        System.out.println();
    }
}
```

Method Overloading:

- Provides functionality to reuse a method name with different parameters
- Usually in a single class but may also be used in a child class
- Must have different parameters
- May have different return types
- May have different access modifiers
- May throw different exceptions

Method Overriding:

- Used to override an inherited behaviour
- Always in two or more classes that have child-parent relationship
- Must have the same parameters and same name
- Must have the same return type or covariant return type (child class)
- Must not have a lower access modifier but may have a higher modifier
- Must not throw a new or broader checked exception

## Text Blocks

- A text block is just a special format for multi-line String literals.
- Its simply a String with a new representation in the source code that was added in JDK15

### Common Escape Sequences

| Escape Sequence | Description                     |
| --------------- | ------------------------------- |
| \t              | Insert a tab character          |
| \n              | Insert a new line character     |
| \"              | Insert a double quote character |
| \\              | Insert a backslash character    |
