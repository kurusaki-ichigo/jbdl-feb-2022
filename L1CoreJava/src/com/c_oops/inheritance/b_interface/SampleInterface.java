package com.c_oops.inheritance.b_interface;

public interface SampleInterface {
    /**
     * is keyword is not an accessmodifier
     *
     * @param a
     * @return
     */
    default String returnMethodArgument(String a){
        return a;
    }

    default double returnMethodArgumentsSum(double a, double b){
        return a + b;
    }

    static double returnArea(double a, double b){
        return a* b;
    }

}
