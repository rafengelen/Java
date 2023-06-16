package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.net.http.HttpClient;

@Controller
public class TrainingController {
    @Autowired
    TrainingRepository trainingRepository;
    public TrainingController (){

    }
    @GetMapping("/listOfTrainings")
    public String listOfTrainings(Model model){
        model.addAttribute("trainings",trainingRepository.findAll());
        return "listOfTrainings";
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/processAdd")
    public String processAdd(Model model, HttpServletRequest request){
        Training training = new Training();
        training.setTheme(request.getParameter("theme"));
        training.setMax(Integer.parseInt(request.getParameter("max")));
        training.setTitle(request.getParameter("title"));
        training.setDuration(Integer.parseInt(request.getParameter("duration")));
        training.setCode(request.getParameter("code"));

        trainingRepository.save(training);

        model.addAttribute("trainings", trainingRepository.findAll());
        return "listOfTrainings";
    }
    @RequestMapping("/delete")
    public String delete(Model model,HttpServletRequest request){
        Training training = trainingRepository.getById(Long.parseLong(request.getParameter("id")));
        trainingRepository.delete(training);

        model.addAttribute("trainings", trainingRepository.findAll());
        return "listOfTrainings";
    }
    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request){
        Training training = trainingRepository.getById(Long.parseLong(request.getParameter("id")));
        model.addAttribute("training", training);
        return "edit";
    }
    @RequestMapping("/processEdit")
    public String processEdit(Model model, HttpServletRequest request){
        Training training = trainingRepository.findById(Long.valueOf(request.getParameter("id"))).get();

        training.setTheme(request.getParameter("theme"));
        training.setMax(Integer.parseInt(request.getParameter("max")));
        training.setTitle(request.getParameter("title"));
        training.setDuration(Integer.parseInt(request.getParameter("duration")));
        training.setCode(request.getParameter("code"));

        trainingRepository.save(training);
        model.addAttribute("trainings", trainingRepository.findAll());
        return "listOfTrainings";
    }
    @RequestMapping("/byTheme")
    public String byTheme(Model model){
        List<Training> trainings = trainingRepository.findAllByOrderByTheme();
        model.addAttribute("trainings", trainings);
        return "listOfTrainings";
    }
    @RequestMapping("/details")
    public String details(Model model, HttpServletRequest request){
        model.addAttribute("training", trainingRepository.findById(Long.valueOf(request.getParameter("id"))).get());
        return "details";
    }
    @RequestMapping("/search")
    public String search(Model model, HttpServletRequest request){
        model.addAttribute("themes", trainingRepository.findAllTheme());
        return "search";
    }
    @RequestMapping("/searchTitle")
    public String searchTitle(Model model, HttpServletRequest request){
        String title = request.getParameter("title");
        model.addAttribute("trainings", trainingRepository.findByTitleContains(title));
        return "listOfTrainings";
    }
    @RequestMapping("/searchTheme")
    public String searchTheme(Model model, HttpServletRequest request){
        String theme = request.getParameter("theme");
        model.addAttribute("trainings", trainingRepository.findByTheme(theme));
        return "listOfTrainings";
    }

}
