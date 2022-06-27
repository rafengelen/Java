package fact.it.supplier;


import fact.it.supplier.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CompanyTest {


    @Test
    public void testNoArgAndGettersCompany() {
        Company company = new Company();
        assertEquals(false, company.isActive());
        assertNull(company.getCompanyName());
    }

    @Test
    public void testConstructorAndGettersCompany() {
        Company company = new Company("companyName", true);
        assertEquals(true, company.isActive());
        assertEquals("companyName", company.getCompanyName());
    }

    @Test
    public void testSetterCompany() {
        Company company = new Company();
        company.setCompanyName("newName");
        company.setActive(true);

        assertEquals(true, company.isActive());
        assertEquals("newName", company.getCompanyName());
    }

    @Test
    public void testToStringCompany1() {
        Company company = new Company();
        company.setCompanyName("Belle");
        company.setActive(true);
        assertEquals("Belle", company.toString());


    }
    @Test
    public void testToStringCompany2() {
        Company company = new Company();
        company.setCompanyName("Inno");
        company.setActive(false);
        assertEquals("Inno (Not Active)", company.toString());

    }

}
