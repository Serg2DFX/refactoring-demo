package com.scrumtrek.simplestore;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieStubBuilder implements IMovieBuilder {

    private String _title;

    public MovieStubBuilder() {
    }

    public IMovieBuilder WithTitle(String title) {
        _title = title;
        return this;
    }

    public RegularMovie BuildRegular() {
        RegularMovie movieStub = mock(RegularMovie.class);
        when(movieStub.getTitle())
                .thenReturn(_title);

        CallRealMethods(movieStub);
        return movieStub;
    }

    public NewReleaseMovie BuildNewRelease() {
        NewReleaseMovie movieStub = mock(NewReleaseMovie.class);
        when(movieStub.getTitle())
                .thenReturn(_title);

        CallRealMethods(movieStub);
        return movieStub;
    }

    public ChildrenMovie BuildChildrenMovie() {
        ChildrenMovie movieStub = mock(ChildrenMovie.class);
        when(movieStub.getTitle())
                .thenReturn(_title);

        CallRealMethods(movieStub);
        return movieStub;
    }

    public XxxMovie BuildNewXxx() {
        XxxMovie movieStub = mock(XxxMovie.class);
        when(movieStub.getTitle())
                .thenReturn(_title);

        CallRealMethods(movieStub);
        return movieStub;
    }

    private void CallRealMethods(AbstractMovie movieStub) {
        when(movieStub.getAmount(anyInt()))
                .thenCallRealMethod();

        when(movieStub.getFrequentRenterPoint(anyInt()))
                .thenCallRealMethod();
    }
}