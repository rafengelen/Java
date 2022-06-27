package fact.it.exercisestudent;

import fact.it.exercisestudent.model.DormStudent;
import fact.it.exercisestudent.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseStudentApplication.class, args);

        Student myStudent = new Student("Laura Wilkens", "r0689478");
        myStudent.setAddress("Veldstraat 4 - 2200 Herentals");
        myStudent.setMajor("Applied Informatics");

        DormStudent myDormStudent = new DormStudent("Ben Lievens", "r075163", "Hoofdstraat 33 - 2440 Geel");
        myDormStudent.setDormLandlord("Maurice Geuns");
        myDormStudent.setAddress("Langstraat 9 - 2150 Borsbeek");
        myDormStudent.setMajor("Elektronica ICT");

        System.out.println(myStudent.toString());
        System.out.println(myDormStudent.toString());


        System.exit(0);

    }

}
