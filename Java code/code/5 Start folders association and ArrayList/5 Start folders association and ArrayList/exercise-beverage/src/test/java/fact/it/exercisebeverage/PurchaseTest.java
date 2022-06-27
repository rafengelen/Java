package fact.it.exercisebeverage;

import fact.it.exercisebeverage.model.Beverage;
import fact.it.exercisebeverage.model.Customer;
import fact.it.exercisebeverage.model.Purchase;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PurchaseTest {
    @Test
    public void testConstructorWithParametersAndGetters() {
        Customer customer = new Customer(654, "Test customer");
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2);
        Purchase a = new Purchase(customer, beverage, 5);
        assertEquals("Beer", a.getBeverage().getName());
        assertEquals(1.2, a.getBeverage().getPrice(), 0.1);
        assertEquals(250, a.getBeverage().getVolume());
        assertEquals(4.2, a.getBeverage().getAlcoholPercentage(), 0.1);
        assertEquals("Test customer", a.getCustomer().getName());
        assertEquals(654, a.getCustomer().getCustomerNumber());
        assertEquals(5, a.getPurchasedAmount());
    }
    
    @Test
    public void testSetters() {
        Customer customer = new Customer(654, "Test customer");
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2);
        Purchase a = new Purchase(customer, beverage, 5);
        Customer k2 = new Customer(100, "T2");
        a.setCustomer(k2);
        assertEquals("T2", a.getCustomer().getName());
        assertEquals(100, a.getCustomer().getCustomerNumber());
        assertEquals(5, a.getPurchasedAmount());
        Beverage d2 = new Beverage("Wine", 20.0, 750, 12.5);
        a.setBeverage(d2);
        assertEquals("Wine", a.getBeverage().getName());
        assertEquals(20.0, a.getBeverage().getPrice(), 0.1);
        assertEquals(750, a.getBeverage().getVolume());
        assertEquals(12.5, a.getBeverage().getAlcoholPercentage(), 0.1);
    }

    @Test
    public void testShowPurchase() {
        Customer customer = new Customer(654, "Vandergoten");
        Beverage beverage = new Beverage("Whiskey", 1.2, 250, 11.5);
        Purchase a = new Purchase(customer, beverage, 3);
        assertEquals("Customer Vandergoten bought 3 bottle(s) of Whiskey (11.5%)", a.showPurchase());
    }
}
