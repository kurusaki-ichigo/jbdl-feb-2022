package com.l4.sample;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class PrimeMultiThreaded {

    public static void main(String[] args) {

        List<Integer> inputList = Arrays.asList(600000, 800000, 1000000, 120000, 700000, 500000, 400000, 900000, 300000,
                                                1000000);

        /**
         *  8 processors
         *      main thread --> is running on one of them
         *          7 empty
         *              --> 6 threads (main)
         *                          --> started them (main)
         *
         *         main-- output
         *
         *
         */


//        List<Integer> inputList = Arrays.asList(10, 1, 5, 7, 4,2);
        DemoThread[] threads = new DemoThread[inputList.size()];
        /**
         *
          */

        LocalDateTime parallelStartTime = LocalDateTime.now();
        IntStream.range(0, inputList.size())
                /**
                 * this will have numbers from 0 to size (1)
                 */
                .forEach(input -> {
            threads[input] = new DemoThread(inputList.get(input));
            threads[input].start();
        });

        /**
         *
         *     4 cores
         *
         *          7 threads having a higher priority
         *
         *
         *      1 main -- 1 core
         *          3 different -- 3 different cores
         *
         *   (single thread) = T(s)
         *  vs
         *  multi threadted
         *      T(m) = max( T(0) , ... T(i))
         *      provided that i (or threads) < no of cores
         *
         *      T(m)  = ??????????
         *      case if i > no of cores (?)
         *
         *      T(m) = sum  ( i % cores -- max( T(0) , ... T(i)))
         *      yes more time
         *
         *
          */


        /**
         * join method
         * blocking call
         *          -- your program will not move ahead untill the current thread (thread on which join is being
         *          called) completes
         *          the computation
         *
          */
        IntStream.range(0, inputList.size())
                /**
                 * this will have numbers from 0 to size (1)
                 */
                .forEach(input -> {

                    try {
                        threads[input].join();
                        System.out.println(threads[input].getName() + " output " + threads[input].isResultNull());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        LocalDateTime parallelEndTime = LocalDateTime.now();
        Duration between = Duration.between(parallelStartTime, parallelEndTime);


        /**
         * main
         */
        System.out.println(" Byye byyeee main thread {} " + Thread.currentThread());

        System.out.println(" Time taken " + between.getSeconds());

    }











    static class DemoThread extends Thread {

        int input;
        List<Integer> result;

        DemoThread(int input){
            this.input = input;
        }

        boolean isResultNull(){
            if(Objects.isNull(result) || result.size() == 0)
                return true;
            return false;
        }

        @Override
        public void run() {
            /**
             * demo
             */
            System.out.println(" inside the thread {} " + Thread.currentThread() + " value " + input);
           this.result = PrimeSequential.firstNPrimeNumbers(input);
            System.out.println("Byee byee " + Thread.currentThread() + " value "
                                       + input + " is result null :: " + isResultNull());
        }
    }
}
