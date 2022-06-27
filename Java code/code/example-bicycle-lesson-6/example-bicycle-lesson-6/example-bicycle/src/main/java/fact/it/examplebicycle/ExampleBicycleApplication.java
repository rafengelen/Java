package fact.it.examplebicycle;

import fact.it.examplebicycle.model.Bicycle;
import fact.it.examplebicycle.model.EBike;
import fact.it.examplebicycle.model.Reservation;
import fact.it.examplebicycle.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ExampleBicycleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleBicycleApplication.class, args);
        Bicycle bicycle = new Bicycle("women's large bicycle", 2018);
        bicycle.setRentalPrice(5.6);

        Reservation reservation1 = new Reservation();
        reservation1.setBicycle(bicycle);
        LocalDate today = LocalDate.now();
        reservation1.setStartDate(today);

        System.out.println("Reservation:");
        System.out.println("Start date: " + reservation1.getDate());
        System.out.println("Bicycle type: " + reservation1.getBicycle().getType());

        Reservation reservation2 = new Reservation();
        reservation2.setBicycle(bicycle);
        LocalDate nextMonth = LocalDate.of(2021, 4, 1);
        reservation2.setStartDate(nextMonth);


        Student student = new Student("r0781245", "Leen", "Schryvers");
        student.addReservation(reservation1);
        student.addReservation(reservation2);

        System.out.println("Startdates of reservations for " + student.getFullName());
        System.out.println(student.getReservationDates());


        EBike eBike = new EBike("men's bike small", 2018);
        eBike.setSpeedBike(true);
        eBike.setBattery(500);
        System.out.println(bicycle);
        System.out.println(eBike);
        System.exit(0);
    }

}
