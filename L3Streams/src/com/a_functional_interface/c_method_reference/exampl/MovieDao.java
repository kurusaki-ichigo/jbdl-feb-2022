package com.a_functional_interface.c_method_reference.exampl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MovieDao {

    /**
     * data base
     */
    List<Movie> movieList =  Arrays.asList(
            //String tile, int ratings, int price
            new Movie(" Avengers", 7, 350),
            new Movie(" Batman", 5, 500),
            new Movie(" Superman", 8, 200),
            new Movie(" Captain america", 9, 400),
            new Movie(" Wolveriene", 4, 1200)
    );



    public Optional<Movie> findByName(String movieName){
       return movieList.stream().filter(movie -> movie.getTile().equalsIgnoreCase(movieName))
                .findFirst();

//
//
//        for(Movie movie : movieList){
//            if(movie.getTile().equalsIgnoreCase(movieName)){
//                return Optional.of(movie);
//            }
//        }
//        return Optional.ofNullable(null);
    }


}
