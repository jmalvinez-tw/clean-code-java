package com.thoughtworks.movierental;

public class Movie {

    private String title;
    private Category category;

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public double calculateCost(int daysRented) {
        return this.category.calculateCost(daysRented);
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        return this.category.calculateFrequentRenterPoints(daysRented);
    }
}
