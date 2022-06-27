package fact.it.exline;

import fact.it.exline.model.Line;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExLineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExLineApplication.class, args);
        // write code starting after this line

        Line line1 = new Line();
        Line line2 = new Line();
        System.exit(0);
    }

}
