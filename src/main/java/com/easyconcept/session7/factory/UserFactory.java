package com.easyconcept.session7.factory;

public class UserFactory {
    public static UserService createUser(String type) {
        switch (type.toLowerCase()){
            case "teacher":
                return new Teacher();
            case "student":
                return new Student();
            case "admin":
                return new Admin();
            default:
                throw new IllegalArgumentException("Unknown user type: " + type);
        }
    }
}
