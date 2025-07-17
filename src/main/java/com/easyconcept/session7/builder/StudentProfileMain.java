package com.easyconcept.session7.builder;

import java.util.List;

public class StudentProfileMain {
    public static void main(String[] args) {
        StudentProfile studentProfile = new StudentProfile
                .Builder("Ayo Tolu", "std1", "A")
                .setContactNumber("566777")
                .setGuardianName("Tayo")
                .setEnrolledSubject(List.of("Maths", "English", "Civic", "Verbal", "Yoruba"))
                .build();

        System.out.println(studentProfile);
    }
}
