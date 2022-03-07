package com.a_functional_interface.c_method_reference;

import com.a_functional_interface.b_example.CompareByName;
import com.a_functional_interface.b_example.UserInfo;
import com.a_functional_interface.c_method_reference.exampl.Movie;
import com.a_functional_interface.c_method_reference.exampl.MovieDao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * Some users
     * - and sort them on basis of their name
     *
     * @param args
     */
    public static void main(String[] args) {

        List<UserInfo> userInfos = Arrays.asList(
                new UserInfo("Miguel"),
                new UserInfo("Kurosaki"),
                new UserInfo("Mysterio"),
                new UserInfo("Joker")
        );

        // sort the names on basis of their name
        // sorting them on basis of their ids

//        Collections.sort(userInfos, new Comparator<UserInfo>() {
//            @Override
//            public int compare(UserInfo o1, UserInfo o2) {
//                return o1.getName().compareToIgnoreCase(o2.getName());
//            }
//        });
        /**
         * whats basically a lambda
         *
         *
         * (argument list) -> {body associated}
         *
         */
        Collections.sort(userInfos, (o1, o2) -> o2.getName().compareToIgnoreCase(o1.getName()));
//
        /**
         * method reference is --
         *  a lambda expression making a call to an existing method
         *
         *  static method reference
         *      (args) -> class.staticmethod(arfs)
         *
         *
         */
        Collections.sort(userInfos, (u1 , u2) -> UserInfo.compareById(u1, u2));
        Collections.sort(userInfos, UserInfo::compareById);
        /**
         *
         *  instance method reference of a particular class
         *     (args) -> obj.instanceMethods(args)
         *
         */
        CompareByName byName = new CompareByName();
        Collections.sort(userInfos, byName::compareByName);
        /**
         *
         * instance method reference of arbitrary object of particular type
         *
         * (obj, args) -> obj.instaceMethod(args)
         *
         */
        List<Integer> ids = Arrays.asList(10, 20 , 15, 30);
        Collections.sort(ids, Integer::compareTo);

        /**
         * Constructor reference
         *
         */

        /**
         * query a database to find an object of a type or else throw an runtime exception
         * APPLICATION --> DB (DATA)
         *      - CRUD -- CREATE A NEW MOVIE
         *              -- UPDATE MOVIE DATA
         *              -- READ MOVIE DATA
         *              -- DELETE
         *              CRUD
         */
        MovieDao dao = new MovieDao();
        Movie movie
          = dao.findByName(" Avengers").orElseThrow(RuntimeException::new);
        System.out.println(movie);
        Movie movie2
                = dao.findByName(" BatWoman").orElseThrow(() -> new RuntimeException("Movie not " +
                                                                                                                  "found"));

        System.out.println(movie2);


//        System.out.println(userInfos);




    }


}
