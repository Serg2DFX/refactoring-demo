package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.*;

public class CustomerStubTest {
    private Rental CreateRental(PriceCodes moviePriceCode, String movieTitle, int daysRented)
    {
        Movie movieStub = mock(Movie.class);
        when(movieStub.getPriceCode())
                .thenReturn(moviePriceCode);
        when(movieStub.getTitle())
                .thenReturn(movieTitle);

        Rental rentalStub = mock(Rental.class);
        when(rentalStub.getMovie())
                .thenReturn(movieStub);
        when(rentalStub.getDaysRented())
                .thenReturn(daysRented);

        return rentalStub;
    }


    @Test()
    public void ShouldProvideCustomerStatementWhenThreeMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRental(PriceCodes.NewRelease, "Rental 1 (new release)", 3));
        customer.addRental(CreateRental(PriceCodes.Childrens, "Rental 1 (new release)", 2));
        customer.addRental(CreateRental(PriceCodes.Regular, "Rental 1 (new release)", 1));

        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 12.5));
        Assert.assertTrue(result.contains("You earned " + 4 + " frequent renter points."));
    }

    @Test()
    public void ShouldProvideCustomerStatementWhenTwoMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRental(PriceCodes.Childrens, "Rental 1 (new children)", 4));
        customer.addRental(CreateRental(PriceCodes.Regular, "Rental 1 (new regular)", 3));

        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 5));
        Assert.assertTrue(result.contains("You earned " + 2 + " frequent renter points."));
    }

    @Test()
    public void ShouldProvideCustomerStatementWhenOneMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRental(PriceCodes.NewRelease, "Rental 1 (new children)", 1));

        String result = customer.Statement();

        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 3));
        Assert.assertTrue(result.contains("You earned " + 1 + " frequent renter points."));
    }
}
