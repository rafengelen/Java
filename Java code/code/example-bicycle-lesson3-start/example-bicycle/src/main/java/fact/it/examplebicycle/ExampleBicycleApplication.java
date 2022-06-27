package fact.it.examplebicycle;

import fact.it.examplebicycle.model.Bicycle;
import fact.it.examplebicycle.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExampleBicycleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleBicycleApplication.class, args);
        // write code starting after this line
        Bicycle myBicycle = new Bicycle();
        myBicycle.setType("women's bicycle large");
        myBicycle.setYear(2016);
        myBicycle.setRentalPrice(4.5);

        System.out.println("You created a Bicycle-object with the following values:");
        System.out.println("The type of your bicycle is: " + myBicycle.getType());
        System.out.println("The year of your bicycle is: " + myBicycle.getYear());
        System.out.println("The rental price of your bicycle is: " + myBicycle.getRentalPrice());

        myBicycle.increasePrice();
        System.out.println("After increasing the price, the rental price is now: " + myBicycle.getRentalPrice());
        System.out.println("And the price per year is: " + myBicycle.getPricePerYear());

        Student student = new Student("r0748545", "John", "Smith");
        student.setForeigner(true);
        System.out.println("Student data: ");
        System.out.println("Full name: " + student.getFullName());
        System.out.println("Email: " + student.getEmailAddress());

        Bicycle myBicycle2 = new Bicycle("men's bycicle medium", 2020);
        myBicycle2.setRentalPrice(4.5);
        System.out.println("The rental price of your bicycle is: " + myBicycle2.getRentalPrice());
        myBicycle2.increasePrice(1.0);
        System.out.println("The rental price of your bicycle is: " + myBicycle2.getRentalPrice());
        System.exit(0);
    }

}
