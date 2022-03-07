package com.a_functional_interface.d_streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     *
     * Given an array
     *          of intergers lets filter
     *              even numbers
     *
     *              and convert only the first two  to cube and return the result
     *
     *
     */


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> desiredOutput = new LinkedList<>();
        int  count = 0;
        for(Integer num : numbers){
            if(num % 2 == 0){
                desiredOutput.add(num*num*num);
                count++;
            }
            if(count == 2){
                break;
            }
        }

        System.out.println(desiredOutput);


        List<Integer> output = numbers.stream()
                .filter(i -> {
                    System.out.println(" inside filter " + i);
                    return i % 2 == 0;
                })
                .map(integer -> {
                    System.out.println(" cubing it" + integer);
                    return integer*integer*integer;
                })
                .limit(2)
                .collect(Collectors.toList());

        /**
         *
         * stream opertates in a kind of pipeline or a factory
         *      (raw) --> middle output --> refined --> given the desired result
         *
         *
         */
        /**
         *         List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
         * the possible output
         *  (A) : inside filter , insidefilter , cubing it, insidefilter, insidefilter, cubing it
         *
         *  (B) : inside filter, inside filter, inside filter, inside filter, cubing it, cubing it
         *
         * (C) :  inside filter, inside filter, inside filter, inside filter,inside filter, inside filter , cubing it,
         * cubing it, cubing it
         *
         */

        System.out.println(output);
    }




}
