package fact.it.exerciselesson;

import fact.it.exerciselesson.model.Lesson;
import fact.it.exerciselesson.model.TimeSlot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseLessonApplication.class, args);

        TimeSlot myTimeSlot = new TimeSlot("Thursday", 3);
        Lesson myLesson = new Lesson("IOT essentials","P108Z", myTimeSlot);


         System.out.println(myLesson.showLesson());

        System.exit(0);
    }

}
