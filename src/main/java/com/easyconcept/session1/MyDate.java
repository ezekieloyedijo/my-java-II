package com.easyconcept.session1;

import java.util.Date;


public class MyDate {
    public static void main(String[] args) {
        Date now = new Date(); // Current date and time
        System.out.println("Current Date and Time: " + now);

        long timeInMillis = now.getTime(); // Milliseconds since Jan 1, 1970
        System.out.println("Milliseconds since Epoch: " + timeInMillis);

        Date specificDate = new Date(1650000000000L); // Custom timestamp
        System.out.println("Specific Date: " + specificDate);
    }
}
