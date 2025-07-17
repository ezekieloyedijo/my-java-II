package com.easyconcept.session7;

public class ReportCard {
    private String studentName;
    private String subject;
    private String grade;
    private String comment;
    private String attendance;

    public ReportCard(String studentName, String subject, String grade, String comment, String attendance) {
        this.studentName = studentName;
        this.subject = subject;
        this.grade = grade;
        this.comment = comment;
        this.attendance = attendance;
    }

    public ReportCard(String grade, String attendance) {
        this.grade = grade;
        this.attendance = attendance;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public void print() {
        System.out.println("Student: " + studentName);
        System.out.println("Subject: " + subject);
        System.out.println("Grade: " + grade);
        System.out.println("Attendance: " + attendance);
        if (comment != null) System.out.println("Comments: " + comment);
        System.out.println("-----------------------------");
    }
}
