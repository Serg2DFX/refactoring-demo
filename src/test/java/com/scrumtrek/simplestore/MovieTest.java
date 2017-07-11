package com.scrumtrek.simplestore;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class MovieTest {

    @Test()
    public void ShouldCreateMovie() {
        String movieTitle = "Movie1";
        PriceCodes priceCodes = PriceCodes.Childrens;
        Movie movie = new Movie(movieTitle, priceCodes);

        assertThat(movie.getPriceCode()).isEqualTo(priceCodes);
        assertThat(movie.getTitle()).isEqualTo(movieTitle);
    }

    @Test
    public void ShouldCreateMoveWhenChangePriceCode() {
        String movieTitle = "Movie1";
        PriceCodes priceCodes = PriceCodes.Childrens;
        Movie movie = new Movie(movieTitle, priceCodes);

        movie.setPriceCode(PriceCodes.NewRelease);
        assertThat(movie.getPriceCode()).isEqualTo(PriceCodes.NewRelease);

        movie.setPriceCode(PriceCodes.Childrens);
        assertThat(movie.getPriceCode()).isEqualTo(PriceCodes.Childrens);

        movie.setPriceCode(PriceCodes.Regular);
        assertThat(movie.getPriceCode()).isEqualTo(PriceCodes.Regular);
    }
}
