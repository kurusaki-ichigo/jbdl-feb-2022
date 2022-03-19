package com.l5;

import java.util.Arrays;
import java.util.List;

public class ComparisonBetweenStreams {


    public static void main(String[] args) {

        /**
         *
         *  Q parallelStream outperform sequentialStreams
         *  (A)    - (always)
         *   (C)   - may be
         *
         * - may be
         *  - always
         *          (Y --- task divided into chunks)
         *
         *          Depends --- on the kind of problem being solved
         *                  -----------> compute intensive -- obviously parllelStream would outperform
         *                          ---(computing 600 , 000) prime nos
         *              ------> if not compute intensive
         *                                  --------------->
         *                                 lets say find the first odd number in the list


         List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
         *
         *          in case of parallell
         *
         *
         *
         *
         */

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /**
         * ForkJoinPool.commonPool
         * 7 worker threads (9, 15, 5, 7, 3, 11, 13)
         * 1 main thread
         *
         */
        System.out.println(integers.stream().parallel()
                .filter(x -> {
                    System.out.println("inside filter ::  for [" + x + "] "+ Thread.currentThread() + " isDeamon " + Thread.currentThread().isDaemon());
                    if(x%5 == 0 && x%2  == 0){
                        return true;
                    }
                    return false;
                })
                .findFirst().orElseThrow(RuntimeException::new));
    }
}
