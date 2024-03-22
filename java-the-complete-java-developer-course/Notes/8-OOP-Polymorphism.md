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
