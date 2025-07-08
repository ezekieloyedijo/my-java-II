package com.easyconcept.session1;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

// Observe the class, observe the type

public class MyCollection {
    public static void main(String[] args) {
        Collection<String> items = new ArrayList<>();

        // Add elements
        items.add("Pen");
        items.add("Notebook");
        items.add("Eraser");

        // Size of collection
        System.out.println("Size: " + items.size());

        // Check if collection contains an element
        System.out.println("Contains 'Pen'? " + items.contains("Pen"));

        // Remove an element
        items.remove("Eraser");

        // Convert to array
        Object[] array = items.toArray();
        System.out.println("Array version: ");
        for (Object item : array) {
            System.out.println(item);
        }

        // Use iterator
        Iterator<String> it = items.iterator();
        System.out.println("Iterating with Iterator:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Clear the collection
        items.clear();

        // Check if empty
        System.out.println("Is empty? " + items.isEmpty());
    }
}

