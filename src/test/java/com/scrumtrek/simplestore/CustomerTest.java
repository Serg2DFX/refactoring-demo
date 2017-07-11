package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CustomerTest {
    private Rental CreateRentalStub(PriceCodes moviePriceCode, String movieTitle, int daysRented)
    {
        Movie movie = new MovieStubBuilder()
                .WithTitle(movieTitle)
                .WithPriceCode(moviePriceCode)
                .Build();

        return new RentalStubBuilder()
                .WithDaysRented(daysRented)
                .WithMovie(movie)
                .Build();

        /*Movie movieStub = mock(Movie.class);
        when(movieStub.getPriceCode())
                .thenReturn(moviePriceCode);
        when(movieStub.getTitle())
                .thenReturn(movieTitle);

        Rental rentalStub = mock(Rental.class);
        when(rentalStub.getMovie())
                .thenReturn(movieStub);
        when(rentalStub.getDaysRented())
                .thenReturn(daysRented);*/
    }


    @Test()
    public void ShouldProvideAmountAndFrequentPointsWhenThreeMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRentalStub(PriceCodes.NewRelease, "Rental 1 (new release)", 3));
        customer.addRental(CreateRentalStub(PriceCodes.Childrens, "Rental 1 (new release)", 2));
        customer.addRental(CreateRentalStub(PriceCodes.Regular, "Rental 1 (new release)", 1));

        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 12.5)
                .contains("You earned " + 4 + " frequent renter points.");
    }

    @Test()
    public void ShouldProvideHigherAmountAndFrequentPointsWhenLongRentedMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRentalStub(PriceCodes.Childrens, "Rental 1 (new children)", 4));
        customer.addRental(CreateRentalStub(PriceCodes.Regular, "Rental 1 (new regular)", 3));

        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 5)
                .contains("You earned " + 2 + " frequent renter points.");
    }

    @Test()
    public void ShouldProvideAmountAndHigherFrequentPointsWhenNewReleaseLongRentedMovieAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        customer.addRental(CreateRentalStub(PriceCodes.NewRelease, "Rental 1 (new children)", 1));

        String result = customer.Statement();

        assertThat(result)
                .contains("Rental record for " + customerName)
                .contains("Amount owed is " + 3)
                .contains("You earned " + 1 + " frequent renter points.");
    }
}
