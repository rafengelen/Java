package fact.it.examplebicycle;

import fact.it.examplebicycle.model.Bicycle;
import fact.it.examplebicycle.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import fact.it.examplebicycle.model.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {
    @Test
    public void testNoArgConstructorAndGetters() {
        Student student = new Student();
        assertEquals(null, student.getRnumber());
        assertEquals(null, student.getFirstName());
        assertEquals(null, student.getSurname());
        assertEquals(false, student.isForeigner());
    }

    @Test
    public void testConstructorWithParametersAndGetters() {
        Student student = new Student("r123456", "Marie", "Janssen");
        assertEquals("r123456", student.getRnumber());
        assertEquals("Marie", student.getFirstName());
        assertEquals("Janssen", student.getSurname());
        assertEquals(false, student.isForeigner());
    }

    @Test
    public void testSetFirstName() {
        Student student = new Student();
        student.setFirstName("Lies");
        assertEquals("Lies", student.getFirstName());
    }

    @Test
    public void testSetSurname() {
        Student student = new Student();
        student.setSurname("Peeters");
        assertEquals("Peeters", student.getSurname());
    }

    @Test
    public void testSetForeigner() {
        Student student = new Student();
        student.setForeigner(true);
        assertEquals(true, student.isForeigner());
    }

    @Test
    public void testGetEmailAddress() {
        Student student = new Student("r123456", "Marie", "Janssen");
        assertEquals("r123456@student.thomasmore.be", student.getEmailAddress());
    }

    @Test
    public void testGetInitials() {
        Student student = new Student("r123456", "Marie", "Janssen");
        assertEquals("MJa", student.getInitials());
    }

    @Test
    public void testGetFullName() {
        Student student = new Student("r123456", "Marie", "Janssen");
        assertEquals("Marie JANSSEN (MJa)", student.getFullName());
    }


    @Test
    public void testAdd1Reservation(){
        Student student = new Student("r123456", "Marie", "Janssen");
        Bicycle bicycle = new Bicycle("women's bike medium", 2012);
        LocalDate localDate = LocalDate.of(2021, 5, 20);
        Reservation r = new Reservation();
        r.setStartDate(localDate);
        r.setBicycle(bicycle);
        student.addReservation(r);
        assertEquals("20/5/2021 ",student.getReservationDates());
    }

    public void testAdd2Reservations(){
        Student student = new Student("r123456", "Marie", "Janssen");
        Bicycle bicycle = new Bicycle("women's bike medium", 2012);
        LocalDate localDate1 = LocalDate.of(2021, 5, 20);
        Reservation r1 = new Reservation();
        r1.setStartDate(localDate1);
        r1.setBicycle(bicycle);
        student.addReservation(r1);
        LocalDate localDate2 = LocalDate.of(2021, 8, 1);
        Reservation r2 = new Reservation();
        r2.setStartDate(localDate2);
        r2.setBicycle(bicycle);
        student.addReservation(r2);
        assertEquals("20/5/2021 1/5/2021",student.getReservationDates());
    }
}
