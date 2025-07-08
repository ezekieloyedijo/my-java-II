package com.easyconcept.session2;

// Ensures that the type can use certain methods or restricted

public class Calculator {
    public static <T extends Number> double add(T a, T b){
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.add(5, 6));       // 11.0
        System.out.println(Calculator.add(4.5, 2.1));
    }
}
