package com.easyconcept.session4.simplethread;

public class UpdateCheckTask extends Thread {
    public void run() {
        System.out.println("Checking for updates...");
        try {
            Thread.sleep(1500);
            System.out.println("System is up to date.");
        } catch (InterruptedException e) {
            System.out.println("Update check interrupted!");
        }
    }
}