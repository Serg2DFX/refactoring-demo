package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class RentalTest {

    @Test
    public void ShouldProvideMovieAndDaysRentedWhenInitialized() {

        AbstractMovie movieStub = new MovieStubBuilder()
                .WithTitle("Movie name")
                .BuildRegular();

        Rental rental = new Rental(movieStub, 1);

        assertThat(movieStub)
                .isEqualTo(rental.getMovie());

        assertThat(rental.getDaysRented())
                .isEqualTo(1);
    }
}