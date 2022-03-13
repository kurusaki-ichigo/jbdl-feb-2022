package com.l4.sample;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class DeamonThreads {


    /**
     *
     /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=63191:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/pranavmiglani/repositories/jbdl-feb-2022/out/production/L4MultiThreading com.l4.sample.DeamonThreads
     inside the thread {} Thread[Thread-4,5,main] value 700000
     inside the thread {} Thread[Thread-6,5,main] value 400000
     inside the thread {} Thread[Thread-3,5,main] value 120000
     inside the thread {} Thread[Thread-7,5,main] value 900000
     inside the thread {} Thread[Thread-2,5,main] value 1000000
     inside the thread {} Thread[Thread-5,5,main] value 500000
     inside the thread {} Thread[Thread-0,5,main] value 600000
     inside the thread {} Thread[Thread-1,5,main] value 800000
     inside the thread {} Thread[Thread-9,5,main] value 1000000
     inside the thread {} Thread[Thread-8,5,main] value 300000
     Thread-0 output true isDeamon true
     Thread-1 output true isDeamon true
     Thread-2 output true isDeamon true
     Thread-3 output true isDeamon true
     Thread-4 output true isDeamon true
     Thread-5 output true isDeamon true
     Thread-6 output true isDeamon true
     Thread-7 output true isDeamon true
     Thread-8 output true isDeamon true
     Thread-9 output true isDeamon true
     Byye byyeee main thread {} Thread[main,5,main] isDeamon false
     Time taken 0

     Process finished with exit code 0
     *
     * @param args
     */

    /**
     *
     inside the thread {} Thread[Thread-7,5,main] value 900000
     inside the thread {} Thread[Thread-6,5,main] value 400000
     inside the thread {} Thread[Thread-8,5,main] value 300000
     inside the thread {} Thread[Thread-2,5,main] value 1000000
     inside the thread {} Thread[Thread-0,5,main] value 600000
     inside the thread {} Thread[Thread-3,5,main] value 120000
     inside the thread {} Thread[Thread-5,5,main] value 500000
     inside the thread {} Thread[Thread-4,5,main] value 700000
     inside the thread {} Thread[Thread-1,5,main] value 800000
     inside the thread {} Thread[Thread-9,5,main] value 1000000
     Thread-0 output true isDeamon false
     Thread-1 output true isDeamon false
     Thread-2 output true isDeamon false
     Thread-3 output true isDeamon false
     Thread-4 output true isDeamon false
     Thread-5 output true isDeamon false
     Thread-6 output true isDeamon false
     Thread-7 output true isDeamon false
     Thread-8 output true isDeamon false
     Thread-9 output true isDeamon false
     Byye byyeee main thread {} Thread[main,5,main] isDeamon false
     Time taken 0
     Byee byee Thread[Thread-3,5,main] value 120000 is result null :: false
     Byee byee Thread[Thread-8,5,main] value 300000 is result null :: false
     Byee byee Thread[Thread-6,5,main] value 400000 is result null :: false
     Byee byee Thread[Thread-5,5,main] value 500000 is result null :: false
     Byee byee Thread[Thread-0,5,main] value 600000 is result null :: false
     Byee byee Thread[Thread-4,5,main] value 700000 is result null :: false
     Byee byee Thread[Thread-1,5,main] value 800000 is result null :: false
     Byee byee Thread[Thread-7,5,main] value 900000 is result null :: false
     Byee byee Thread[Thread-9,5,main] value 1000000 is result null :: false
     Byee byee Thread[Thread-2,5,main] value 1000000 is result null :: false
     *
     * @param args
     */







    public static void main(String[] args) {
        /**
         * would this work --- ???
         *
         * why ???
         */
        Thread.currentThread().setDaemon(true);


        List<Integer> inputList = Arrays.asList(600000, 800000, 1000000, 120000, 700000, 500000, 400000, 900000, 300000,
                                                1000000);



//        List<Integer> inputList = Arrays.asList(10, 1, 5, 7, 4,2);
        PrimeMultiThreaded.DemoThread[] threads = new PrimeMultiThreaded.DemoThread[inputList.size()];
        /**
         *
         */

        LocalDateTime parallelStartTime = LocalDateTime.now();
        IntStream.range(0, inputList.size())
                /**
                 * this will have numbers from 0 to size (1)
                 */
                .forEach(input -> {
                    threads[input] = new PrimeMultiThreaded.DemoThread(inputList.get(input));
//                    threads[input].setDaemon(true);
                    threads[input].start();
                });


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

//                    try {
//                        threads[input].join();
                        System.out.println(threads[input].getName() + " output " + threads[input].isResultNull()
                        + " isDeamon " + threads[input].isDaemon());
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                });

        LocalDateTime parallelEndTime = LocalDateTime.now();
        Duration between = Duration.between(parallelStartTime, parallelEndTime);


        /**
         * main
         */
        System.out.println(" Byye byyeee main thread {} " + Thread.currentThread() +
                                   " isDeamon " + Thread.currentThread().isDaemon());

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
                                       + input + " is result null :: " + isResultNull() + " isDeamon " + Thread.currentThread().isDaemon());
        }
    }
}
