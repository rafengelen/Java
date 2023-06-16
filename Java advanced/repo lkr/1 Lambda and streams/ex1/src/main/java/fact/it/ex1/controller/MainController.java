package fact.it.ex1.controller;

import fact.it.ex1.model.PrimeCalculator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/prime")
    public String prime(Model model, HttpServletRequest request){
        int number = Integer.parseInt(request.getParameter("number"));
        PrimeCalculator pr = new PrimeCalculator();
        List<Integer> list = pr.getAllPrimesUntil(number);

        model.addAttribute("list", list);
        return "prime";
    }
}
