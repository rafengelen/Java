package fact.it.supplier;

import fact.it.supplier.model.ContactPerson;
import fact.it.supplier.model.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
        //start writing your code here...

        /*
        * Raf Engelen
        * 1ITF02
        * r0901812
        */

        //Creating ContactPersons
        ContactPerson contactPerson1 = new ContactPerson("Al Pacino");
        contactPerson1.setPhoneNumber("0487524163");

        ContactPerson contactPerson2 = new ContactPerson("Marlon Brandon");

        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDateContactPerson2 = LocalDate.parse("2022-02-12", dtf);

        contactPerson2.setLastContact(localDateContactPerson2);


        //Creating Suppliers
        Supplier supplier1 = new Supplier("Mediamarkt", false);
        supplier1.setContactPerson(contactPerson1);

        Supplier supplier2 = new Supplier("Selection", true);
        supplier2.addOrder();
        supplier2.addOrder();

        //ToString
        String printMessage = contactPerson1 + "\n" + contactPerson2 + "\n" + supplier1 + "\n" + supplier2;
        System.out.println(printMessage);


        System.exit(0);
    }

}
