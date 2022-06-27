package fact.it.exercisedairy;
import fact.it.exercisedairy.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    public void testConstructorsAndGetters() {
        Product a = new Product();
        assertEquals(0, a.getProductNumber());
        assertEquals(null, a.getName());
        assertEquals(0.0, a.getUnitPrice(),0.1);
        Product a2 = new Product(876541);
        assertEquals(876541, a2.getProductNumber());
        assertEquals(null, a2.getName());
        assertEquals(0.0, a2.getUnitPrice(),0.1);
        Product a3 = new Product(876541, "TestProduct", 27.2);
        assertEquals(876541, a3.getProductNumber());
        assertEquals("TestProduct", a3.getName());
        assertEquals(27.2, a3.getUnitPrice(),0.1);


    }

    @Test
    public void testSetters() {
        Product a = new Product();
        a.setProductNumber(654321);
        a.setName("Boter");
        a.setUnitPrice(26.25);
        assertEquals(654321, a.getProductNumber());
        assertEquals("Boter", a.getName());
        assertEquals(26.25, a.getUnitPrice(),0.1);
    }


    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        Product a3 = new Product(876541, "TestProduct", 27.2);

        assertEquals("876541 TestProduct: € 27.2", a3.toString());

    }

    @Test
    public void testToString2() {
        Product a3 = new Product(132465, "Java Koffie", 13.3);

        assertEquals("132465 Java Koffie: € 13.3", a3.toString());

    }
}

