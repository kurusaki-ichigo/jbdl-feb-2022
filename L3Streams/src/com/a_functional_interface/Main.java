package com.a_functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {


    /**
     * create an instance of interface
     * @param args
     */
    public static void main(String[] args) {
        /**
         * anonymous class
         */
        IDemoInterface demoInterface = new IDemoInterface() {
            @Override
            public List<String> getUserRoles() {
                return Arrays.asList("STUDENT", "ADMIN");
            }


        };

        /**
         * lambda expression
         *  - is used to provide the implementation of the interface which has the functional interface....
         *  in case of it -- we do not have  to define the method again for providing the implementation
         *
         */
        IDemoInterface demoInterface2 = () -> Arrays.asList("EMPLOYEE");


//        System.out.println(demoInterface.getUserRoles());
//        System.out.println(demoInterface2.getUserRoles());

        /**
         * whats basically a lambda
         * (argument list) -> {body associated}
         *
         */
        IDemoInterface demoInterface3 = () -> Arrays.asList("EMPLOYEE");

        ILogger logger = () -> System.out.println("Hello World");

//        logger.print();


        /**
         * Creating a thread
         * -        Different ways to create a thread ???
         * extends Thread
         * implementing Runnable interface
         *
         */

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside runnable using annonymoous");
            }
        };

//        Thread thread = new Thread(r1);
//
//        thread.start();


        Runnable r2 = () ->   System.out.println("Inside runnable using lambda");

//        Thread thread2 = new Thread(r2);
//        thread2.start();

        /**
         * add two numbers using a lambda
         * (argument list) -> {body associated}
         * (a, b) -> {a, b};
         */
        IAddition addition = (a, b) -> {  return a + b;};

//        System.out.println(addition.add(2, 5));

        /**
         * functional interfaces ->
         * (argument list) -> {body associated}
         *  Consumer functional interface -->
         *  Supplier -->
         *  Functions -->
         */
        // llog the input number
        Consumer<Integer> consumer = (arg) -> {
            System.out.println(arg);
        };

        consumer.accept(100);

        Supplier<Double> supplier = () -> {
            return Math.random();
        };

        System.out.println(supplier.get());
        // return a square of a numnber
        Function<Integer, Integer> squareFunction = (i) -> {
            return i * i;
        };

        System.out.println(squareFunction.apply(10));

        /**
         * streams == a sequence of objects that supports variable methods which can be pipelined
         *  to produce the desired result
         *      -- not a DS instead  it takes data from collections , arrays , I/O channels
         *          they do not change the original data structre
         */








    }
}
