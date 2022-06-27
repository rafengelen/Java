package fact.it.exthermostat;

import fact.it.exthermostat.model.Thermostat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExThermostatApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExThermostatApplication.class, args);
        // write code starting after this line

        Thermostat mythermostat = new Thermostat();

        System.exit(0);
    }

}
