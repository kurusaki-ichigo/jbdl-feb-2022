package com.l4.sample;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * implementing a runnable interface or
 * extending
 * Thread class
 */

public class PrimeSequential {


    public static void main(String[] args) throws InterruptedException {
//        DemoThread demoThread = new DemoThread();
//        demoThread.start();
//        /**
//         * do some processing
//         */
//        Thread.sleep(1000);
//        System.out.println(Thread.currentThread());

        List<Integer> inputList = Arrays.asList(600000, 800000, 1000000, 120000, 700000, 500000, 400000, 900000,
                                                300000,
                                                1000000);
//        List<Integer> inputList = Arrays.asList(60000);

        LocalDateTime sequentialTime = LocalDateTime.now();
        inputList.stream().map(input -> {
            List<Integer> integers = firstNPrimeNumbers(input);
            System.out.println(" first " + input + " prime numbers " + integers);
            return integers;
        }).collect(Collectors.toList());

        LocalDateTime sequentialEndTime = LocalDateTime.now();

        Duration between = Duration.between(sequentialTime, sequentialEndTime);
        System.out.println("time taken " + between.getSeconds());


    }

    /**
     *
     * Compute heavy
     *  - we can have a mechanism where we are generating prime numbers (first n prime nos)
     *
     *
     */


    /**
     * for a given number returns those many prime numbers
     *
     * @param input
     * @return {@link List}Integers
     */
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


    /**
     * Always
     * Thread[main,5,main]
     * inside the demo thread {} Thread[Thread-0,5,main]
     * <p>
     * Or
     * Always
     * inside the demo thread {} Thread[Thread-0,5,main]
     * Thread[main,5,main]
     * <p>
     * Or
     * Maybe
     * Thread[main,5,main]
     * inside the demo thread {} Thread[Thread-0,5,main]
     * (unpredictable)
     */

    static class DemoThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" inside the demo thread {} " + Thread.currentThread());
        }
    }

}
