package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MovieTest {

    @Test()
    public void ShouldProvideAmountAndHigherFrequentPointsWhenNewReleaseRentedMovieAdded() {
        XxxMovie movie = new MovieStubBuilder()
                .WithTitle("Rental 1 (new children)")
                .BuildNewXxx();

        int dayRented = 2;
        assertThat(movie.getAmount(dayRented)).isEqualTo(1.7);
        assertThat(movie.getFrequentRenterPoint(dayRented)).isEqualTo(1);
    }

    @Test()
    public void ShouldProvideAmountAndHigherFrequentPointsWhenNewReleaseLongRentedMovieAdded() {
        XxxMovie movie = new MovieStubBuilder()
                .WithTitle("Rental 1 (new children)")
                .BuildNewXxx();

        int dayRented = 3;
        assertThat(movie.getAmount(dayRented)).isEqualTo(2.975);
        assertThat(movie.getFrequentRenterPoint(dayRented)).isEqualTo(1);
    }
}
