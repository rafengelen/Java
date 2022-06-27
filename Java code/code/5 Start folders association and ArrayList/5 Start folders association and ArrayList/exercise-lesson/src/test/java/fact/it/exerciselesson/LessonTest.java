package fact.it.exerciselesson;

import fact.it.exerciselesson.model.TimeSlot;
import org.junit.jupiter.api.Test;
import fact.it.exerciselesson.model.TimeSlot;
import fact.it.exerciselesson.model.Lesson;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LessonTest {
    @Test
    public void testConstructorWithParametersAndGetters() {

        TimeSlot timeSlot = new TimeSlot("Tuesday", 2);
        Lesson lesson = new Lesson("Java", "G204", timeSlot);
        assertEquals("Java", lesson.getCourseName());
        assertEquals("G204", lesson.getRoom());
        assertEquals("Tuesday", lesson.getTimeSlot().getDay());
        assertEquals(2, lesson.getTimeSlot().getBlock());
    }

    @Test
    public void testGetters() {
        TimeSlot timeSlot = new TimeSlot("Tuesday", 2);
        Lesson lesson = new Lesson("Java", "G204", timeSlot);
        lesson.setCourseName("Windows");
        assertEquals("Windows", lesson.getCourseName());
        lesson.setRoom("B101");
        assertEquals("B101", lesson.getRoom());
        TimeSlot t2 = new TimeSlot("Friday", 5);
        lesson.setTimeSlot(t2);
        assertEquals("Friday", lesson.getTimeSlot().getDay());
        assertEquals(5, lesson.getTimeSlot().getBlock());
    }

    @Test
    public void testShowLesson() {
        TimeSlot timeSlot = new TimeSlot("Tuesday", 2);
        Lesson lesson = new Lesson("Java", "G214", timeSlot);
        assertEquals("Tuesday, block 2: Java in room G214", lesson.showLesson());
    }

    @Test
    public void testShowLessonWithData() {
        TimeSlot timeSlot = new TimeSlot("Thursday", 3);
        Lesson lesson = new Lesson("HTML5", "G204", timeSlot);
        assertEquals("Thursday, block 3: HTML5 in room G204", lesson.showLesson());
    }
}
