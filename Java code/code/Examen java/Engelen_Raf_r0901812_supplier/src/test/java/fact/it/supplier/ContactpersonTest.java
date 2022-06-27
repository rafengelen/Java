package fact.it.supplier;

import fact.it.supplier.model.ContactPerson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContactpersonTest {
    @Test
    public void testNoArgConstructorAndGettersContactperson() {
        ContactPerson contactPerson = new ContactPerson("John");
        assertEquals("(phone number is not set)", contactPerson.getPhoneNumber());
        assertEquals("John", contactPerson.getName());
        assertEquals(LocalDate.now(), contactPerson.getLastContact());
    }

    @Test
    public void testSettersNameAndLastContactContactperson() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setLastContact(LocalDate.of(2021,05,13));
        contactPerson.setName("Mary");
        assertEquals(LocalDate.of(2021,05,13), contactPerson.getLastContact());
        assertEquals("Mary", contactPerson.getName());
    }

    @Test
    public void testSetPhoneNumberContactpersonWrong1() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setPhoneNumber("049725143");
        assertEquals("(phone number is not set)", contactPerson.getPhoneNumber());
    }
    @Test
    public void testSetPhoneNumberContactpersonWrong2() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setPhoneNumber("4972514324");
        assertEquals("(phone number is not set)", contactPerson.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumberContactpersonCorrect() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setPhoneNumber("0497251432");
        assertEquals("0497/25.14.32", contactPerson.getPhoneNumber());
    }

    @Test
    public void testContactpersonToString1() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setLastContact(LocalDate.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yy");
        assertEquals("John (phone number is not set) Last contact " + LocalDate.now().format(dtf), contactPerson.toString());
    }

    @Test
    public void testContactpersonToString2() {
        ContactPerson contactPerson = new ContactPerson("John");
        contactPerson.setLastContact(LocalDate.of(2020,05,1));
        contactPerson.setPhoneNumber("0548796522");
        assertEquals("John 0548/79.65.22 Last contact 1/5/20", contactPerson.toString());
    }
}
