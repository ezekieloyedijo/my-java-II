package com.easyconcept.session7;

import com.easyconcept.session7.singleton.SchoolConfiguration;

public class MainReportBuilder {
    public static void main(String[] args) {
        ReportCard2 reportCard2 = new ReportCard2.Builder()
                .setStudentName("Ezekiel")
                .setSubject("Maths")
                .setGrade("A")
                .setComment("He is attentive")
                .setAttendance("Absent")
                .build();
        reportCard2.print();

    }
}
