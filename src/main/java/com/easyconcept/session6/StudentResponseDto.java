package com.easyconcept.session6;

public class StudentResponseDto {
    private String id;
    private String name;
    private Gender gender;
    private  int age;

    public StudentResponseDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.gender = student.getGender();
        this.age = student.getAge();
    }

    public String getId() {
        return id;
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
