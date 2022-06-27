package fact.it.exercisestudent;

import fact.it.exercisestudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentTest {

    @Test
    public void testConstructorEnGetters() {
        Student s = new Student("Matteo", "r13245");
        assertEquals("r13245", s.getStudentnumber());
        assertEquals("Matteo", s.getName());
        assertEquals(null, s.getAddress());
        assertEquals(null, s.getMajor());

    }

    @Test
    public void testSetters() {
        Student s = new Student("Matteo", "r13245");
        s.setStudentnumber("r9874");
        assertEquals("r9874", s.getStudentnumber());
        s.setName("Simoni");
        assertEquals("Simoni", s.getName());
        s.setAddress("kerkstraat");
        assertEquals("kerkstraat", s.getAddress());
        s.setMajor("Elo-ICT");
        assertEquals("Elo-ICT", s.getMajor());
    }


    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        Student s = new Student("Matteo", "r13245");
        s.setStudentnumber("r9874");
        s.setName("Simoni");
        s.setAddress("kerkstraat");
        s.setMajor("Elo-ICT");
        assertEquals("r9874 Simoni (Elo-ICT) - Address: kerkstraat", s.toString());

    }
    @Test
    public void testToStringExample() {

        Student student = new Student("Rit Verelst", "r0689478");
        student.setAddress("Veldstraat 4 - 2200 Herentals");
        student.setMajor("Toegepaste Informatica");
        assertEquals("r0689478 Rit Verelst (Toegepaste Informatica) - Address: Veldstraat 4 - 2200 Herentals", student.toString());

    }
}
