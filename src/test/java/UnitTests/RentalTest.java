package UnitTests;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

public class RentalTest {

    @Test()
    public void ShouldRentalInitializeWhenConstructorCalls()
    {
        Movie dummyMovie = new Movie("It is title", PriceCodes.NewRelease);
        int dayRental = 10;
        Rental rental = new Rental(dummyMovie, dayRental);

        Assert.assertEquals(dummyMovie, rental.getMovie());
        Assert.assertEquals(dayRental, rental.getDaysRented());
    }
}
