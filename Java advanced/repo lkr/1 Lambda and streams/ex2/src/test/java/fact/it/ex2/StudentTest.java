package fact.it.ex2;

import fact.it.ex2.model.Course;
import fact.it.ex2.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentTest {

    @Test
    public void testCourseWithoutParameters(){
        Student student = new Student();
        assertNull(student.getFirstName());
        assertNull(student.getLastName());
        assertNull(student.getAge());
        assertNull(student.getCourses());
    }
    @Test
    public void testCourseWithParameters(){
        Course programmerI = new Course("Programmer I", 5);
        Course sqlDatabases = new Course("SQL Databases", 3);
        Course linux = new Course("Linux", 8);


        Student student = new Student("first name", "last name", 12, Arrays.asList(programmerI, sqlDatabases, linux));
        assertEquals("first name",student.getFirstName());
        assertEquals("last name", student.getLastName());
        assertEquals(12, student.getAge());
        assertEquals(Arrays.asList(programmerI, sqlDatabases, linux), student.getCourses());
    }
    @Test
    public void testSetter(){
        Course programmerI = new Course("Programmer I", 5);
        Course sqlDatabases = new Course("SQL Databases", 3);
        Course linux = new Course("Linux", 8);

        Student student = new Student();

        student.setFirstName("first name");
        student.setLastName("last name");
        student.setAge(12);
        student.setCourses(Arrays.asList(programmerI, sqlDatabases, linux));

        assertEquals("first name",student.getFirstName());
        assertEquals("last name", student.getLastName());
        assertEquals(12, student.getAge());
        assertEquals(Arrays.asList(programmerI, sqlDatabases, linux), student.getCourses());
    }
}
