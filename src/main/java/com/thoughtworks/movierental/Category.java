package com.thoughtworks.movierental;

public enum Category {
    CHILDRENS {
        @Override
        double calculateCost(int daysRented) {
            double cost = 1.5;

            if (daysRented > 3)
                cost += (daysRented - 3) * 1.5;

            return cost;
        }
    }, REGULAR {
        @Override
        double calculateCost(int daysRented) {
            double cost = 2;

            if (daysRented > 2)
                cost += (daysRented - 2) * 1.5;

            return cost;
        }
    }, NEW_RELEASE {
        @Override
        double calculateCost(int daysRented) {
            return daysRented * 3;
        }

        @Override
        int calculateFrequentRenterPoints(int daysRented) {
            int frequentRenterPoints = super.calculateFrequentRenterPoints(daysRented);

            if (daysRented > 1) frequentRenterPoints++;

            return frequentRenterPoints;
        }
    }, BLURAY {
        @Override
        double calculateCost(int daysRented) {
            return daysRented * 4;
        }

        @Override
        int calculateFrequentRenterPoints(int daysRented) {
            return 3;
        }
    };

    abstract double calculateCost(int daysRented);

    int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    };
}
