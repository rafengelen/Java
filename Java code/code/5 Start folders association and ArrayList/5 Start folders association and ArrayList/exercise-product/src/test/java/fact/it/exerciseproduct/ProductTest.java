package fact.it.exerciseproduct;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fact.it.exerciseproduct.model.*;

@SpringBootTest
class ProductTest {
    @Test
    public void testConstructorWith1ParameterAndGetter() {
        Product p = new Product("Radio");
        assertEquals("Radio", p.getName());
    }

    @Test
    public void testConstructorWith3ParametersAndGetter() {
        Product p = new Product("Radio", 3, 112.3);
        assertEquals("Radio", p.getName());
        assertEquals(3, p.getAmount());
        assertEquals(112.3, p.getPrice());
    }

    @Test
    public void testSetterName() {
        Product p = new Product("Radio");
        p.setName("Lamp");
        assertEquals("Lamp", p.getName());
    }

    @Test
    public void testSetterPrice() {
        Product p = new Product("Radio");
        p.setPrice(12.5);
        assertEquals(12.5, p.getPrice());
    }

    @Test
    public void testSetterAmount() {
        Product p = new Product("Radio");
        p.setAmount(80);
        assertEquals(80, p.getAmount());
    }
    @Test
    public void testSetters() {
        Product p = new Product("Radio");
        p.setName("Lamp");
        assertEquals("Lamp", p.getName());
        p.setAmount(10);
        assertEquals(10, p.getAmount());
        p.setPrice(22.6);
        assertEquals(22.6, p.getPrice());
    }

    @Test
    public void testShowProduct() {
        Product p = new Product("Clock Radio");
        p.setPrice(88.1);
        assertEquals("The product Clock Radio costs €88.1", p.showProduct());
    }

    @Test
    public void testShowProductWithAmount() {
        Product p = new Product("Clock Radio", 5, 115.3);
        assertEquals("The product Clock Radio (5 pieces in stock) costs €115.3", p.showProductWithAmount());
    }

    @Test
    public void testSell() {
        Product p = new Product("Radio", 5, 50.3);
        p.sell();
        assertEquals("Radio", p.getName());
        assertEquals(4, p.getAmount());
    }

    @Test
    public void testSellWithoutStock() {
        Product p = new Product("Radio", 0, 23.5);
        p.sell();
        assertEquals("Radio", p.getName());
        assertEquals(0, p.getAmount());
    }

    @Test
    public void testAddStock() {
        Product p = new Product("Radio", 0, 56.3);
        p.addStockAmount(4);
        assertEquals("Radio", p.getName());
        assertEquals(4, p.getAmount());
    }

    @Test
    public void testAddStockWithNegativeParameter() {
        Product p = new Product("Radio", 0, 56.3);
        p.addStockAmount(-2);
        assertEquals("Radio", p.getName());
        assertEquals(0, p.getAmount());
    }
}
