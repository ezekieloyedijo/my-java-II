package com.easyconcept.session4;

import com.easyconcept.session4.threads.FileCopyTask;
import com.easyconcept.session4.threads.LoadingSpinnerTask;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path source = Path.of("blouse-4-back.webp");
        Path destination = Path.of("copy-blouse-4-back.webp");

        // Create threads
        Thread copyThread = new Thread(new FileCopyTask(source, destination));
        Thread spinnerThread = new Thread(new LoadingSpinnerTask());

        // Start spinner before copying this calls the run method
        spinnerThread.start();
        copyThread.start();

        try {
            copyThread.join(); // wait for file copy to complete
            spinnerThread.interrupt(); // stop the spinner
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("\nAll tasks done.");

    }
}
