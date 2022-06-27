package fact.it.exercisesupplier;

import fact.it.exercisesupplier.model.Residence;
import fact.it.exercisesupplier.model.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseSupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseSupplierApplication.class, args);

        Residence myResidence = new Residence("Berkendreef 24 bus 7", 2000, "Antwerpen");
        Supplier mySupplier = new Supplier("U&Me", "Jef Perkens", myResidence);

        System.exit(0);
    }

}
