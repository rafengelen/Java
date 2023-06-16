package fact.it.ex2.controller;

import fact.it.ex2.model.Course;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class Maincontroller {
    @RequestMapping("/courseinfo")
    public String courseinfo(Model model, HttpServletRequest request){
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        int days = Integer.parseInt(request.getParameter("days"));
        boolean weekly = (request.getParameter("weekly")!=null);

        Course course = new Course(name, days);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate startDate = LocalDate.parse(request.getParameter("startdate"), formatter);

        course.setLocation(location);
        course.setStartDate(startDate);
        course.setWeekly(weekly);

        System.out.println(course.getName());
        System.out.println(course.getLocation());
        System.out.println(course.getStartDate());
        System.out.println(course.getNumberOfDays());
        System.out.println(course.isWeekly());

        model.addAttribute("course", course);
        model.addAttribute("formatter", formatter);

        return "courseinfo";
    }
}
