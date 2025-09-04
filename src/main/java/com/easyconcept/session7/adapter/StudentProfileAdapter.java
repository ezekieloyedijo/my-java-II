package com.easyconcept.session7.adapter;

// Adapter class
public class StudentProfileAdapter implements AdvancedStudent {
    private StudentProfile studentProfile;
    private String guardianName;
    private String contactNumber;

    public StudentProfileAdapter(StudentProfile studentProfile, String guardianName, String contactNumber) {
        this.studentProfile = studentProfile;
        this.guardianName = guardianName;
        this.contactNumber = contactNumber;
    }

    @Override
    public String getFullName() {
        return studentProfile.getFullName();
    }

    @Override
    public String getStudentId() {
        return studentProfile.getStudentId();
    }

    @Override
    public String getGrade() {
        return studentProfile.getGrade();
    }

    @Override
    public String getGuardianName() {
        return guardianName;
    }

    @Override
    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public void printAdvanced() {
        System.out.println("Student: " + getFullName() +
                ", ID: " + getStudentId() +
                ", Grade: " + getGrade() +
                ", Guardian: " + getGuardianName() +
                ", Contact: " + getContactNumber());
    }
}

