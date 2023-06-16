package fact.it.ex1.controller;

import fact.it.ex1.model.Renovationproject;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/paint")
    public String paint(HttpServletRequest request, Model model){
        double l = Double.parseDouble(request.getParameter("length"));
        double w = Double.parseDouble(request.getParameter("width"));
        double h = Double.parseDouble(request.getParameter("height"));
        boolean ceilingIncluded = (request.getParameter("ceiling")!= null);
        int layers = Integer.parseInt(request.getParameter("layers"));
        String name = request.getParameter("name");

        Renovationproject renovationproject = new Renovationproject(l,w,h);

        renovationproject.setCeilingIncluded(ceilingIncluded);
        renovationproject.setNumberOfLayers(layers);

        System.out.println(renovationproject.isCeilingIncluded());

        model.addAttribute("renovationproject", renovationproject);
        model.addAttribute("name", name);
        return "paint";
    }
}
