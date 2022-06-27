package fact.it.exerciserefuelling.controller;

import fact.it.exerciserefuelling.model.Refuelling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {



    @RequestMapping("/submitrefuelling")
    public String submitindex (HttpServletRequest request, Model model){

        int previousMileage = Integer.parseInt(request.getParameter("previousMileage"));
        int currentMileage = Integer.parseInt(request.getParameter("currentMileage"));
        double amountLitres = Double.parseDouble(request.getParameter("amountLitres"));

        Refuelling refuelling = new Refuelling(previousMileage, currentMileage, amountLitres);
        model.addAttribute("refuelling", refuelling);
        return "refuelling";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}


