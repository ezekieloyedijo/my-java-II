package com.easyconcept.session5;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 30000;
    //private ReentrantLock lock = new ReentrantLock(); // solution 2

    /*
     solution 1 :
     public synchronized
     Solution 2:
     Add ReentrantLock and remove synchronize
     lock.lock(); before the try block in the withdraw function
     Then wrap every thing in the if and else block in a try block no catch block
     Then in the finally block release the lock lock.unlock();
    */
    public synchronized void withdraw(String threadName, int amount) {
        System.out.println(threadName + " checking balance: ₦" + balance);
        if (balance >= amount) {
            System.out.println(threadName + " preparing to withdraw ₦" + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(threadName + " completed withdrawal. New balance: ₦" + balance);
        } else {
            System.out.println(threadName + " - Insufficient funds. Withdrawal denied.");
        }
    }
}
