package com.easyconcept.session7.builder;

public class TransactionMain {
    public static void main(String[] args) {
        Transaction transaction = new Transaction
                .Builder("transId-1", 24500000.45, "withdraw")
                .setDescription("Withdrawal")
                .setSenderAccount("0172505272")
                .setRecipientAccount("7064655983")
                .build();
        System.out.println(transaction.toString());

        Transaction transaction1 = new Transaction
                .Builder("transId-2", 12345678.34, "transfer")
                .setSenderAccount("0172505272")
                .build();
        System.out.println(transaction1);


    }
}
