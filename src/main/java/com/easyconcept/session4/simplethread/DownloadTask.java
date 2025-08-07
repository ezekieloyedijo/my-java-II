package com.easyconcept.session4.simplethread;

public class DownloadTask extends Thread {
    public void run() {
        System.out.println("Download started...");
        try {
            Thread.currentThread().setName("DownloadTask");
            System.out.println(Thread.currentThread().getName() + " is now RUNNING.");
            Thread.sleep(3000); // simulates time taken to download
            System.out.println("Download completed.");
        } catch (InterruptedException e) {
            System.out.println("Download interrupted!");
        }
    }
}
