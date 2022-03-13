package com.l4.sample;

/**
 *
 *
 * Functional interfaces
 * Lambda
 * Streams ()
 *  -   why the stream () ---
 *
 */
public class Sample {

    /**
     *
     * Async vs Parallel Vs Concurrent Programming
     *
     *  Can I eat and sing simultaneously
     *      (not possible)
     *  perhaps
     *  Can I eat food and listen to the music as
     *      (possible)
     *
     * - Parallel
     *      - multi threading in which we are doing things in parallel
     *      deterministic
     *           *  Can I eat food and listen to the music as
     *
     *  - Concurent
     *       *  Can I eat and sing simultaneously
     *
     *
     *  -- Async / Callbacks
     *          process is happing in the background and the normal execution is not interrupted
     *
     *
     *
     * Processsor and Thread
     *
     *  - processor -- computing power .. having cores to compute....
     *
     *      One processor
     *      -T1   -T2   -T3   -T4   -T1
     *      (concurrent programming) -- context switching happens to the order to milli seconds
     *              -- its not visible to the end user --- > it appears as if the tasks are executing parallel.
     *
     *
     *      Thread
     *          --> a light weight program
     *          ----> ONly one thread can run in one core at a given time
     *
     *
     *
     *
     *
     *      Task generally are
     *          --- I/O expensive
     *          -- compute expensive
     *
     *
     *         ---> webservice
     *
     *         // wallet
     * @Secured("STUDENT")
     *        POST  /payment/          {{toUserId : 1234 , amout :10 }}
     *          background process
     *
     *                  --->first checking if the user exists or not (DB)
     *                          --> authenticating and authorizing that user  (if the user is present)
     *                                          ---->
     *                                          check own wallet --> sufficient funds or not (DB) -- {wallet
     *                                          information of the user }
     *                                            ---> increase the wallet amount of the user with id 1234 + 10
     *
     *
     *         |||| ----> SERVER -->    get the wallet data from the DB --------> DB
     *              (validating)
     *                                                     validating <---------
     *
     *                                                     crediting ------the merchant---> DB
     *                                                     (OK)<----------------------------DB
     *                           <---------------------------
     *             <-----
     *
     *
     *
     *  Let intellij 4 processors
     *
     *      we are processing in a single threaded environment
     *      used    - 1
     *      idle    - 3
     *
     *      Program
     *          - generate a file in 5 seconds
     *          (4 such files with random characters)
     *              -------> how much time --- > 20 seconds
     *
     *          --> idle processor --> make use of them
     *             4 * - a single thread running in one core
     *          (4 such files with random characters)
     *              -------> how much time --- > 5 seconds seconds
     *

     *          (40 such files with random characters)
     *          single -- how much time --              vs parllel
     *          (40 * 5 == 200 seconds)                50 for parallel (40 * 5/4) = 50 seconds
     *
     *      benefits for this
     *          - active task processing being faster overall
     *          -  monitor the progressing


     *          ------------------------
     *      T1              T2
     *          ------------------------
     *             T2 is dependent on T1 --> benefits ?
     *
     *
     *
     *  Let intellij 4 processors
     *
     *      two threads
     *        T1  -> priority of 8
     *        T2  -> priority of 5
     *
     *      T1 will run first then t2
     *      Thread scheduler will decide --> if t1 has been done then t2
     *      Opposite
     *
     *      hint -- how processors ---> 4
     *      one thread can run --> at a time --> 1
     *
     *
     *
     *


     *
     */


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());








    }


}
