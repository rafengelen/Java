package fact.it.exercisesupplier;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fact.it.exercisesupplier.model.*;

@SpringBootTest
public class ResidenceTest {

    @Test
    public void testConstructorWithoutParametersEnGetters() {

        Residence residence = new Residence();

        assertEquals(0, residence.getZipCode());
        assertEquals("no data", residence.getStreetAndNumber());
        assertEquals("no data", residence.getMunicipality());

    }
    
    @Test
    public void testConstructorWithParametersEnGetters() {

        Residence residence = new Residence("Kerkstraat 6", 2450, "Meerhout");

        assertEquals(2450, residence.getZipCode());
        assertEquals("Kerkstraat 6", residence.getStreetAndNumber());
        assertEquals("Meerhout", residence.getMunicipality());

    }
    
    @Test
    public void testSetters() {
        Residence residence = new Residence("Kerkstraat 6", 2450, "Meerhout");
        residence.setZipCode(2440);
        assertEquals(2440, residence.getZipCode());
        residence.setStreetAndNumber("Kiezel 8");
        assertEquals("Kiezel 8", residence.getStreetAndNumber());
        residence.setMunicipality("Geel");
        assertEquals("Geel", residence.getMunicipality());

    }

}
