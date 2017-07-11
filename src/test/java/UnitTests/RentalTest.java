package UnitTests;

import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

public class RentalTest {

    @Test
    public void ShouldRentalInitializeWhenConstructorCalls() {
        String movieName = "It is title";
        PriceCodes code =  PriceCodes.NewRelease;
        Movie dummyMovie = new Movie(movieName, code);
        int dayRental = 10;
        Rental rental = new Rental(dummyMovie, dayRental);

        Assert.assertEquals(movieName, rental.getMovie().getTitle());
        Assert.assertEquals(code, rental.getMovie().getPriceCode());
        Assert.assertEquals(dummyMovie, rental.getMovie());
        Assert.assertEquals(dayRental, rental.getDaysRented());
    }
}
