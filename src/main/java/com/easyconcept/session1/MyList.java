package com.easyconcept.session1;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

/*
 * When List matters in real world scenario
 * Displaying students in the order they enrolled.
 * Showing transactions in order of occurrence.
 * Generating a queue (like first-come-first-serve admission).
 */

public class MyList {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add(1, "David"); // insert at index

        System.out.println("Get index 2: " + names.get(2)); // get()

        names.set(2, "Daniel"); // set()

        System.out.println("Index of David: " + names.indexOf("David")); // indexOf()
        System.out.println("Last index of Daniel: " + names.lastIndexOf("Daniel")); // lastIndexOf()

        ListIterator<String> iterator = names.listIterator();
        System.out.println("Iterating using ListIterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Sublist
        List<String> subList = names.subList(1, 3);
        System.out.println("Sublist (1-3): " + subList);

        // Remove by index
        names.remove(2);

        System.out.println("Final list: " + names);
    }
}
