package fact.it.examplebicycle;

import fact.it.examplebicycle.model.Reservation;
import fact.it.examplebicycle.model.Bicycle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReservationTest {

    @Test
    public void testConstructorAndSettersAndGetters() {
        Bicycle bicycle = new Bicycle("women's bike medium", 2012);
        LocalDate localDate = LocalDate.of(2020, 5, 20);
        Reservation r = new Reservation();
        r.setStartDate(localDate);
        r.setBicycle(bicycle);
        assertEquals(bicycle, r.getBicycle());
        assertEquals(localDate, r.getStartDate());
    }

    @Test
    public void testGetDate() {
        Bicycle bicycle = new Bicycle("women's bike medium", 2012);
        LocalDate localDate = LocalDate.of(2020, 5, 20);
        Reservation r = new Reservation();
        r.setStartDate(localDate);
        r.setBicycle(bicycle);
        assertEquals("20/5/2020", r.getDate());
    }

}
