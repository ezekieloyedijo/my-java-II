package com.easyconcept.session6;


import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private int age;
    private Gender gender;
    private String password;

    public Student(){

    }

    public Student(StudentDto dto) {
        this.id = generateId();
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.age = dto.getAge();
        this.gender = dto.getGender();
    }

    public Student(String id, String name, int age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "{id: " + id + "," +
                "name: " + name + "," +
                "age: " + age + ", " +
                "gender: " + gender + ", " +
                "password: " + password + "}";
    }
}
