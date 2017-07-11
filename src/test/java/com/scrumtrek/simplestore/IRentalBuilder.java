package com.scrumtrek.simplestore;

public interface IRentalBuilder {
    IRentalBuilder WithMovie(Movie movie);
    IRentalBuilder WithDaysRented(int daysRented);
    Rental Build();
}