package fact.it.exercisestudent;

import fact.it.exercisestudent.model.DormStudent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DormStudentTest {

    @Test
    public void testConstructorEnGetters() {
        DormStudent k = new DormStudent("Katleen", "r450067", "Kleinhoefstraat");
        assertEquals("r450067", k.getStudentnumber());
        assertEquals("Katleen", k.getName());
        assertEquals(null, k.getAddress());
        assertEquals(null, k.getMajor());
        assertEquals("Kleinhoefstraat", k.getDormAddress());
        assertEquals(null, k.getDormLandlord());
    }

    @Test
    public void testSetters() {
        DormStudent k = new DormStudent("Matteo", "r123456", "Kleinhoefstraat");
        k.setStudentnumber("r9874");
        assertEquals("r9874", k.getStudentnumber());
        k.setName("Sandra");
        assertEquals("Sandra", k.getName());
        k.setAddress("Hoofdstraat");
        assertEquals("Hoofdstraat", k.getAddress());
        k.setMajor("IT");
        assertEquals("IT", k.getMajor());
        k.setDormAddress("hofstraat");
        assertEquals("hofstraat", k.getDormAddress());
        k.setDormLandlord("Jan");
        assertEquals("Jan", k.getDormLandlord());
    }

    /**
     * Test of toString method, of class DormStudent.
     */
    @Test
    public void testToString() {
        DormStudent k = new DormStudent("Sandra", "r0123456", "Kleinhoefstraat");

        k.setName("Simoni");
        k.setAddress("kerkstraat");
        k.setMajor("IT");
        k.setDormAddress("hofstraat");
        k.setDormLandlord("Jan");
        assertEquals("r0123456 Simoni (IT) - Dorm address: hofstraat (landlord: Jan)", k.toString());
    }

    @Test
    public void testToStringExample() {
        DormStudent dormStudent = new DormStudent("Jarne Lievens", "r075163", "Velveken 33 - 2440 Geel");
        dormStudent.setAddress("Lange Nieuwstraat 9 - 2150 Borsbeek");
        dormStudent.setMajor("Elektronica-ICT");
        dormStudent.setDormLandlord("Maurice Geuns");
        assertEquals("r075163 Jarne Lievens (Elektronica-ICT) - Dorm address: Velveken 33 - 2440 Geel (landlord: Maurice Geuns)", dormStudent.toString());
    }
}
