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
