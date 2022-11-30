package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder()
                .append("Rental Record for ").append(getName()).append("\n")
                .append(getRentalFigures())
                .append("Amount owed is ").append(getTotalAmount()).append("\n").append("You earned ")
                .append(getFrequentRenterPoints()).append(" frequent renter points");

        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder()
                .append("<h1>Rental Record for <strong>").append(getName()).append("</strong></h1>\n\n")
                .append(getHtmlRentalFigures())
                .append("\n<p>Amount owed is <strong>").append(getTotalAmount()).append("</strong></p>\n")
                .append("<p>You earned <strong>").append(getFrequentRenterPoints()).append("</strong> frequent renter points</p>");

        return result.toString();
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getMovie().calculateCost(rental.getDaysRented());
        }

        return totalAmount;
    }

    private String getRentalFigures() {
        StringBuilder result = new StringBuilder();

        for (Rental rental : rentals) {
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.calculateCost()).append("\n");
        }

        return result.toString();
    }

    private String getHtmlRentalFigures() {
        StringBuilder result = new StringBuilder();

        for (Rental rental : rentals) {
            result.append("<p>").append(rental.getMovie().getTitle()).append(":\t").append(rental.calculateCost()).append("</p>\n");
        }

        return result.toString();
    }
}
