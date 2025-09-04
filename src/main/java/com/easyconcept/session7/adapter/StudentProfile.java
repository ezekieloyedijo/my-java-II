package com.easyconcept.session7.adapter;

// Existing StudentProfile class (cannot be changed)
public class StudentProfile {
    private String fullName;
    private String studentId;
    private String grade;

    public StudentProfile(String fullName, String studentId, String grade) {
        this.fullName = fullName;
        this.studentId = studentId;
        this.grade = grade;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void print() {
        System.out.println("Student: " + fullName + ", ID: " + studentId + ", Grade: " + grade);
    }
}


