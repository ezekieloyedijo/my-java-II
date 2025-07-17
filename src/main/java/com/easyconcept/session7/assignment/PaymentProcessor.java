package com.easyconcept.session7.assignment;

public class PaymentProcessor {
    public void processPayment(double amount) {
        BankPolicyManager policy = BankPolicyManager.getInstance();
        double total = amount + policy.getTransactionFee();
        System.out.println("Base Amount: " + amount + " " + policy.getSupportedCurrency());
        System.out.println("Transaction Fee: " + policy.getTransactionFee());
        System.out.println("Total Deducted: " + total);
    }
}
