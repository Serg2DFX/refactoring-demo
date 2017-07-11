package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Mockito.*;

public class CustomerStubTest {

    @Test()
    public void ShouldProvideCustomerStatementWhenThreeMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        Movie movieStub1 = mock(Movie.class);
        when(movieStub1.getPriceCode())
                .thenReturn(PriceCodes.NewRelease);
        when(movieStub1.getTitle())
                .thenReturn("Rental 1 (new release)");

        Movie movieStub2 = mock(Movie.class);
        when(movieStub2.getPriceCode())
                .thenReturn(PriceCodes.Childrens);
        when(movieStub2.getTitle())
                .thenReturn("Rental 1 (new release)");

        Movie movieStub3 = mock(Movie.class);
        when(movieStub3.getPriceCode())
                .thenReturn(PriceCodes.Regular);
        when(movieStub3.getTitle())
                .thenReturn("Rental 1 (new release)");

        Rental rentalStub1 = mock(Rental.class);
        when(rentalStub1.getMovie())
                .thenReturn(movieStub1);
        when(rentalStub1.getDaysRented())
                .thenReturn(3);

        Rental rentalStub2 = mock(Rental.class);
        when(rentalStub2.getMovie())
                .thenReturn(movieStub2);
        when(rentalStub2.getDaysRented())
                .thenReturn(2);

        Rental rentalStub3 = mock(Rental.class);
        when(rentalStub3.getMovie())
                .thenReturn(movieStub3);
        when(rentalStub3.getDaysRented())
                .thenReturn(1);

        customer.addRental(rentalStub1);
        customer.addRental(new Rental(movieStub2, 2));
        customer.addRental(new Rental(movieStub3, 1));

        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 12.5));
        Assert.assertTrue(result.contains("You earned " + 4 + " frequent renter points."));
    }
}
