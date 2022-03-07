package com.a_functional_interface.c_method_reference.exampl;

import java.time.LocalDateTime;

public class Movie {

    Double id;
    String tile;
    int ratings;
    int price;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", tile='" + tile + '\'' +
                ", ratings=" + ratings +
                ", price=" + price +
                '}';
    }

    public Movie(String tile,  int ratings, int price) {
        this.id = Math.random();
        this.tile = tile;
        this.ratings = ratings;
        this.price = price;
    }

    public Double getId() {
        return id;
    }

    public String getTile() {
        return tile;
    }

    public int getRatings() {
        return ratings;
    }

    public int getPrice() {
        return price;
    }
}
