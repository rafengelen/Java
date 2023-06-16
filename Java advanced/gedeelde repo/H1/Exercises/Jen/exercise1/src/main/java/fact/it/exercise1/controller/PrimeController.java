package fact.it.exercise1.controller;

import fact.it.exercise1.model.PrimeCalculator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PrimeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/getprimes")
    public String getPrimes(Model model, HttpServletRequest request){
        PrimeCalculator pc = new PrimeCalculator();
        int num = Integer.parseInt(request.getParameter("value"));

        List<Integer> primes = pc.getAllPrimesUntil(num);

        model.addAttribute("primeList", primes);

        return "getprimes";
    }
}
