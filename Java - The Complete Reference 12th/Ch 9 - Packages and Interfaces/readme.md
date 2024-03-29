(230)

# Chapter 9 - Packages and Interfaces

Packages are containers for classes, they are used to keep the class name spaces compartmentalized. Packages are stored in a hierarchical manner and are explicitly imported into new class definitions.

Through the **interface** keyword, Java allows you to fully abstract an **interface** from its implementation. Using interface, you can specify a set of methods that can be implemented by one or more classes. Traditionally, the **interface** does not actually define any implemenation. Interfaces have one additional capability from abstract classes: A class can implemente more than one **interface**; while a class can only inherit from a single superclass (abstract or otherwise).

## Packages

In all of our preceeding examples the name of each class was taken from the same namespace. This means that a unique name had to be used for each class to avoid name collisions. Java provides a mechanism for partitioning the class name space into more manageable chunks. This is the package.

Package is both an naming nqad a visibility control mechanism. You can define classes in a package that are not accessible by code outside that package. You can also define class members that are exposed only to other members of the same package.

### Defining a Package

Creating a **package** is very simple, include a **package** command as the first statement in a Java source file. Any classes declared within that file will belong to the specified **package**

The **package** statement defines a name space in which classes are stored. If you omit the **package** statement, the class names are put into the default package, which has no name. While the deffault package is fine for short, sample programs, in real applications we need to define our own packages.

General form of the **package** statement

```java
package mypackage;
```

Where mypackage is the name of the **package**.

Typically Java uses file system directories to store packages, and that is the approach taken here. For example, the .class files or any classes that you declare to be part of **mypackage** must be stored in a directory called mypackage.

More than one file can include the same **package** statement. The package statement simply specifies to which package the classes defined in a file belong. It does not exclude other classes in other files from being part of that same **package**.

You can create a hierarchy of **packages**. The general form of a multileveled package statement is shown here:

```java
package pkg1[.pkg2f[.pkg3]]
```

A **package** hierarchy must be reflected in the file system of your Java development system. For example a package declared as `package a.b.c` needs to be stored in directories called a\b\c. You cannot rename a **package** without renaming the directory in which the classes are stored.

### Finding Packages and CLASSPATH

**Packages** are typically mirrored by directories; so we ask how does the Java run-time system know where to look for **packages** that we create?

1. By Default the Java run-time system uses the current working directory as its starting point, so if your **package** is in a subdirectory of the current directory then it will be found.

2. You can specify a directory path or paths by setting the **CLASSPATH** environment variable

3. You can use the **-classpath** option with **java** and **javac** to specify the path to your classes.

Starting in **JDK9** a **package** can be part of a **module** and thus found on the **module** path.

For example consider the following **package** specification

`package mypack;`

In order for a program to find **mypack**, the program can be executed from a directory immediately above **mypack**, or the **CLASSPATH** must be set to include the path to **mypack**, or the -classpath option must specify the path to mypack when the program is run via **java**.

When the latter two options are used, the class path must not include **mypack** itself, it simply specifies the path to mypack (ie the directory above **mypack**)

### A Short Package Example

See [AccountBalance](code/AccountBalance.java). This file should be compiled, and then executed from outside the **mypack** folder with the command.

`java mypack.AccountBalance`

**AccountBalance** is now part of the package **mypack**. This means that it cannot be executed by itself. **AccountBalance** must now be qualified with its **package** name

## Packages and Member Access

Previously we saw access control applied to classes. Packages add another dimension to access control.

Classes and package are both means of encapsulating and containing the namespace and scope of the variables and methods. Packages act as continers for classes and other subordinate packages. Classes act as containers for data and code. Java addresses for categories of visibiltiy for class members of a package.

- Subclasses in the same package
- Non-Subclasses in the same package
- Subclasses in different packages
- Classes that are neither in the same package nor subclass

The three access modifiers **private**, **public** and **protected** provide ways to produce the many levels of access required.

Class Member access rules:

|                                | Private | No Modifier | Protected | Public |
| ------------------------------ | ------- | ----------- | --------- | ------ |
| Same Class                     | Yes     | Yes         | Yes       | Yes    |
| Same package subclass          | No      | Yes         | Yes       | Yes    |
| Same package non-subclass      | No      | Yes         | Yes       | Yes    |
| Different package subclass     | No      | No          | Yes       | Yes    |
| Different package non-subclass | No      | No          | No        | Yes    |

While this may seem complex we can simplify it as follows.

Anything declared **public** can be accessed from different classes and different packages.

Anything declared **private** cannot be seen outside of its class.

When a member does not have an explicit access specification, it is visible to subclasses as well as to other classes in the same package. **Package-private**

Anything declared as **protected** is visible outside your current package, but only to classes that subclass your class directly.

A Non-nested class has only two possible access levels: **default** and **public**. When a class is declared as **public** it is accessible outside its package. If a class has default access, then it can only be accessed by otyher code within its same pacakge. When a class is **public**, it must be the only **public** class declared in the file, and the file must have the same name as the class.

### An Access Example

Here [AccessExample](code/AccessExample) is an example showing all combinations of the access control modifiers. In this example there are 2 packages and 5 classes.

The lines that will not compile will be commented out.

## Importing Packages

There are no core Java classes in the unnamed default package; all of the standard classes are stored in some named package. Java includes the **import** statement to bring certain classes or package into visibility. Once imported a class can be referred to directly using only its name.

In a Java source file, **import** statements occur immediately following the **package** statement and before any **class** definitions. `import pkg1[.pkg2].(classname|*);`

```java
import java.util.Date;
import java.io.*;
```

All of the standard Java SE classes included with Java begin with the name Java. The basic language functions are stored in a package called java.lang; and since this package is so ubiquitous it is implictly imported by the compiler for all programs.

If you **import** packages with classes that have conflicting name, you will only get an error when you attempt to use the conflicting named class, and you must qualify the class by its **package** name.

The **import** statement is optional, you can use the fully qualified name instead, but importing makes the names much shorter.

```java
import java.util.*;
class MyDate extends Date { }
```

Is equivalent to the following without using the **import** statement.

```java
class MyDate extends java.util.Date { }
```

When a **package** is imported, only those items within the package declared as public will be available to non-subclasses in the importing code. If we wanted to make the **mypack.Balance** class available as a standalone class for use outside of **mypack**, then we need to declare it as **public** and place it in its own file.

## Interfaces

Using the keyword **interface**, you can fully abstract a class' interface from its implementation. Using **interface**, you can speficy what a class must do, but not how it does it.

Interfaces are syntatically similar to classes but they lack instance variables, and generally their methods are declared without any body. This means that you can define interfaces that don't make assumptions about how they were implemented. Once it is defined, any number of classes can implement an **interface**, and any one class can implement any number of interfaces.

To implement an interface a class must provide the complete set of methods required by the interface. However each class can determine the details of its own implementation.

Interfaces are designed to support dynamic method resolution at run time.

Some interfaces are in a different hierarchy from classes, it is possible for classes that are unrealted in terms of the class hierarchy to implement the same interface.

### Defining an Interface

The general form of an interface

```java
access interface name {
    return-type method-name1(parameter-list);
    return-type method-name2(parameter-list);

    type final-varname1 = value;
    type final-varname2 = value;

    // ...

    returntype method-nameN(parameter-list);
    type final-varnameN = value;
}
```

When no access modifier is included, then **default access** results, and the **interface** is only available to other members of the package in which it is declared, default access is **package-private**.

When it is declared as **public**, the interface can be used by code outside its package. In this case the interface must be the only public interface declared in the file, and the file must have the same name as the interface.

Prior to JDK8, an interface could not define any implementation whatsoever, and in this version an interface can only define what, not how. Beginning with JDK 8 it is possible to add a default implementation to an interface method. JDK8 also brought static interface methods.

Variables can be declared inside interface declarations, and they are implicitly **final** and **static** and must be initialized. All methods and variables are implicitly **public**.

Example **interface** definition

```java
interface Callback {
    void callback(int param);
}
```

### Implementing Interfaces

Once an **interface** has been defined then one or more classes can implement that interface. To implement an interface, include the **implements** clause in a class definition, and then create the methods required by the interface. This looks like

```java
class classname [extends superclass] [implements interface [,interface...]] {}
```

If a class implements more than one interface, the interfaces are separated with a comma. If a class implement two interfaces that declare the same method, then the same method will be used by clients of either interface.

The methods that **implement** an interface must be declared **public**, and the type signature of the implementing method must match exactly the type signature specified in the interface definition.

Here is an example class that implements the **Callback** interface shown earlier.

```java
class Client implements Callback {
    // Implement Callback's interface
    public void callback(int p) {
        System.out.println("callback called with " + p);
    }
}
```

It is allowed and common for classes that implement interfaces to define additional members of their own.

#### Accessing Implementations Through Interface References

Variables can be declared as object references that use an Interface rather than a class type. Any instance of a class that implements teh declared interface can be referred to by such a variable.

When you call a method through one of these references the correct version will be called based on teh actual instance of the interface being referred to. The method to be executed is looked up dynamically at run time. The calling code can dispatch though an interface without having to know anything about the callee.

The next example calls the **callback()** method via an interface reference.

```java
class TestIface {
    public static void main(String[] args) {
        Callback c = new Client();
        c.callback(42);
    }
}

// output
// callback called with 42
```

Notice that variable **c** is declared to be of type **Callback** but is assigned an instance of type **Client**. Though **c** can be used to access the **callback()** method, it cannot be used to access any other members of the **Client** class.

An **interface** reference variable has knowledge only of the methods declared by its **interface** declaration. Thus c could not be used to access a non interface method.

The next example shows the poly morphic power of such a reference.

```java
class AnotherClient implements Callback {
    public void callback(int p) {
        System.out.println("Another version of callback");
        System.out.println("p squared is " + (p*p));
    }
}

class TestIface2 {
    public static void main(String[] args) {
        Callback c = new Client();
        AnotherClient ob = new AnotherCLient();

        c.callback(42);
        c = ob;         // c now refers to AnotherClient object
        c.callback(42)
    }
}

// output

// callback called with 42
// Another version of callback
// p squared is 1764
```

As we can see the version of **callback()** that is called is determined by the type of the object that c refers to at run time.

#### Partial Implementations

If a class includes an interface but does not fully implement the methods required by that interface, then that class must be declared as **abstract**

```java
abstract class Incomplete implements Callback {
    int a, b;

    void show() {
        System.out.println(a + " " + b);
    }
    // ...
}
```

Here the class **Incomplete** does not implement the **callback()** method and must be declared as **abstract**. Any class that inherits Incomplete must implement callback() or be declared abstract itself.

### Nested Interfaces

An interface can be declared as a member of a class or another interface. Such an interface is called a _member interface_ or a _nested interface_. A nesteed interface can be declared as **public**, **private** or **protected**. This is different from a top level interface which must be declared as public or use the default access level. When a nested interface is used outside of its enclosing scope, it must be qualified by the name of the class or interface of which it is a member. See [NestedIfDemo](code/NestedIfDemo.java) for an example of this.

#### Applying Interfaces

Looking at a more practical example [IFTest](code/IFTest/). Previously we implemented a Stack class, but there are many ways that a stack can be implemented. However no matter how the stack is implemented the interface to the stack remains the same. That is the methods **push()** and **pop()** define the interface to the stack independently of the details of the implementation.

### Variables in Interfaces

Interfaces can be used to import shared constants into multiple classes by simply declaring an interface that contains variables that are initialized to the desired values. When you implement that interface, all of those variable names will be in scope as constants.

The next example [AskMe](code/AskMe) uses thie technique to implement an automated "decision maker". Inside each class we refer to the named constants that are defined in the implemented interface. Note that because we are using **Random** the output will vary each time we run the program.

### Interfaces can be Extended

One interface can inherit another by use of the keyword **extends**, its the same syntax for inheriting classes. When a class implements an interface that inherits another interfaace, it must provide implementations for all methods required by the interface inheritance chain. [IFExtend](code/IFExtend)

## Default Interfafce Methods

Prior to JDK8, an interface could not define any implementation whatsoever. Since then that has changed with the addition of a new capability to interfaces called the default method. A default method allows you to define a default implementation for an interface method.

A major motivation for the default method was to provide a means by which interfaces could be added to without breaking existing code. If a new method was added to a popular widely used interface, then the addition of that method would break existing usage of that interface since all classes that impelement it would need to add an implementation for the new method. Adding a method with a default implementation would not cause pre-existing code to break in this way.

The addition of default methods does not change a key aspect of interface, its in ability to maintain state information. The major difference between a class and an interface is that a class can maintain state information.

### Default Method Fundamentals

An interface default method is defined similar to the way a method is defined by a **class**. The primary difference is that the declaration is preceeded by the keyword **default**. [DefaultMethodDemo](code/DefaultMethodDemo).

It is possible and common for an implementing class to define its own implmentation of a default method, as we do with MyIFImp2, then when getString() is called, a different string is returned.

### A More Practical Example

Now we return to the IntStack interface. Assume that IntStack is widely used and that many programs rely on it. Further assume that we now want to add a method to IntStack that clears the stack, enabling the stack to be re-used.

We want to evolve the IntStack interface to add new functionallity, but we don't want to break any preexisting code. Before this was impossible, but with the inclusion of default methods it is now easy to do.

```java
interface IntStack {
    void push(int item);
    int pop();

    default void clear() {
        System.out.println("Clear() not implemented")
    }
}
```

The default method gives us a way to

- gracefully evolve interfaces over time
- provide optional functionality without requiring that a class provide a placeholder implementation when that functionality is not needed.

In real world code, clear() would have thrown an exception, rather than displaying an error message.

### Multiple Inheritance Issues

Java does not support the multiple inheritance of classes. Since an interface can now include default methods, once might wonder if an interface provides a backdoor into Multiple Inheritance. It does not. A class can contain state information while an interface cannot.

However we can cause a name conflict issue if a class implements two interfaces, each of which provides a default implementation for a method of the same name.

- First a class implementation will take priority over a default interface implemenation
- Second a class which implements two interfaces that both have teh same default method, but does not override that method, then an error will result
- In cases where one interface in herits another, with both defining a common default method, the inheriting interface's version of the method takes precedence.

It is possible to explicity refer to a default implementation in an inherited interface by using this form of **super**. Its general form is shown here:

```java
InterfaceName.super.methodName();
```

## Use static Methods in an Interface

Another added capability to interfaces is the ability to define one or more static methods. A static method defined in an interface can be called independently of any object. Thus, no implementation of the interface is necessary and no instance of the interface is required in order to call a static method.

We call a static method on an interface using the following general form similar to how we call one on a class.

```java
InterfaceName.staticMethodName();
```

Here we add a static method to MyIF

```java
public interface MyIF {
    int getNumber();

    default String getString() {
        return "Default String";
    }

    static int getDefaultNumber() {
        return 0;
    }
}
```

**static** interface methods are not inherited by either an implementing class or a subinterface.

## Private Interface Methods

Starting in JDK9 an interface can include a private method. A private interface method can be called only by a default method or another private method defined by the same interface. Since a private interface method is private, it cannot be used by code outside the interface in which it is defined, this includes subinterfaces because private interface methods are not inherited by subinterfaces.

The major benefit to a private interface method is that it lets two or more default methods use a common piece of code.

```java
interface IntStack {
    void push(int item);
    int pop();

    // A default method that returns an array that contains
    // the top n elements on the stack
    default int[] popNElements(int n) {
        // return the requested elements
        return getElements(n);
    }

    // A default method that returns an array that contains
    // the next n elements on the stack after skipping elements.
    default int[] skipAndPopNElements(int skip, int n) {
        // Skip the specified number of elements
        getElements(skip);

        // Return the requested elements
        return getElements(n);
    }

    // A private method that returns an array containing the top n
    // elements on the stack
    private int[] getElements(int n) {
        int[] elements = new int[n];
        for(int i = 0; i < n; i++) elements[i] = pop();
        return elements;
    }
}
```

(257)
