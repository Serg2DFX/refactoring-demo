package com.scrumtrek.simplestore;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

@Ignore
public class DemoTest {
    @Test
    public void movieShouldSaveTitleWhenNotEmpty() {
        Movie sut = new Movie("test title", PriceCodes.Regular);
        assertEquals("test title", sut.getTitle());
        assertEquals(PriceCodes.Regular, sut.getPriceCode());
    }
}
