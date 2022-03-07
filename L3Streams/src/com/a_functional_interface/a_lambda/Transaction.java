package com.a_functional_interface.a_lambda;


public class Transaction {

    /**
     * amount being charged
     */
    Integer value;

    TransactionType transactionType;

    double id;

    public Transaction(Integer value, TransactionType transactionType) {
        this.value = value;
        this.transactionType = transactionType;
        this.id = Math.random();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", transactionType=" + transactionType +
                ", id=" + id +
                '}';
    }


    public Integer getValue() {
        return value;
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getId() {
        return id;
    }
}
