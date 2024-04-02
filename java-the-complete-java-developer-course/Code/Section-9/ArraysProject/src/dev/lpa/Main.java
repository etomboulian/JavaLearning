package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create and assign values to an int array
        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50;
        System.out.println(myIntArray[5]);

        // Create and assign values to a double array
        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        // Play with array initializer
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("first = " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array = " + arrayLength);
        // System.out.println("last = " + firstTen[arrayLength]); // run time error
        System.out.println("last = " + firstTen[arrayLength - 1]);

        int[] newArray;
        //newArray = new int[] {5, 4, 3, 2, 1};
        newArray = new int[5];

        // Show the default initialized value of the array
        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
        // add a \n to the output
        System.out.println();

        // Set the same values as before into the array elements
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = newArray.length - i;
        }

        // Now show the individual elements of the array
        for(int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        System.out.println();

        // Now using the enhanced for loop to display the elements
        for(int element : newArray) {
            System.out.print(element + " ");
        }

        System.out.println();
        // call the toString method on the array
        System.out.println(newArray);
        // use the java.util.Arrays toString static method to print the elements
        System.out.println(Arrays.toString(newArray));

        Object objectVar = newArray;
        if (objectVar instanceof int[]) {
            System.out.println("objectVar is really an int array");
        }

        // Create an object array to hold any object type
        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray;

    }
}
