package com.easyconcept.session7.assignment;

public class BankPolicyManager {
    private static BankPolicyManager instance;
    private double interestRate;
    private double transactionFee;
    private String supportedCurrency;

    // private constructor available only within the class
    private BankPolicyManager(){
        this.interestRate = 10.00;
        this.transactionFee = 52.56;
        this.supportedCurrency = "NGN";
    }

    // Factory function
    public static synchronized BankPolicyManager getInstance() {
        if(instance == null) instance = new BankPolicyManager();
        return instance;
    }

    public static void setInstance(BankPolicyManager instance) {
        BankPolicyManager.instance = instance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public String getSupportedCurrency() {
        return supportedCurrency;
    }

    public void setSupportedCurrency(String supportedCurrency) {
        this.supportedCurrency = supportedCurrency;
    }


}
