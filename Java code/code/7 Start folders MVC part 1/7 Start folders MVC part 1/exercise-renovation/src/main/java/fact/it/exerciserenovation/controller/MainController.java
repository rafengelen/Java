package fact.it.exerciserenovation.controller;

import fact.it.exerciserenovation.model.Renovationproject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/calculatePaint")
    public String calculatePaint(HttpServletRequest request, Model model) {
        double length = Double.parseDouble(request.getParameter("length"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));

        Renovationproject renovationproject = new Renovationproject(length, width, height);


        if (request.getParameter("ceiling") != null) {
            renovationproject.setCeilingIncluded(true);
        }
        else{
            renovationproject.setCeilingIncluded(false);
        }

        int amountOfLayers;

        if (request.getParameter("1") != null){
            amountOfLayers = 1;
        }
        else if (request.getParameter("2") != null){
            amountOfLayers = 2;
        }
        else {
            amountOfLayers = 3;
        }


        renovationproject.setNumberOfLayers(amountOfLayers);
        model.addAttribute("renovationproject", renovationproject);
        return "paint";
    }

}
