package com.easyconcept.session7.strategy;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public ShoppingCart(){}

    // set strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }

    // Without strategy pattern

//    private String paymentType; // "credit", "paypal", etc.
//
//    public ShoppingCart(String paymentType) {
//        this.paymentType = paymentType;
//    }
//    public void checkout1(int amount) {
//        if (paymentType.equalsIgnoreCase("credit")) {
//            System.out.println("Paid " + amount + " using Credit Card.");
//        } else if (paymentType.equalsIgnoreCase("paypal")) {
//            System.out.println("Paid " + amount + " using PayPal.");
//        } else if (paymentType.equalsIgnoreCase("bank")) {
//            System.out.println("Paid " + amount + " using Bank Transfer.");
//        } else {
//            System.out.println("Unknown payment method!");
//        }
//    }
}
