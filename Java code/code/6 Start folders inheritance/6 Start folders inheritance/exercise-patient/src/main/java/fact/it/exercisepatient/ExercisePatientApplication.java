package fact.it.exercisepatient;

import fact.it.exercisepatient.model.Consultation;
import fact.it.exercisepatient.model.Doctor;
import fact.it.exercisepatient.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercisePatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercisePatientApplication.class, args);

        Doctor myDoctor = new Doctor("Lea Lebon", "Cardiologist");
        Patient myPatient = new Patient("Tom Verlaet" + "750510 105M16");
        Consultation myConsultation = new Consultation(myDoctor, myPatient);

        System.out.println(myConsultation.toString());

        System.exit(0); }

}
