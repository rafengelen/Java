package fact.it.exerciseproduct;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fact.it.exerciseproduct.model.*;

@SpringBootTest
public class WebshopTest {

    @Test
    public void testConstructorWith1ParameterAndGetter() {
        Webshop webshop = new Webshop("www.webshop1.be");
        assertEquals("www.webshop1.be", webshop.getUrl());
        assertEquals(0, webshop.getNumberOfProducts());
    }

    @Test
    public void testSetterUrl() {
        Webshop webshop = new Webshop("www.webshop1.be");
        webshop.setUrl("www.idee.be");
        assertEquals("www.idee.be", webshop.getUrl());
    }

    @Test
    public void testAddProduct() {
        Webshop webshop = new Webshop("www.webshop1.be");
        Product product = new Product("Card", 10, 5.5);
        webshop.addProduct(product);
        assertEquals(1, webshop.getNumberOfProducts());
    }

    @Test
    public void testGetNumberOfProducts() {
        Webshop webshop = new Webshop("www.webshop1.be");
        Product product1 = new Product("Card1", 10, 5.5);
        Product product2 = new Product("Card2", 20, 6.5);
        Product product3 = new Product("Card3", 30, 7.5);
        webshop.addProduct(product1);
        webshop.addProduct(product2);
        webshop.addProduct(product3);
        assertEquals(3, webshop.getNumberOfProducts());
    }

    @Test
    public void testShowProductFromProductList() {
        Webshop webshop = new Webshop("www.webshop1.be");
        Product product1 = new Product("Card1", 10, 5.5);
        Product product2 = new Product("Card2", 20, 6.5);
        Product product3 = new Product("Card3", 30, 7.5);
        webshop.addProduct(product1);
        webshop.addProduct(product2);
        webshop.addProduct(product3);
        assertEquals("The product Card1 (10 pieces in stock) costs €5.5", webshop.showProductFromProductList(0));
        assertEquals("The product Card2 (20 pieces in stock) costs €6.5", webshop.showProductFromProductList(1));
        assertEquals("The product Card3 (30 pieces in stock) costs €7.5", webshop.showProductFromProductList(2));
    }
}
