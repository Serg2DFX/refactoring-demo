package com.scrumtrek.simplestore;

public interface IMovieBuilder {
    IMovieBuilder WithPriceCode(PriceCodes priceCodes);
    IMovieBuilder WithTitle(String title);
    Movie Build();
}