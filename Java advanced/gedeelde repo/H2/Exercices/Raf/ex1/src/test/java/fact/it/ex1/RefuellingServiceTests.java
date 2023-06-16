package fact.it.ex1;
import fact.it.ex1.model.Refuelling;
import fact.it.ex1.model.RefuellingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RefuellingServiceTests {
    @Test
    public void testAdd(){
        Refuelling refuelling = new Refuelling(01,30,70,20.1);
        RefuellingService refuellingService = new RefuellingService();
        refuellingService.addRefuelling(refuelling);

        assertEquals(refuelling,refuellingService.getOptionalRefuelingById(1).get());
    }
}
