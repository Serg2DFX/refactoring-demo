package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class RentalTest {

    @Test
    public void ShouldProvideMovieAndDaysRentedWhenInitialized() {

        Movie movieStub = mock(Movie.class);

        Rental rental = new Rental(movieStub, 1);

        assertThat(movieStub)
            .isEqualTo(rental.getMovie());

        assertThat(rental.getDaysRented())
            .isEqualTo(1);
    }
}
