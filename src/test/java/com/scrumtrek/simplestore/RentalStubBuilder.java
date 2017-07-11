package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalStubBuilder implements IRentalBuilder
{
    private Movie _movie;
    private int _daysRented;

    public RentalStubBuilder() { }

    public IRentalBuilder WithMovie(Movie movie) {
        _movie = movie;
        return this;
    }

    public IRentalBuilder WithDaysRented(int daysRented) {
        _daysRented = daysRented;
        return this;
    }

    public Rental Build()
    {
        Rental rentalStub = mock(Rental.class);
        when(rentalStub.getMovie())
                .thenReturn(_movie);
        when(rentalStub.getDaysRented())
                .thenReturn(_daysRented);
        return rentalStub;
    }
}