package fact.it.exline;

import fact.it.exline.model.Line;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ExLineApplicationTests {

    @Test
    public void testConstructorAndGetters() {

        Line line = new Line();

        assertEquals(1, line.getThickness());


    }


    @Test
    public void testSetters() {
        Line line = new Line();
        line.setBeginningX(5);
        assertEquals(5, line.getBeginningX());
        line.setBeginningY(7);
        assertEquals(7, line.getBeginningY());
        line.setEndX(15);
        assertEquals(15, line.getEndX());
        line.setEndY(17);
        assertEquals(17, line.getEndY());
        line.setThickness(3);
        assertEquals(3, line.getThickness());

    }


    @Test
    public void testMakeDunner() {
        Line line = new Line();
        line.setThickness(3);
        line.makeThinner();

        assertEquals(2, line.getThickness());
    }


    @Test
    public void testMakeDikker() {
        Line line = new Line();
        line.setThickness(3);
        line.makeThicker();

        assertEquals(4, line.getThickness());
    }


    @Test
    public void testShowCharateristics() {
        Line line = new Line();
        line.setBeginningX(5);
        line.setBeginningY(7);
        line.setEndX(15);
        line.setEndY(17);
        line.setThickness(3);
        assertEquals("Line starts at (5,7), line ends at (15,17) and the thickness is: 3", line.showCharacteristics());
    }

}
