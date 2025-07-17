package com.easyconcept.session7.assignment;

public class AppSimulation {
    public static void main(String[] args) {
        System.out.println("=== Initial Settings ===");
        new LoanCalculator().calculateLoanInterest(100_000);
        new PaymentProcessor().processPayment(5_000);

        // Central policy updated by admin
        System.out.println("\n=== Admin Updates Bank Policy ===");
        BankPolicyManager adminPolicy = BankPolicyManager.getInstance();
        adminPolicy.setInterestRate(8.0);
        adminPolicy.setTransactionFee(25.0);
        adminPolicy.setSupportedCurrency("USD");

        // Reuse same classes, see updated values
        System.out.println("\n=== Updated Settings Reflected ===");
        new LoanCalculator().calculateLoanInterest(100_000);
        new PaymentProcessor().processPayment(5_000);
    }
}
