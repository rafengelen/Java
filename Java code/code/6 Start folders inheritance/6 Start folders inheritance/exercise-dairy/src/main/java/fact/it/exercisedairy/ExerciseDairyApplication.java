package fact.it.exercisedairy;

import fact.it.exercisedairy.model.Dairy;
import fact.it.exercisedairy.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseDairyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseDairyApplication.class, args);

        Product myProduct = new Product(451278, "Coffee Douwe Egberts", 3.51);
        Dairy myDairy = new Dairy(71990);
        myDairy.setName("Yoghurt BioLine");
        myDairy.setUnitPrice(2.36);
        myDairy.setNumberOfDays(5);
        myDairy.setSupplierCode('A');

        System.out.println("Before lowering freshness and a fast sale (with parameter 5): "+ myDairy.toString());

        myDairy.lowerFreshness();
        myDairy.fastSale(5);

        System.out.println("After lowering freshness and a fast sale (with parameter 5): "+ myDairy.toString());

        System.exit(0);

    }

}
