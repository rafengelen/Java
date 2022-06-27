package fact.it.exercisecourse.controller;

import fact.it.exercisecourse.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class MainController {
    @RequestMapping("/registerCourse")
    public String registerCourse(HttpServletRequest request, Model model){

        String name = request.getParameter("courseName");
        int numberOfDays = Integer.parseInt(request.getParameter("numberOfDays"));

        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        String location = request.getParameter("location");

        Course course = new Course(name, numberOfDays);
        course.setLocation(location);
        course.setStartDate(startDate);

        if (request.getParameter("weekly") != null){
            course.setWeekly(true);
        }

        model.addAttribute("course", course);
        return "courseinfo";
    }


}

