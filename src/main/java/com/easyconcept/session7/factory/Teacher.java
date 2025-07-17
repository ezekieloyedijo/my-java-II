package com.easyconcept.session7.factory;

public class Teacher implements UserService{
    @Override
    public void create(){
        System.out.println("Teacher user created");
    }
}
