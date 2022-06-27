package fact.it.exthermostat;

import fact.it.exthermostat.model.Thermostat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExThermostatApplicationTests {

    @Test
    public void testConstructorAndGettersJuist() {

        Thermostat thermostaat = new Thermostat(21, 40, -25, 2);
        assertEquals(21, thermostaat.getTemperature());
        assertEquals(40, thermostaat.getMaxTemp());
        assertEquals(-25, thermostaat.getMinTemp());
        assertEquals(2, thermostaat.getIncrement());

    }


    @Test
    public void testConstructorAndGettersMinMaxChanged() {

        Thermostat thermostaat = new Thermostat(21, -20, 25, 2);
        assertEquals(21, thermostaat.getTemperature());
        assertEquals(25, thermostaat.getMaxTemp());
        assertEquals(-20, thermostaat.getMinTemp());
        assertEquals(2, thermostaat.getIncrement());

    }

    @Test
    public void testConstructorAndGettersTempNotCorrect() {

        Thermostat thermostaat = new Thermostat(45, 40, -25, 2);
        assertEquals(7, thermostaat.getTemperature());
        assertEquals(40, thermostaat.getMaxTemp());
        assertEquals(-25, thermostaat.getMinTemp());
        assertEquals(2, thermostaat.getIncrement());

    }


    @Test
    public void testConstructorAndGettersNegativeIncrement() {

        Thermostat thermostaat = new Thermostat(21, 40, -25, -2);
        assertEquals(21, thermostaat.getTemperature());
        assertEquals(40, thermostaat.getMaxTemp());
        assertEquals(-25, thermostaat.getMinTemp());
        assertEquals(2, thermostaat.getIncrement());

    }



    @Test
    public void testSetIncrementNegativeValue() {
        Thermostat thermostaat = new Thermostat(21, 40, -25, 2);
        thermostaat.setIncrement(-3);
        assertEquals(3, thermostaat.getIncrement());
    }


    @Test
    public void testSetIncrementCorrect() {
        Thermostat thermostaat = new Thermostat(21, 40, -25, 2);
        thermostaat.setIncrement(5);
        assertEquals(5, thermostaat.getIncrement());
    }


    @Test
    public void testWarmerWithinBorder() {
        Thermostat thermostaat = new Thermostat(21, 40, -25, 2);
        thermostaat.warmer();
        assertEquals(23, thermostaat.getTemperature());
    }


    @Test
    public void testWarmerOutsideBorder() {
        Thermostat thermostaat = new Thermostat(39, 40, -25, 2);
        thermostaat.warmer();
        assertEquals(40, thermostaat.getTemperature());
    }


    @Test
    public void testCoolerWithinBorder() {
        Thermostat thermostaat = new Thermostat(21, 40, -25, 2);
        thermostaat.colder();
        assertEquals(19, thermostaat.getTemperature());
    }


    @Test
    public void testCoolerOutsideBorder() {
        Thermostat thermostaat = new Thermostat(-24, 40, -25, 2);
        thermostaat.colder();
        assertEquals(-25, thermostaat.getTemperature());
    }

}
