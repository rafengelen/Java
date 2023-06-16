package fact.it.ex2.controller;

import fact.it.ex2.model.School;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model){
        School school = new School();
        model.addAttribute("courses",school.getCourseList());
        return "index";
    }

    @RequestMapping("/students")
    public String students(Model model, HttpServletRequest request){
        School school = new School();

        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");
        String course = request.getParameter("course");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Integer numberOfCourses = Integer.parseInt(request.getParameter("numberOfCourses"));

        model.addAttribute("students", school.getFilteredList(lname, fname, age, numberOfCourses, course));

        return "students";
    }
}
