package com.thoughtworks.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateCost() {
        double cost = 0;

        switch (this.movie.getPriceCode()) {
            case Movie.REGULAR:
                cost += 2;
                if (this.daysRented > 2)
                    cost += (this.daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                cost += this.daysRented * 3;
                break;
            case Movie.CHILDRENS:
                cost += 1.5;
                if (this.daysRented > 3)
                    cost += (this.daysRented - 3) * 1.5;
                break;
            default:
                break;
        }

        return cost;
    }

    public int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 1;

        if ((this.movie.getPriceCode() == Movie.NEW_RELEASE)
                &&
                this.daysRented > 1) frequentRenterPoints++;

        return frequentRenterPoints;
    }
}
