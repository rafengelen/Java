package fact.it.exercisebeverage;

import fact.it.exercisebeverage.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerTest {
    @Test
    public void testConstructorMetParametersEnGetters() {
        Customer customer = new Customer(654,"Testklant");
        assertEquals("Testklant", customer.getName());
        assertEquals(654, customer.getCustomerNumber());
    }

    @Test
    public void testSetters() {
        Customer customer = new Customer(654,"Testklant");
        customer.setName("Nieuw");
        assertEquals("Nieuw", customer.getName());
        customer.setCustomerNumber(123);
        assertEquals(123, customer.getCustomerNumber());
    }

    @Test
    public void testGetGeheimeCode() {
        Customer customer = new Customer(654,"Testclient");
        assertEquals("TE654NT", customer.getSecretCode());
    }

}
