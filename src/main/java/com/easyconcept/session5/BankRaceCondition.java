package com.easyconcept.session5;

public class BankRaceCondition{
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        /*
        you're creating an instance of an anonymous class that implements the
        interface behind the scenes.

        But this only works for a functional interface. like Runnable
        so on this line Runnable withdrawTask = () -> account.withdraw(Thread.currentThread().getName(), 20000);
        i get An object of a class (unnamed) that implements the functional interface,
         and whose only method is implemented by the lambda.

         This could have been a class called WithdrawTask with a method impl called run
         that
         */
        Runnable withdrawTask = () -> account.withdraw(Thread.currentThread().getName(), 20000);

        Thread t1 = new Thread(withdrawTask, "Thread-A");
        Thread t2 = new Thread(withdrawTask, "Thread-B");

        t1.start();
        t2.start();
    }
}
