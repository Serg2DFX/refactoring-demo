package UnitTests;

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    @Test()
    public void ShouldInitializeCustomerWhenConstructorCalled()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        Assert.assertEquals(customerName, customer.getName());
    }

    @Test()
    public void ShouldProvideDefaultStatementWhenNoMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 0));
        Assert.assertTrue(result.contains("You earned " + 0 + " frequent renter points."));
    }

    @Test()
    public void ShouldProvideCustomerStatementWhenThreeMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        Movie movie1 = new Movie("Rental 1 (new release)", PriceCodes.NewRelease);
        customer.addRental(new Rental(movie1, 3));

        Movie movie2 = new Movie("Rental 1 (new children)", PriceCodes.Childrens);
        customer.addRental(new Rental(movie2, 2));

        Movie movie3 = new Movie("Rental 1 (new regular)", PriceCodes.Regular);
        customer.addRental(new Rental(movie3, 1));


        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 12.5));
        Assert.assertTrue(result.contains("You earned " + 4 + " frequent renter points."));
    }

    @Test()
    public void ShouldProvideCustomerStatementWhenTwoMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        Movie movie2 = new Movie("Rental 1 (new children)", PriceCodes.Childrens);
        customer.addRental(new Rental(movie2, 4));

        Movie movie3 = new Movie("Rental 1 (new regular)", PriceCodes.Regular);
        customer.addRental(new Rental(movie3, 3));


        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 5));
        Assert.assertTrue(result.contains("You earned " + 2 + " frequent renter points."));
    }

    @Test()
    public void ShouldProvideCustomerStatementWhenOneMoviesAdded()
    {
        String customerName = "customer name";
        Customer customer = new Customer(customerName);

        Movie movie2 = new Movie("Rental 1 (new children)", PriceCodes.Childrens);
        movie2.setPriceCode(PriceCodes.NewRelease);
        customer.addRental(new Rental(movie2, 1));

        String result = customer.Statement();
        Assert.assertTrue(result.contains("Rental record for " + customerName));
        Assert.assertTrue(result.contains("Amount owed is " + 3));
        Assert.assertTrue(result.contains("You earned " + 1 + " frequent renter points."));
    }
}
