package fact.it.exparkingticketmachine;

import fact.it.exparkingticketmachine.model.ParkingTicketMachine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExParkingticketmachineApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExParkingticketmachineApplication.class, args);
        // write code starting after this line

        ParkingTicketMachine myParkingTicketMachine = new ParkingTicketMachine();
        myParkingTicketMachine.setPrice(10);
        System.out.println(myParkingTicketMachine.showTicket());

        System.exit(0);
    }

}
