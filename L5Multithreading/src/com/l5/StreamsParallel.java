package com.l5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class StreamsParallel {


    /**
     *
     * Input array [1,2,3,4,5,6,7,8,9,10]
     *
     * find the even number
     *  compute its square
     *      add them to get the desired result..
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        /**
         * 221
         *
         */
//        System.out.println(inputList.stream().filter( x -> {
//            System.out.println("inside filter ::  for [" + x + "] "+ Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
//            return  x % 2 == 0;
//        }).map( x -> {
//            System.out.println("inside map :: for [" + x + "] " + Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
//            return x * x;
//        })
//
//                                   /**
//                                    *   reduce operation
//                                    *       (identity + other number)
//                                    *       (1 + 4 = 5)
//                                    *        (5 + 16 = 21)
//                                    *        (21 + 36 = 57)
//                                    *        (57 + 64 = 121)
//                                    *        (121 + 100 = 221)
//                                    */
//
//                                   .reduce(1 , (x , y ) -> {
//            System.out.println("inside reduce ::  for [" + x + " " + y + "] " + Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
//            return x + y;
//        }));





        /**
         * parallelStreams takes the ForkJoin.common pool -- it has main thread is the part
         */

        /**
         * if reduce identity is 0
         * <these two wont be the answer></>
         * 221
         * 230
         * -- derministic but not sure on value
         * 220
         *

         * if reduce identity is 1
         *  (depends on the elements of the thread but not on the number of threads of the thread pool)
         *
         * 230 (output)
         * 225
         * -- derministic but not sure on value
         * 254
         *
         */


//        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
//        System.out.println(forkJoinPool.submit(() -> {
//            return inputList.parallelStream().filter( x -> {
////                    System.out.println("inside filter ::  for [" + x + "] "+ Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
//                        return  x % 2 == 0;
//                    }).map( x -> {
////                    System.out.println("inside map :: for [" + x + "] " + Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
//                        return x * x;
//                    })
//                    /**
//                     *
//                     * W7 (0, 4) = 4
//                     * W15 (0, 16) =  W7 (16 4) == 20
//                     * T3 (0,36) = 36
//                     *
//                     *        (4)
//                     *        (16)
//                     *        (36)
//                     *        (64)
//                     *        (100)
//                     *
//                     *        220
//                     */
//                    .reduce(1 , (x , y ) -> {
//                        System.out.println("inside reduce ::  for [" + x + " " + y + "] ");
//                        return x + y;
//                    });
//        }).get());

        /**
         * parallel stream and
         * .parallel
         */

        /**
         *
         * (4)
         * filter main , map Forkjoinpool , reduce main
         * filter main , map Forkjoinpool , reduce Forkjoinpool
         * filter main , map main , reduce main
         * filter Forkjoinpool , map Forkjoinpool , reduce Forkjoinpool
         */
        System.out.println(inputList.parallelStream()
                                   .filter( x -> {
                    System.out.println("inside filter ::  for [" + x + "] "+ Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
                    return  x % 2 == 0;
                })
                                   .parallel()
                                   .map( x -> {
                    System.out.println("inside map :: for [" + x + "] " + Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
                    return x * x;
                })
                                   /**
                                    *
                                    * W7 (0, 4) = 4
                                    * W15 (0, 16) =  W7 (16 4) == 20
                                    * T3 (0,36) = 36
                                    *
                                    *        (4)
                                    *        (16)
                                    *        (36)
                                    *        (64)
                                    *        (100)
                                    *
                                    *        220
                                    */
                .reduce(1 , (x , y ) -> {
                    System.out.println("inside reduce ::  for [" + x + " " + y + "] "  + Thread.currentThread() );
                    return x + y;
                })
        );





    }
}
