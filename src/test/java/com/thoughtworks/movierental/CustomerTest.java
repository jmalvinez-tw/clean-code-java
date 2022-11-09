package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test
    public void test() {

        int expected = 3;

        Assert.assertEquals(expected, 1 + 2);
    }

    @Test
    public void statementCharacterisationTest() {
        Movie testMovie = new Movie("Barbarian", Movie.REGULAR);
        Rental testRental = new Rental(testMovie, 3);
        Customer testCustomer = new Customer("John Do");

        testCustomer.addRental(testRental);
        String testStatement = testCustomer.statement();

        System.out.println(testStatement);

        String expectedStatement = "Rental Record for John Do\n\tBarbarian	3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points";
        Assert.assertEquals(expectedStatement, testStatement);
    }
}
