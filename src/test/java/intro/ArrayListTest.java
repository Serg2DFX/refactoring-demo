package intro;

// import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;

import java.util.ArrayList;

// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.MatcherAssert.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * SUT: system under test
 * Test Case: class
 * Test, Test scenario: method
 */
public class ArrayListTest { //SUT = ArrayList
    @Test
    public void itShouldSizeIncrementedAddedWhenDoAddElement() { //BDD: Domain Lang
        //region Fixture | Arrange | Given
        ArrayList<Object> sut = new ArrayList<>();
        Object dummy = new Object();
        assumeTrue(sut.size() == 0); //Pending | Ignored
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        // AssertionError | Failure
        assertEquals(1, sut.size());

        assertThat(sut)
                .contains(dummy)
                .doesNotContain(2);

        assertThat(sut.size())
                .isEqualTo(1);

        // assertThat(sut.size(), is(1));
        // assertThat(sut.size(), IsCollectionContaining.hasItem(dummy)));
        //endregion
    }
}
