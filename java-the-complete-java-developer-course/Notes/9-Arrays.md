# Arrays

Arrays are a way to have multiple values all of the same type

Java provides us with many types of containers to store values of different types.

## Arrays

An array is a data structure that allows you to store a sequence of values, all of the same type. You can have arrays for any of the primitive types that we have looked at so far, and you can also have arrays for any class

Elements in an array are indexed starting at 0

Array variable decalration

int[] integerArray;
String[] nameList;
String courseList[];

You don't specify the size in the array declaration itself.

### Instantiating an Array

int[] integerArray = new int[10];

This will create a 10 element array. An array instantiation doesn't have a set of parenthesis, meaning that we cannot pass data to a constructor for an array.

The size of an array once created is fixed, it cannot be changed after instantiation. We cannot add or remove elements from an array, we can only assign evalues to one of the ten elements in the array for the above example.

#### The array initializer

The array initializer makes instantiating a small array of known values very easy.

```java
int[] firstFivePositives = new int[]{1, 2, 3, 4, 5};
```

Since we can implicitly determine the size given the initializer list the size of the array is not needed to be specified in this case. In fact we can even simplify this further.

```java
int[] firstFivePositives = {1, 2, 3, 4, 5};
String[] names = {"Andy", "Bob", "Charlie", "David", "Eve"};
```

This is called an anonymous array. An anonymous array initializer can only be used in a declaration statement.

## Array initialization and default element values

When you don't use an array initializer statement, all array elements get initialized to the default value for that type.

- For primitives this will be zero for any numeric primitive type,
- for booleans the default value is false,
- for any class type the elements will be initialized to null.

### THe enhanced for loop, the foreach loop

```java
for(declaration : collection) {
    // code block
}
```
