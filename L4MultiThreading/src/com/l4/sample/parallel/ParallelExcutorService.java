package com.l4.sample.parallel;

import com.l4.sample.PrimeSequential;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ParallelExcutorService {

    public static void main(String[] args) throws InterruptedException {
        /**
         * executor service -- priving a pool of threads
         */
        ExecutorService executorService = Executors.newFixedThreadPool(
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
                                executorService.submit(() -> PrimeSequential.firstNPrimeNumbers(input))
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
        futures.stream().forEach(future -> {
            try {
                List<Integer> integers = future.get();
                System.out.println(
                        Thread.currentThread()
                                +  " output computed " + (
                                Objects.isNull(
                                        integers) || integers.isEmpty() ? " false " :
                                        "true")
                                + " is Deamon " + Thread.currentThread().isDaemon()
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });





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
        executorService.shutdown();
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
                                                    List<Integer> integers = PrimeSequential.firstNPrimeNumbers(input);
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


    static class DemoThread implements Runnable {
        int input;
        List<Integer> result;

        public DemoThread(int number) {
            this.input = number;
        }

        boolean isResultNull() {
            return Objects.isNull(result) || result.size() == 0;
        }

        @Override
        public void run() {
            System.out.println(" inside the thread {} " + Thread.currentThread() + " value " + input);
            this.result = PrimeSequential.firstNPrimeNumbers(input);
            System.out.println("Byee byee " + Thread.currentThread() + " value "
                                       + input + " is result null :: " + isResultNull());
        }
    }


}
