package fact.it.exercisesupplier;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.exercisesupplier.model.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SupplierTest {
    @Test
    public void testConstructorZonderParametersEnGetters() {

        Supplier supplier = new Supplier("Company", "Jan", new Residence());
        assertEquals("Jan", supplier.getContactPerson());
        assertEquals("Company", supplier.getName());
        assertEquals(0, supplier.getResidence().getZipCode());
        assertEquals("no data", supplier.getResidence().getMunicipality());
        assertEquals("no data", supplier.getResidence().getStreetAndNumber());

    }

    @Test
    public void testSetters() {
        Supplier supplier = new Supplier("Bedrijf", "Jan", new Residence());
        supplier.setContactPerson("Jan");
        assertEquals("Jan", supplier.getContactPerson());
        supplier.setName("Testbedrijf");
        assertEquals("Testbedrijf", supplier.getName());
        Residence woonplaats = new Residence("Kerkstraat 6", 2450, "Meerhout");
        supplier.setResidence(woonplaats);
        assertEquals(2450, supplier.getResidence().getZipCode());
        assertEquals("Meerhout", supplier.getResidence().getMunicipality());
        assertEquals("Kerkstraat 6", supplier.getResidence().getStreetAndNumber());
    }

    @Test
    public void testShowSupplier() {
        Residence residence = new Residence("Kerkstraat 6", 2450, "Meerhout");
        Supplier supplier = new Supplier("Testbedrijf", "Jan", residence);
        assertEquals("Supplier \"Testbedrijf\", contact person Jan\nAddress: Kerkstraat 6, 2450 Meerhout", supplier.showSupplier());
    }

    @Test
    public void testDrukAfMetOpgaveGegevens() {
        Residence woonplaats = new Residence("Berkendreef 24 bus 7", 2000, "Antwerpen");
        Supplier supplier = new Supplier("U&Me", "Jef Perks", woonplaats);
        assertEquals("Supplier \"U&Me\", contact person Jef Perks\nAddress: Berkendreef 24 bus 7, 2000 Antwerpen", supplier.showSupplier());
    }

}
