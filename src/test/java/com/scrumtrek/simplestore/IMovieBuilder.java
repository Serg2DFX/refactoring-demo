package com.scrumtrek.simplestore;

public interface IMovieBuilder {
    IMovieBuilder WithTitle(String title);

    RegularMovie BuildRegular();

    NewReleaseMovie BuildNewRelease();

    ChildrenMovie BuildChildrenMovie();

    XxxMovie BuildNewXxx();
}