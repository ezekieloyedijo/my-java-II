package com.easyconcept.session7.strategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
