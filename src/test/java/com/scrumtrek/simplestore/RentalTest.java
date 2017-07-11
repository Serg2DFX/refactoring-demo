package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RentalTest {

    @Test
    public void ShouldProvideMovieAndDaysRentedWhenInitialized() {

        Movie movieStub = mock(Movie.class);

        Rental rental = new Rental(movieStub, 1);

        Assert.assertEquals(movieStub, rental.getMovie());
        Assert.assertEquals(1, rental.getDaysRented());
    }
}
