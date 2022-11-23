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

        String expectedStatement = """
                Rental Record for John Do
                	Barbarian	3.5
                Amount owed is 3.5
                You earned 1 frequent renter points""";
        Assert.assertEquals(expectedStatement, testStatement);
    }

    @Test
    public void htmlStatementTest() {
        Movie testMovie1 = new Movie("Barbarian", Movie.REGULAR);
        Rental testRental1 = new Rental(testMovie1, 3);

        Movie testMovie2 = new Movie("Black Panther: Wakanda Forever", Movie.NEW_RELEASE);
        Rental testRental2 = new Rental(testMovie2, 5);

        Customer testCustomer = new Customer("John Do");

        testCustomer.addRental(testRental1);
        testCustomer.addRental(testRental2);
        String testStatement = testCustomer.htmlStatement();

        System.out.println(testStatement);

        String expectedStatement = """
                <h1>Rental Record for <strong>John Do</strong></h1>
                
                <p>Barbarian:	3.5</p>
                <p>Black Panther: Wakanda Forever:	15.0</p>
                
                <p>Amount owed is <strong>18.5</strong></p>
                <p>You earned <strong>3</strong> frequent renter points</p>""";
        Assert.assertEquals(expectedStatement, testStatement);
    }
}
