package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class CustomerTest {

    @Test()
    public void ShouldProvideAmountAndFrequentPointsWhenThreeMoviesAdded() {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(3)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new release)")
                                .BuildNewRelease())
                .Build());

        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(2)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new release)")
                                .BuildChildrenMovie())
                .Build());


        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(1)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new release)")
                                .BuildRegular())
                .Build());


        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 12.5)
                .contains("You earned " + 4 + " frequent renter points.");
    }

    @Test()
    public void ShouldProvideHigherAmountAndFrequentPointsWhenLongRentedMoviesAdded() {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(4)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new children)")
                                .BuildChildrenMovie())
                .Build());

        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(3)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new regular)")
                                .BuildRegular())
                .Build());

        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 5)
                .contains("You earned " + 2 + " frequent renter points.");
    }

    @Test()
    public void ShouldProvideAmountAndHigherFrequentPointsWhenNewReleaseLongRentedMovieAdded() {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(new RentalStubBuilder()
                .WithDaysRented(1)
                .WithMovie(
                        new MovieStubBuilder()
                                .WithTitle("Rental 1 (new children)")
                                .BuildNewRelease())
                .Build());

        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 3)
                .contains("You earned " + 1 + " frequent renter points.");
    }
}