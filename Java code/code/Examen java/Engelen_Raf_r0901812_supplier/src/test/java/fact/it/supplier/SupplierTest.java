package fact.it.supplier;

import fact.it.supplier.model.ContactPerson;
import fact.it.supplier.model.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SupplierTest {

    @Test
    public void NoArgAndGettersSupplier() {
        Supplier supplier = new Supplier();
        assertEquals(1, supplier.getTotalOrders());
        assertEquals(null, supplier.getContactPerson());
        assertEquals(null,supplier.getCompanyName());
        assertEquals(false, supplier.isActive());
    }
    @Test
    public void ConstructorAndGettersSupplier() {
        Supplier supplier = new Supplier("Esso", true);
        assertEquals(1, supplier.getTotalOrders());
        assertEquals(null, supplier.getContactPerson());
        assertEquals("Esso",supplier.getCompanyName());
        assertEquals(true, supplier.isActive());
    }

    @Test
    public void addContactpersonSupplier() {
        Supplier supplier = new Supplier("Esso", true);
        supplier.addNewContactPerson("Pete", "01245");
        assertNotNull(supplier.getContactPerson());
    }

    @Test
    public void addTotalOrders1Supplier() {
        Supplier supplier = new Supplier();
        supplier.addOrder();
        assertEquals(2, supplier.getTotalOrders());
    }
    @Test
    public void addTotalOrders2Supplier() {
        Supplier supplier = new Supplier();
        supplier.addOrder();
        assertEquals(2, supplier.getTotalOrders());
    }
    @Test
    public void addTotalOrders3Supplier() {
        Supplier supplier = new Supplier();
        supplier.addOrder();
        supplier.addOrder();
        assertEquals(3, supplier.getTotalOrders());
    }

    @Test
    public void toString1Supplier() {
        Supplier supplier = new Supplier();
        supplier.setCompanyName("Spar");
        supplier.addOrder();
        supplier.addOrder();
        assertEquals("Spar has no contact person and 3 order(s). (Not Active)", supplier.toString());
    }
    @Test
    public void toString2Supplier() {
        Supplier supplier = new Supplier();
        supplier.setCompanyName("Inno");
        supplier.setContactPerson(new ContactPerson("name"));
        supplier.setActive(true);
        assertEquals("Inno has a contact person and 1 order(s).", supplier.toString());
    }
}
