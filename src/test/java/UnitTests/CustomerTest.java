package UnitTests;

import com.scrumtrek.simplestore.Customer;
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
}
