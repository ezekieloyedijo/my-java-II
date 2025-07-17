package com.easyconcept.session7.assignment;

public class LoanCalculator {
    public void calculateLoanInterest(double loanAmount) {
        BankPolicyManager policy = BankPolicyManager.getInstance();
        double rate = policy.getInterestRate();
        double interest = loanAmount * rate / 100;
        System.out.println("Loan Amount: " + loanAmount + " " + policy.getSupportedCurrency());
        System.out.println("Interest (" + rate + "%): " + interest);
    }
}
