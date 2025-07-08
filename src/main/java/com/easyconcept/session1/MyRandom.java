package com.easyconcept.session1;

import java.util.Random;

public class MyRandom {
    public static void main(String[] args) {
        Random rand = new Random();

        int randomInt = rand.nextInt(100); // 0 to 99
        System.out.println("Random Integer (0-99): " + randomInt);

        double randomDouble = rand.nextDouble(); // 0.0 to 1.0
        System.out.println("Random Double: " + randomDouble);

        boolean randomBool = rand.nextBoolean();
        System.out.println("Random Boolean: " + randomBool);
    }

}
