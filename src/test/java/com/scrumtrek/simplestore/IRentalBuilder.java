package com.scrumtrek.simplestore;

public interface IRentalBuilder {
    IRentalBuilder WithMovie(AbstractMovie movie);

    IRentalBuilder WithDaysRented(int daysRented);

    Rental Build();
}