package fact.it.ex2;

import fact.it.ex2.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CourseTest {
    @Test
    public void testCourseWithoutParameters(){
        Course course = new Course();
        assertNull(course.getName());
        assertNull(course.getStudyPoints());
    }
    @Test
    public void testCourseWithParameters(){
        Course course = new Course("Java Advanced", 6);
        assertEquals("Java Advanced",course.getName());
        assertEquals(6, course.getStudyPoints());
    }
    @Test
    public void testGetName(){
        Course course = new Course("Java Advanced", 6);
        assertEquals("Java Advanced",course.getName());
    }
    @Test
    public void testSetName(){
        Course course = new Course();
        course.setName("Java Advanced");
        assertEquals("Java Advanced",course.getName());
    }
    @Test
    public void testGetStudyPoints(){
        Course course = new Course("Java Advanced", 6);
        assertEquals(6,course.getStudyPoints());
    }
    @Test
    public void testSetStudyPoints(){
        Course course = new Course();
        course.setStudyPoints(6);
        assertEquals(6,course.getStudyPoints());
    }
}
