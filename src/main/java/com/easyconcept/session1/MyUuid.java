package com.easyconcept.session1;

import java.util.UUID;

public class MyUuid {
    public static void main(String[] args) {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        System.out.println("Generated UUID 1: " + id1);
        System.out.println("Generated UUID 2: " + id2);
    }
}
