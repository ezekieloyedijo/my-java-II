package com.easyconcept.session4.simplethread;

public class ThreadDemo {
    public static void main(String[] args) {
        // Create thread objects
        DownloadTask download = new DownloadTask();
        MusicTask music = new MusicTask();
        TypingTask typing = new TypingTask();
        UpdateCheckTask update = new UpdateCheckTask();

        // Start all threads (they move from NEW → RUNNABLE → RUNNING)
        download.start();
        music.start();
        typing.start();
        update.start();

        // Check if threads are alive
        System.out.println("Download thread alive? " + download.isAlive());
        System.out.println("Music thread alive? " + music.isAlive());

        try {
            // Wait for all threads to finish
            download.join();
            music.join();
            typing.join();
            update.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }

        System.out.println("All tasks completed!");
    }
}
