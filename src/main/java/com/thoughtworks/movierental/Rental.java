package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateCost() {
        return this.movie.calculateCost(this.daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return this.movie.calculateFrequentRenterPoints(this.daysRented);
    }
}
