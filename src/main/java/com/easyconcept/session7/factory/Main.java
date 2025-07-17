package com.easyconcept.session7.factory;

public class Main {
    public static void main(String[] args) {
        UserService teacher = UserFactory.createUser("teacher");
        UserService student = UserFactory.createUser("student");
        UserService admin = UserFactory.createUser("admin");

        teacher.create();
        student.create();
        admin.create();
    }
}
