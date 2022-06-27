package fact.it.exparkingticketmachine;

import fact.it.exparkingticketmachine.model.ParkingTicketMachine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExParkingticketmachineApplicationTests {

    @Test
    public void testConstructorAndGetters() {

        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        assertEquals(0, parkingTicketMachine.getPrice());
        assertEquals(0, parkingTicketMachine.getBalance());
        assertEquals(0, parkingTicketMachine.getTotal());

    }

    @Test
    public void testSetPrice() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setPrice(12);
        assertEquals(12, parkingTicketMachine.getPrice());
    }

    @Test
    public void testSetBalance() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setBalance(20);
        assertEquals(20, parkingTicketMachine.getBalance());
    }

    @Test
    public void testSetTotal() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setTotal(220);
        assertEquals(220, parkingTicketMachine.getTotal());
    }

    @Test
    public void testReceiveMoney() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();

        parkingTicketMachine.receiveMoney(20);
        assertEquals(20, parkingTicketMachine.getBalance());
        assertEquals(0, parkingTicketMachine.getTotal());
    }

    @Test
    public void testShowTicketWithoutCheckingBalanceAndTotal(){
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();

        parkingTicketMachine.setPrice(20);
        parkingTicketMachine.receiveMoney(20);
        assertEquals("#-# Parking meter #-# Ticket = 20 euros #-#", parkingTicketMachine.showTicket());


    }

    @Test
    public void testShowTicketWithMoreThanSufficientBalance() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setPrice(15);
        parkingTicketMachine.receiveMoney(20);
        assertEquals("#-# Parking meter #-# Ticket = 15 euros #-# (change = 5 euros)", parkingTicketMachine.showTicket());
        assertEquals(5, parkingTicketMachine.getBalance());
        assertEquals(15, parkingTicketMachine.getTotal());

    }

    @Test
    public void testShowTicketWithExactSufficientBalance() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setPrice(15);
        parkingTicketMachine.receiveMoney(15);
        assertEquals("#-# Parking meter #-# Ticket = 15 euros #-#", parkingTicketMachine.showTicket());
        assertEquals(0, parkingTicketMachine.getBalance());
        assertEquals(15, parkingTicketMachine.getTotal());
    }


    @Test
    public void testShowTicketWithInsufficientBalance() {
        ParkingTicketMachine parkingTicketMachine = new ParkingTicketMachine();
        parkingTicketMachine.setPrice(15);
        parkingTicketMachine.receiveMoney(10);
        assertEquals("You still need to insert at least 5 euros", parkingTicketMachine.showTicket());
        assertEquals(10, parkingTicketMachine.getBalance());
        assertEquals(0, parkingTicketMachine.getTotal());
    }

}
