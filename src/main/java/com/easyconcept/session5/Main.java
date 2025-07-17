package com.easyconcept.session5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new HashMap<>();
        Set<String> folder = new HashSet<>();
        List<String> fruits = new ArrayList<>();
        Stack<String> undoStack = new Stack<>();

        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        System.out.println(numbers.get("one"));
        System.out.println(numbers);
        System.out.println(numbers.get("two"));
        System.out.println(numbers.entrySet().stream().toList().get(1));

        for(Map.Entry<String, Integer> entry : numbers.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for(String key : numbers.keySet()) {
            numbers.get(key);
        }


    }
}
