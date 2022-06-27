package fact.it.exercisebeverage;

import fact.it.exercisebeverage.model.Beverage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeverageTest {

    @Test
    public void testConstructorWithoutParametersAndGetters() {
        Beverage beverage = new Beverage();
        assertEquals(null, beverage.getName());
        assertEquals(0.0, beverage.getPrice(), 0.1);
        assertEquals(0, beverage.getVolume());
        assertEquals(0.0, beverage.getAlcoholPercentage(), 0.1);
    }

    @Test
    public void testConstructorWithParametersAndGetters() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2 );
        assertEquals("Beer", beverage.getName());
        assertEquals(1.2, beverage.getPrice(), 0.1);
        assertEquals(250, beverage.getVolume());
        assertEquals(4.2, beverage.getAlcoholPercentage(), 0.1);
    }

    @Test
    public void testSetters() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2 );
        beverage.setName("limonade");
        assertEquals("limonade", beverage.getName());
        beverage.setPrice(0.8);
        assertEquals(0.8, beverage.getPrice(), 0.1);
        beverage.setVolume(300);
        assertEquals(300, beverage.getVolume());
        beverage.setAlcoholPercentage(0.0);
        assertEquals(0.0, beverage.getAlcoholPercentage(), 0.1);
    }

    @Test
    public void testIsLiquorLowPercentage() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2 );
        assertEquals(false, beverage.isLiquor());
    }

    @Test
    public void testIIsLiquorHighPercentage() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 36 );
        assertEquals(true, beverage.isLiquor());
    }

    @Test
    public void testIsLiquorExact35() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 35 );
        assertEquals(true, beverage.isLiquor());
    }

    @Test
    public void testGetPricePerLiterVoorbeeld() {
        Beverage beverage = new Beverage("Beer", 1.2, 250, 4.2 );
        assertEquals(4.8, beverage.getPricePerLiter(), 0.1);
    }

}
