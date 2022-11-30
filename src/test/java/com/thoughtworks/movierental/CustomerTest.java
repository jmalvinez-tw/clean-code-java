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
        Movie testRegularMovie = new Movie("Barbarian", Category.REGULAR);
        Rental testRegularMovieRental = new Rental(testRegularMovie, 3);

        Movie testNewReleaseMovie = new Movie("Black Panther: Wakanda Forever", Category.NEW_RELEASE);
        Rental testNewReleaseMovieRental = new Rental(testNewReleaseMovie, 5);

        Movie testChildrenMovie = new Movie("Stand By Me Doraemon", Category.CHILDRENS);
        Rental testChildrenMovieRental = new Rental(testChildrenMovie, 4);

        Movie testBlurayMovie = new Movie("Iron Man", Category.BLURAY);
        Rental testBlurayMovieRental = new Rental(testBlurayMovie, 2);

        Customer testCustomer = new Customer("John Do");

        testCustomer.addRental(testRegularMovieRental);
        testCustomer.addRental(testNewReleaseMovieRental);
        testCustomer.addRental(testChildrenMovieRental);
        testCustomer.addRental(testBlurayMovieRental);
        String testStatement = testCustomer.statement();

        System.out.println(testStatement);

        String expectedStatement = """
                Rental Record for John Do
                	Barbarian	3.5
                	Black Panther: Wakanda Forever	15.0
                	Stand By Me Doraemon	3.0
                	Iron Man	8.0
                Amount owed is 29.5
                You earned 7 frequent renter points""";
        Assert.assertEquals(expectedStatement, testStatement);
    }

    @Test
    public void htmlStatementTest() {
        Movie testRegularMovie = new Movie("Barbarian", Category.REGULAR);
        Rental testRegularMovieRental = new Rental(testRegularMovie, 3);

        Movie testNewReleaseMovie = new Movie("Black Panther: Wakanda Forever", Category.NEW_RELEASE);
        Rental testNewReleaseMovieRental = new Rental(testNewReleaseMovie, 5);

        Movie testChildrenMovie = new Movie("Stand By Me Doraemon", Category.CHILDRENS);
        Rental testChildrenMovieRental = new Rental(testChildrenMovie, 4);

        Movie testBlurayMovie = new Movie("Iron Man", Category.BLURAY);
        Rental testBlurayMovieRental = new Rental(testBlurayMovie, 2);

        Customer testCustomer = new Customer("John Do");

        testCustomer.addRental(testRegularMovieRental);
        testCustomer.addRental(testNewReleaseMovieRental);
        testCustomer.addRental(testChildrenMovieRental);
        testCustomer.addRental(testBlurayMovieRental);
        String testStatement = testCustomer.htmlStatement();

        System.out.println(testStatement);

        String expectedStatement = """
                <h1>Rental Record for <strong>John Do</strong></h1>
                
                <p>Barbarian:	3.5</p>
                <p>Black Panther: Wakanda Forever:	15.0</p>
                <p>Stand By Me Doraemon:	3.0</p>
                <p>Iron Man:	8.0</p>
                
                <p>Amount owed is <strong>29.5</strong></p>
                <p>You earned <strong>7</strong> frequent renter points</p>""";
        Assert.assertEquals(expectedStatement, testStatement);
    }
}
