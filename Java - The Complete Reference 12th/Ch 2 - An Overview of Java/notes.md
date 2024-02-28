## Object Oriented Programming

- OOP is at the core of Java
- OOP offers several organizational benefits over alternatives like Proceedural programming which are employed by languages such as C

### Abstraction

- Complexity can be managed through abstraction

  - Refers to complex Systems broken up into many different subsystems.
  - A process oriented program can be transformed by abstraction into its component objects.
  - Each object can respond to messages telling them to do something

- Object oriented concepts form the heart of Java

### The 3 OOP Priciples

- Encapsulation, Inheritance, Polymorphism

#### Encapsulation

- Encapsulation is the mechanism that binds together code and the data it manipulates.

  - It protects internal data from external interference or misuse
  - Access to the code and data is tightly controlled through a well defined interface

- The basis of Encapsulation is the class

  - A class defines the structure and behavior that will be shared by some objects
  - Objects are referred to instance of a class

- Code and data that form the class are called members of the class

  - data can be referred to as member variables or instance variables
  - code that operates on the data is referred to as methods
  - methods define how the data in the member variables can be used
  - Behaviour and Interface are defined by the methods that operate on instance data

- Class members may be declared as private or public (also protected)
  - The public interface of a class represents everything external users need to know or use about the class
  - The private methods and data can only be accessed by code that is a member of the class
  - The public interface should be designed not to expose to omuch of the inner workings of a class

#### Inheritance

- Inheritance is the process by which one object acquires the properties of another object
  - Supports hierarchical classification of classes
  - Animal class > Mammal class > Dog class > GoldenRetriever class

#### Polymorphism

### A First Simple Program

```java
class Example {
    public static void main(String[] args) {
        System.out.println("This is a simple Java program");
    }
}
```
