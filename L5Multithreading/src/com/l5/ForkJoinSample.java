package com.l5;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {


    public static void main(String[] args) {

        ExecutorService forkJoinPool = new ForkJoinPool();


        List<Integer> inputList = Arrays.asList(600000, 800000, 1000000, 120000, 700000, 500000, 400000, 900000, 300000,
                                                1000000);



        submitTask(forkJoinPool, inputList);
    }

    private static void submitTask(ExecutorService executorService, List<Integer> inputList) {
        inputList.stream().forEach(
                input -> executorService.submit(() ->
                                                {
                                                    List<Integer> integers = Sample.firstNPrimeNumbers(input);
                                                    System.out.println(
                                                            Thread.currentThread()
                                                                    + " value " + input + " output computed " + (
                                                                    Objects.isNull(
                                                                            integers) || integers.isEmpty() ? " false " :
                                                                            "true")
                                                                    + " is Deamon " + Thread.currentThread().isDaemon()
                                                    );
                                                }
                ));
    }
}
