package fact.it.refuelling;

import fact.it.refuelling.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RefuellingTests {
    //testmethod_initialstate_expectedstate
    @Test
    public void refuellingConstructor_input_returnsExpected(){
        int id = 1;
        int previousMileage=100;
        int currentMileage = 200;
        double amountInLitres = 10.8;
        Refuelling ref = new Refuelling(id,previousMileage,currentMileage,amountInLitres);
        assertEquals(ref.getId(),id);
        assertEquals(ref.getPreviousMileage(),previousMileage);
        assertEquals(ref.getCurrentMileage(),currentMileage);
        assertEquals(ref.getAmountInLitres(),amountInLitres);
    }

    @Test
    public void refuellingSetters_input_returnsInput(){
        int id = 1;
        int previousMileage=100;
        int currentMileage = 200;
        double amountInLitres = 10.8;
        Refuelling ref = new Refuelling(2,50,60,3.7);

        ref.setId(id);
        ref.setAmountInLitres(amountInLitres);
        ref.setCurrentMileage(currentMileage);
        ref.setPreviousMileage(previousMileage);

        assertEquals(ref.getId(),id);
        assertEquals(ref.getPreviousMileage(),previousMileage);
        assertEquals(ref.getCurrentMileage(),currentMileage);
        assertEquals(ref.getAmountInLitres(),amountInLitres);
    }
}
