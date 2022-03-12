package com.a_functional_interface.a_lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {


    /**
     *
     * Few transactions that have been made to your credit card
     *  100 inr donation
     *  500 shopping
     *  200 groceries
     *  100 Movie
     *  1000 donations
     *  300 groceries
     *  2000 donations
     *
     *
     * find all the transactions of type donations and return the list of transactionIds
     *  in the decreasing order of their value
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Transaction> creditCardTransactions = Arrays.asList(
                new Transaction(100, TransactionType.DONATIONS),
                new Transaction(500, TransactionType.SHOPPING),
                new Transaction(200, TransactionType.GROCERY),
                new Transaction(100, TransactionType.MOVIE),
                new Transaction(1000, TransactionType.DONATIONS),
                new Transaction(300, TransactionType.GROCERY),
                new Transaction(2000, TransactionType.DONATIONS)
                );

//             * find all the transactions of type donations and return the list of transactionIds
//                *  in the decreasing order of their value

        List<Transaction> donationTransaction  = new LinkedList<>();
        /**
         * filter by transaction type
         */
        for(Transaction transaction : creditCardTransactions){
            if(transaction.getTransactionType() == TransactionType.DONATIONS){
                donationTransaction.add(transaction);
            }
        }

        /**
         *  sort the transactions in decreasing order of their value
         */
        Collections.sort(donationTransaction, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        /**
         * collect the transaction ids
         */
        List<Double> transactionIds = new LinkedList<>();
        for(Transaction transaction : donationTransaction){
            transactionIds.add(transaction.getId());
        }
        // 69 - 43 - 9 = 69 - 52 = 17
        System.out.println(" The transactionIds " + transactionIds);

        //n 79 - 74 = 5
        List<Double> creditCardTransactionIds =
                creditCardTransactions.stream().filter(t -> t.getTransactionType() == TransactionType.DONATIONS)
                        .sorted(Comparator.comparing(Transaction::getValue).reversed())
                        .map(Transaction::getId)
                        .collect(Collectors.toList());
        System.out.println("--------------");
        System.out.println(creditCardTransactionIds);
        /**
         * find all the transactions of type donations and return the list of transactionIds
         *  in the decreasing order of their value
         *
         *                  (Predicate)         Comparator      Function            reduce operation to collect
         * transactions --> filter -->          sorted -->       map -->            collect
         *
         */
            









    }

}
