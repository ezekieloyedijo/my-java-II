package com.easyconcept.session1;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

/*
 * Use Map when you want to associate a key with a value
 * You need a fast look up
 * You do not care about order, linkedHashMap can be used for insertion order
   Keys must be unique
  * Ultimately we use Hybrid approach in the real world system
*/

public class MyMap {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 28);

        System.out.println("Age of Bob: " + ages.get("Bob"));

        // Check key/value
        System.out.println("Has key 'Alice'? " + ages.containsKey("Alice"));
        System.out.println("Has value 30? " + ages.containsValue(30));

        // Remove key
        ages.remove("Charlie");

        // Get key set
        Set<String> keys = ages.keySet();
        System.out.println("Keys: " + keys);

        // Get values
        Collection<Integer> values = ages.values();
        System.out.println("Values: " + values);

        // Get entry set
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Is map empty? " + ages.isEmpty());

        ages.clear();
        System.out.println("Cleared. Size: " + ages.size());
    }

}
