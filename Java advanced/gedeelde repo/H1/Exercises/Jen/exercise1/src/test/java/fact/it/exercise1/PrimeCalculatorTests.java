package fact.it.exercise1;

import fact.it.exercise1.model.PrimeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrimeCalculatorTests {

    @Test
    public void isPrime1False(){
        PrimeCalculator pc = new PrimeCalculator();

        assertFalse(pc.isPrime(1));
    }

    @Test
    public void isPrime0False(){
        PrimeCalculator pc = new PrimeCalculator();

        assertFalse(pc.isPrime(0));
    }

    @Test
    public void isPrimeMinus3False(){
        PrimeCalculator pc = new PrimeCalculator();

        assertFalse(pc.isPrime(-3));
    }

    @Test
    public void isPrime2True(){
        PrimeCalculator pc = new PrimeCalculator();

        assertTrue(pc.isPrime(2));
    }

    @Test
    public void isPrime4False(){
        PrimeCalculator pc = new PrimeCalculator();

        assertFalse(pc.isPrime(4));
    }

    @Test
    public void testGetAllPrimesUntil(){
        PrimeCalculator pc = new PrimeCalculator();

        assertEquals(List.of(2, 3, 5, 7,11,13,17,19), pc.getAllPrimesUntil(22));
    }

    @Test
    public void testGetListOfAllNumsUntill(){
        PrimeCalculator pc = new PrimeCalculator();

        assertEquals(List.of(4,5,6,7,8,9,10,11,12,13), pc.getListOfAllNumbersUntil(4, 13));
    }
}
