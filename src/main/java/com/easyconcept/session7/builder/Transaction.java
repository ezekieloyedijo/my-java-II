package com.easyconcept.session7.builder;

public class Transaction {
    private final String transactionId;
    private final double amount;
    private final String type;

    private final String currency;
    private final String recipientAccount;
    private final String senderAccount;
    private final String description;
    private final boolean isSuccessful;


    // The constructor the build class will call
    // in the Builder class
    private Transaction(Builder builder){
        this.transactionId = builder.transactionId;
        this.amount = builder.amount;
        this.type = builder.type;
        this.currency = builder.currency;
        this.recipientAccount = builder.recipientAccount;
        this.senderAccount = builder.senderAccount;
        this.description = builder.description;
        this.isSuccessful = builder.isSuccessful;
    }

    public Builder toBuilder(){
        return new Builder(this);
    }

    public static class Builder {
        private final String transactionId;
        private final double amount;
        private final String type;

        private String currency = "NGN";
        private String recipientAccount;
        private String senderAccount;
        private String description;
        private boolean isSuccessful = false;

        public Builder(Transaction transaction){
            this.transactionId = transaction.transactionId;
            this.amount = transaction.amount;
            this.type = transaction.type;
            this.currency = transaction.currency;
            this.recipientAccount = transaction.recipientAccount;
            this.senderAccount = transaction.senderAccount;
            this.description = transaction.description;
            this.isSuccessful = transaction.isSuccessful;
        }

        public Builder(String transactionId, double amount, String type){
            this.transactionId = transactionId;
            this.amount = amount;
            this.type = type;
        }

        public Builder setRecipientAccount(String recipientAccount) {
           this.recipientAccount = recipientAccount;
           return this;
        }

        public Builder setSenderAccount(String senderAccount) {
           this.senderAccount = senderAccount;
           return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    @Override
    public String
    toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", currency='" + currency + '\'' +
                ", recipientAccount='" + recipientAccount + '\'' +
                ", senderAccount='" + senderAccount + '\'' +
                ", description='" + description + '\'' +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
