package com.easyconcept.session4.threads;

public class LoadingSpinnerTask implements Runnable{
    @Override
    public void run() {
        String[] spinner = {"|", "/", "-", "\\"};
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.print("\rCopying file " + spinner[i % spinner.length]);
            i++;
            try {
                Thread.sleep(300); // simulate spinner refresh
            } catch (InterruptedException e) {
                break; // exit if interrupted
            }
        }
    }
}
