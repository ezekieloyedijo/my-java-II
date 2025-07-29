package com.easyconcept.session4.simplethread;

public class TypingTask extends Thread {
    public void run() {
        System.out.println("Typing document...");
        try {
            Thread.sleep(2500);
            System.out.println("Finished typing.");
        } catch (InterruptedException e) {
            System.out.println("Typing interrupted!");
        }
    }
}