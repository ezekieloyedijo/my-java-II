package com.easyconcept.session4.simplethread;

public class MusicTask extends Thread {
    public void run() {
        System.out.println("Music playing...");
        try {
            Thread.sleep(2000); // plays for 2 seconds
            System.out.println("Music stopped.");
        } catch (InterruptedException e) {
            System.out.println("Music interrupted!");
        }
    }
}
