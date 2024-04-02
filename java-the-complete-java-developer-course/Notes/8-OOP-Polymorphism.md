# Section 8 - Polymorphism

## Composition

See [ComputerFactory](../Code/Section-8/ComputerFactory/src/Product.java) for an example which starts this section. We wil have a PersonalComputer which is composed of items which inherit from Product.

Inheritance defines an IS A relationship.
Composition defines a HAS A relationship.

### Composition is creating a whole from different parts

- We build the PC by passing objects to the constructor.
- We can hide the functionality further
- In this case, we wont' allow the calling program to access the parts directly

Composition or Inheritance or Both?

As a general rule, when you're designing your programs in Java, you want to prefer composition before implementing inheritance. In the example we used both.

- Composition is more flexible, you can add parts in, or remove them and these changes are less likely to have a downstream effect.
- Composition provides functional reuse outside the of the class hierarchy. Classes can share attributes and behaviour by having similar components.
- Java's inheritance breaks encapsulation, because subclasses may need direct access to a parent's state or behaviour.

##

To create an encapsulated class you want to

- Create constructors for object initialization such that only objects with valid data are created
- Use the private access modifier for your fields
- Use setter and getter methods sparingly and only as needed
- Use access modifiers that aren't private only for the methods that the calling code needs to use.

## Evaluating what the runtime type is

- How do we test what the runtime type of an object is

instance of

## Organizing classes, the package and import statements

- Package

  - A package is a namespace that organizes a set of related types
  - In general a package corresponds to a folder or directory on the os, but this is not required.
  - Package structure is hierarchical
  - Any legal java identifer can be a package name
  - Convention is all lowercase for package names

- Using classes from other packages (the import statement)
- The import statement is used to bring in classes or whole namespaces
- The import statement has to be declared before any class or type declarations but after the package declaration

```java
package dev.lap.package_one;
import java.util.Scanner; // import class here
import java.util.Random;

public class Main{
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Random random = new Random();
   }
}
```

Using a wildcard import will import all classes from the pacakge, ie java.util.\*

It is common practice to use the reverse domain name to start your own package naming conventions. If your company is abccompany.com then your package prefixes would be com.abccompany.\*. For the remainder of this course we will use dev.lpa which is the instructor's Learn Programming Academy development company.

Instead of importing you can use a fully qualified class name. ie

```java
package dev.lap.package_one;
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner  = new java.util.Scanner(System.in);
    }
}
```

If a package name is not specified, then the package is the default or unnamed package. We should always avoid using the default package.

You can't import types from the default pacakge into other classes outside of the default package. In other words you can't qualify the name if it is in the default package.
