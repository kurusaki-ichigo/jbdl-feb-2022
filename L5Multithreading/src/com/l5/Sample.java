package com.l5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Sample {


    public static void main(String[] args) throws InterruptedException {
        /**
         * executor service -- priving a pool of threads
         */


        ExecutorService executorService = Executors.newFixedThreadPool(
                /**
                 *  ??
                 */
                Runtime.getRuntime().availableProcessors() - 1
        );

        /**
         * Tennis
         *  A 3 ---> {  1, 4, 5, 0  }
         *
         *  B
         *
         */


        List<Integer> inputList = Arrays.asList(600000, 800000, 1000000, 120000, 700000, 500000, 400000, 900000, 300000,
                                                1000000);

//        List<Integer> inputList = Arrays.asList(10);
//

        LocalDateTime startTime = LocalDateTime.now();
        /**
         * submitting  task
         */
        List<Future<List<Integer>>> futures = new LinkedList<>();
        inputList.stream().forEach(
                input -> {
                    futures.add(
                            executorService.submit(() -> firstNPrimeNumbers(input))
                    );
                }
        );


        /**
         *
         * 4 parallel threads
         *
         *  1.get --> 10 second
         *  2 took 5 seconds
         *  3 -0-> 15 seconds
         *  4 --> 9 seconds
         *
         *
         */
//        futures.stream().forEach(future -> {
//            try {
//                List<Integer> integers = future.get();
//                System.out.println(
//                        Thread.currentThread()
//                                +  " output computed " + (
//                                Objects.isNull(
//                                        integers) || integers.isEmpty() ? " false " :
//                                        "true")
//                                + " is Deamon " + Thread.currentThread().isDaemon()
//                );
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        });





//        submitTask(executorService, inputList);
        /**
         * blocking statement
         */
        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        /**
         * log time
         */
        logTime(startTime);

        /**
         * this is important as application wont exit
         */
//        executorService.shutdown();
        System.out.println(Thread.currentThread() + " is Deamon " + Thread.currentThread().isDaemon());

    }

    private static void logTime(LocalDateTime startTime) {
        LocalDateTime endTime = LocalDateTime.now();
        Duration between = Duration.between(startTime, endTime);
        System.out.println(" Time taken in seconds " + between.getSeconds());
    }

    private static void submitTask(ExecutorService executorService, List<Integer> inputList) {
        inputList.stream().forEach(
                input -> executorService.submit(() ->
                                                {
                                                    List<Integer> integers = firstNPrimeNumbers(input);
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



    public static List<Integer> firstNPrimeNumbers(int input) {
        List<Integer> primeNumberList = new LinkedList<>();
        int count = 0;
        Integer result = 2;
        while (true) {
            if (count >= input) {
                break;
            }
            if (isPrime(result)) {
                primeNumberList.add(result);
                count++;
            }
            result++;
        }

//        Integer result = 2;
//        for (int i = 0; i < input; i++) {
//            while (count <= i) {
//                if (isPrime(result)) {
//                    primeNumberList.add(result);
//                    count++;
//                }
//                result += 1;
//            }
//        }
        return primeNumberList;
    }


    /**
     * checks whether the given number is prime or not
     *
     * @param input
     * @return
     */
    static boolean isPrime(int input) {
        if (input <= 1) {
            return false;
        } else if (input == 2) {
            return true;
        } else if (input % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(input); i += 2) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }



}
