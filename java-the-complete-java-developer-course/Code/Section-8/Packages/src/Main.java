package dev.lpa;

import com.abc.first.Item;

public class Main {
    public static void main(String[] args) {
        // Using the imported version
        Item firstItem = new Item("Burger");
        // Using the fully qualified package/class name
        com.abc.first.Item secondItem = new com.abc.first.Item("Coke");
        System.out.println(firstItem);
        System.out.println(secondItem);
    }

}
