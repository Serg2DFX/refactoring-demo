package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieStubBuilder implements IMovieBuilder {

    private PriceCodes _priceCodes;
    private String _title;

    public MovieStubBuilder() {}

    public IMovieBuilder WithPriceCode(PriceCodes priceCodes) {
        _priceCodes = priceCodes;
        return this;
    }

    public IMovieBuilder WithTitle(String title) {
        _title = title;
        return this;
    }


    public Movie Build() {
        Movie movieStub = mock(Movie.class);
        when(movieStub.getPriceCode())
                .thenReturn(_priceCodes);
        when(movieStub.getTitle())
                .thenReturn(_title);

        return movieStub;
    }
}
