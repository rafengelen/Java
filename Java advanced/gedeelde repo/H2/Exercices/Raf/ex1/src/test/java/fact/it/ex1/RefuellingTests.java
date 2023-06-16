package fact.it.ex1;

import fact.it.ex1.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RefuellingTests {
    @Test
    public void testConstructor(){
        Refuelling ref = new Refuelling(1,2000,2010,5.5);
        assertNotNull(ref);
    }
    @Test
    public void testIdGetSet(){
        int idInput = 3;
        Refuelling ref = new Refuelling(1,2000,2010,5.5);
        ref.setId(idInput);
        assertEquals(idInput, ref.getId());
    }
    @Test
    public void testPreviousMileageGetSet(){
        int previousMileageInput = 2005;
        Refuelling ref = new Refuelling(1,2000,2010,5.5);
       ref.setPreviousMileage(previousMileageInput);
        assertEquals(previousMileageInput, ref.getPreviousMileage());
    }
    @Test
    public void testCurrentMileageGetSet(){
        int currentMileageInput = 2005;
        Refuelling ref = new Refuelling(1,2000,2010,5.5);
        ref.setCurrentMileage(currentMileageInput);
        assertEquals(currentMileageInput, ref.getCurrentMileage());
    }
    @Test
    public void testAmountInLitresGetSet(){
        double amountInLitres = 10.10;
        Refuelling ref = new Refuelling(1,2000,2010,5.5);
        ref.setAmountInLitres(amountInLitres);
        assertEquals(amountInLitres, ref.getAmountInLitres());
    }
}
