package fact.it.exercisedairy;

import fact.it.exercisedairy.model.Dairy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DairyTest {
    @Test
    public void testConstructorsEnGetters() {
        Dairy z = new Dairy(876541);
        assertEquals(876541, z.getProductNumber());
        assertEquals(null, z.getName());
        assertEquals(0.0, z.getUnitPrice(),0.1);
        assertEquals(0, z.getNumberOfDays());

    }

    @Test
    public void testSetters() {
        Dairy z = new Dairy(876541);
        z.setProductNumber(654321);
        z.setName("Boter");
        z.setUnitPrice(26.25);
        z.setNumberOfDays(5);
        z.setSupplierCode('E');
        assertEquals(654321, z.getProductNumber());
        assertEquals("Boter", z.getName());
        assertEquals(26.25, z.getUnitPrice(),0.1);
        assertEquals(5, z.getNumberOfDays());
        assertEquals('E', z.getSupplierCode());
    }


    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        Dairy z = new Dairy(876541);

        z.setName("Boter");
        z.setUnitPrice(26.25);

        assertEquals("876541 Boter: € 26.25", z.toString());

    }

    @Test
    public void testToString2() {
        Dairy z = new Dairy(456132);

        z.setName("Java Koffie");
        z.setUnitPrice(13.3);

        assertEquals("456132 Java Koffie: € 13.3", z.toString());

    }
}
