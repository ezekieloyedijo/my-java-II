package com.easyconcept.session7;

public class ReportCard2 {
    private String studentName;
    private String subject;
    private String grade;
    private String comment;
    private String attendance;

    private ReportCard2(){}

    public void print() {
        System.out.println("Student: " + studentName);
        System.out.println("Subject: " + subject);
        System.out.println("Grade: " + grade);
        System.out.println("Attendance: " + attendance);
        if (comment != null) System.out.println("Comments: " + comment);
        System.out.println("-----------------------------");
    }

    public static class Builder{
        private ReportCard2 card = new ReportCard2();

        public Builder setStudentName(String name){
            card.studentName = name;
            return this;
        }

        public Builder setSubject(String subject){
            card.subject = subject;
            return this;
        }

        public Builder setGrade(String grade){
            card.grade = grade;
            return this;
        }

        public Builder setComment(String comment){
            card.comment = comment;
            return this;
        }

        public Builder setAttendance(String attendance){
            card.attendance = attendance;
            return this;
        }

        public ReportCard2 build(){
            if("Absent".equals(card.attendance)){
                card.grade = "N/A";
            }
            if (card.attendance == null) {
                card.attendance = "Absent";
            }
            return card;
        }
    }
}
