package fact.it.exerciselesson;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fact.it.exerciselesson.model.TimeSlot;
import fact.it.exerciselesson.model.Lesson;

@SpringBootTest
public class TimeSlotTest {

    @Test
    public void testConstructorWithoutParametersAndGetters() {
        TimeSlot timeSlot = new TimeSlot();
        assertEquals("Monday", timeSlot.getDay());
        assertEquals(1, timeSlot.getBlock());
    }

    @Test
    public void testConstructorWithParametersAndGetters() {
        TimeSlot timeSlot = new TimeSlot("Tuesday",2);
        assertEquals("Tuesday", timeSlot.getDay());
        assertEquals(2, timeSlot.getBlock());
    }

    @Test
    public void testSetters() {
        TimeSlot timeSlot = new TimeSlot("Tuesday",2);
        timeSlot.setDay("Sunday");
        assertEquals("Sunday", timeSlot.getDay());
        timeSlot.setBlock(5);
        assertEquals(5, timeSlot.getBlock());
    }

    @Test
    public void testShowTimeSlot() {
        TimeSlot timeSlot = new TimeSlot("Tuesday",2);
        assertEquals("Tuesday, block 2", timeSlot.showTimeSlot());
    }

}
