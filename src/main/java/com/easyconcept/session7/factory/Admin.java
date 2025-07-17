package com.easyconcept.session7.factory;

public class Admin implements UserService {
    @Override
    public void create() {
        System.out.println("Admin user created");
    }
}
