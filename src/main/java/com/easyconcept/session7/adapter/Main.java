package com.easyconcept.session7.adapter;

public class Main {
    public static void main(String[] args) {
        // Old system
        StudentProfile basicStudent = new StudentProfile("John Doe", "S123", "B");
        basicStudent.print();

        System.out.println("----- With Adapter (New Features) -----");

        // Using Adapter
        AdvancedStudent advancedStudent = new StudentProfileAdapter(
                basicStudent,
                "Mr. Doe",
                "08012345678"
        );
        advancedStudent.printAdvanced();
    }
}
