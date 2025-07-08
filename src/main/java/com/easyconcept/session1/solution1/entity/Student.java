package com.easyconcept.session1.solution1.entity;

import java.util.UUID;

public class Student {
    private UUID id;
    private String name;
    private int age;

    public Student(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}
