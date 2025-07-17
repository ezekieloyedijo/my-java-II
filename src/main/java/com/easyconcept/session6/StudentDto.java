package com.easyconcept.session6;

public class StudentDto {
    private String password;
    private String name;
    private Gender gender;
    private final int age;

    public StudentDto( String name, String password, int age, Gender gender) {
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}


