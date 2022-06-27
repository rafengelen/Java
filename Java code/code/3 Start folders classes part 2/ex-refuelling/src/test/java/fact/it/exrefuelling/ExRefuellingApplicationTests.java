package fact.it.exrefuelling;

import fact.it.exrefuelling.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class ExRefuellingApplicationTests {

    @Test
    public void testConstructorAndGetters() {

        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        assertEquals(1000, refuelling.getPreviousMileage());
        assertEquals(1800, refuelling.getCurrentMileage());
        assertEquals(60, refuelling.getAmountInLiters(), 0.01);

    }


    @Test
    public void testSetPreviousMileage() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setPreviousMileage(1200);
        assertEquals(1200, refuelling.getPreviousMileage());
    }


    @Test
    public void testSetCurrentMileage() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setCurrentMileage(1900);
        assertEquals(1900, refuelling.getCurrentMileage());
    }


    @Test
    public void testSetAmountInLiters() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setAmountInLiters(50.2);
        assertEquals(50.2, refuelling.getAmountInLiters(), 0.1);
    }


    @Test
    public void testGetFuelConsumption() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);

        assertEquals(7.5, refuelling.getFuelConsumption(), 0.1);
    }

}
