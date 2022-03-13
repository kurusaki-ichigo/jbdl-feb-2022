package com.l4.sample;

public class PrimeMultiThreadedRunnable {

    public static void main(String[] args) {

        DemoThread demoThread = new DemoThread();
        Thread myThread = new Thread(demoThread);

        /**
         *
         */

        Thread newThread = new Thread(new Runnable() {
            /**
             * annomous inner class
             */
            @Override
            public void run() {
                System.out.println(" newThread " + Thread.currentThread());

            }
        });


        System.out.println("shorter " + (new Thread(() -> System.out.println("shorter" + Thread.currentThread()))));

        newThread.start();
        myThread.start();
        System.out.println(" Main " + Thread.currentThread());


    }


    public static void printDescription() {
        System.out.println("shorter" + Thread.currentThread());
    }


    /**
     * funcations
     * ---- one abstract method
     */
    static class DemoThread implements Runnable {
//        int input;
//        List<Integer> result;

//        public DemoThread(int number) {
//            this.input = number;
//        }
//        boolean isResultNull(){
//            if(Objects.isNull(result) || result.size() == 0)
//                return true;
//            return false;
//        }

        @Override
        public void run() {
//        System.out.println(" inside the thread {} " + Thread.currentThread() + " value " + input);
//        this.result = PrimeSequential.firstNPrimeNumbers(input);
//        System.out.println("Byee byee " + Thread.currentThread() + " value "
//                                   + input + " is result null :: " + isResultNull());
        }
    }


//    public void run() {
//        /**
//         * demo
//         */
//        System.out.println(" inside the thread {} " + Thread.currentThread() + " value " + input);
//        this.result = PrimeSequential.firstNPrimeNumbers(input);
//        System.out.println("Byee byee " + Thread.currentThread() + " value "
//                                   + input + " is result null :: " + isResultNull());
//    }

}
