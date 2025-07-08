package com.easyconcept.session1;

import java.util.Set;
import java.util.HashSet;

public class MySet {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();

        countries.add("Nigeria");
        countries.add("Ghana");
        countries.add("Kenya");
        countries.add("Ghana"); // duplicate - will not be added

        System.out.println("Set size: " + countries.size());
        System.out.println("Contains Kenya? " + countries.contains("Kenya"));

        countries.remove("Ghana");

        System.out.println("Is empty? " + countries.isEmpty());

        for (String country : countries) {
            System.out.println("Country: " + country);
        }

        countries.clear();
        System.out.println("Cleared. Size: " + countries.size());
    }

}
