package com.a_oops_contd.b_object;


/**
 * every class that we create inherits from Object class
 */
public class UserInfo {


     boolean isActive;

    @Override
    public String toString() {
        return "Inside userInfo";
    }

    /**
     * -----------------------------------------------
     *     h1     |           |          |               |
     * -----------------------------------------------
     * @param args
     */

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        System.out.println(userInfo);
    }

    /**
     *
     * Memory mapping
     *
     *      Heap Memory and stack memory
     *
     *      memory that is being initialized when JVM starts
     *      Objects --> heap memory
     *              -------------> Garbage Collections && Young and Old generations
     *
     *
     *      Stack Memory
     *          ---> temporary memory where variables are stored and when their methods are invoked
     *          -- reference of the objects
     *
     *
     *      Java is PASS BY VALUE
     *          Not Pass by reference
     *
     */

    public static class Memory {
                                                               // --- JRE would create a stack memory
        public static void main(String[] args) {        //1
            int temp = 1;                               //2         -----> stack memory   (
            Object object = new Object();               //3         ------> heap memory (reference to the stack)
            Memory memory = new Memory();               //4         ------> heap memory (reference is stored to stack)
            memory.printObject(object);                 //5

        }                                               // end of main

        private void printObject(Object input){         //6         --> a new refence is created -- non primitive type
            String print = input.toString();            //7         --> a new string in spring pool (the heap space)
            // -- stack
            System.out.println(print);                  //8
        }


        public  static class Balloon {
            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            String color ;

            @Override
            public String toString() {
                return "Balloon{" +
                        "color='" + color + '\'' +
                        '}';
            }
        }


//        public static void main(String[] args) {                    // HEAP                 STACK 1
//            Balloon red = new Balloon();                            // ()            ---->
//            red.setColor("RED");                                    //  (RED)           ----> red
//            Balloon blue = new Balloon();                           // ()            ---->
//            blue.setColor("BLUE");                                  // (BLUE)            ----> blue
//            System.out.println(red + " " + blue);                   //
//            System.out.println(swapBalloon(red, blue));                                 //
//            System.out.println(red + " " + blue);                   // same as 90
//
//        }

                                                                    //                      Stack 2
        private static String swapBalloon(Balloon red, Balloon blue){    //     (Red) (Blue)     ---> red2 , blue2
            Balloon temp    = red;                                   //      (Red)  ---------> temp
//            red.setColor("VIOLET");                                 //
            red = blue;                                                //      (Blue)       ------> red2
            blue = temp;                                              //    (Red)   ---------> blue2
            return red + " " + blue;
        }


    }


    /**
     *
     *
     *
     *
     */


}
