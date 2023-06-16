package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.repository.TrainingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainingController {
    private TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository){this.trainingRepository = trainingRepository;}

    @RequestMapping("/")
    public String index(){return "index";}

    @GetMapping("/trainings")
    public String trainings(Model model){
        model.addAttribute("trainingsList", trainingRepository.findAllBy());
        return "trainings";
    }
    @RequestMapping("/add")
    public String add(){return "add";}
    @PostMapping("/processAdd")
    public String processAdd(Model model, HttpServletRequest request){
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        String code = request.getParameter("code");

        Integer max = Integer.parseInt(request.getParameter("max"));
        Integer duration = Integer.parseInt(request.getParameter("duration"));

        Training training = new Training();

        training.setCode(code);
        training.setDuration(duration);
        training.setTitle(title);
        training.setMax(max);
        training.setTheme(theme);

        trainingRepository.save(training);

        model.addAttribute("trainingsList", trainingRepository.findAllBy());

        return "trainings";
    }

    @RequestMapping("/edit")
    public String edit(Model model, HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        model.addAttribute("training", trainingRepository.findById(id).get());
        return "edit";
    }
    @RequestMapping("/processEdit")
    public String processEdit(Model model, HttpServletRequest request){

        Training training = trainingRepository.findById(Long.valueOf(request.getParameter("id"))).get();


        training.setCode(request.getParameter("code"));
        training.setDuration(Integer.parseInt(request.getParameter("duration")));
        training.setTitle(request.getParameter("title"));
        training.setMax(Integer.parseInt(request.getParameter("max")));
        training.setTheme(request.getParameter("theme"));

        trainingRepository.save(training);

        model.addAttribute("trainingsList", trainingRepository.findAllBy());
        return "trainings";
    }

    @RequestMapping("/delete")
    public String delete(Model model, HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));

        trainingRepository.deleteById(id);
        model.addAttribute("trainingsList", trainingRepository.findAllBy());
        return "trainings";
    }

    @GetMapping("/byTheme")
    public String byTheme(Model model){
        model.addAttribute("trainingsList",trainingRepository.findAllByOrderByTheme());
        return "trainings";
    }

    @RequestMapping("/details")
    public String code(Model model, HttpServletRequest request){
        Optional<Training> optionalTraining= trainingRepository.findById(Long.valueOf(request.getParameter("id")));
        if(optionalTraining.isEmpty()){
            return "index";
        }
        model.addAttribute("training", optionalTraining.get());
        return "details";
    }

    @RequestMapping("/search")
    public String search(Model model){
        model.addAttribute("trainings", trainingRepository.findUniqueTrainingsByTheme());
        return "search";
    }
    @RequestMapping("/searchTitle")
    public String searchTitle(HttpServletRequest request, Model model){
        String title = request.getParameter("title");
        List<Training> trainingsList = trainingRepository.findByTitleContaining(title);
        model.addAttribute("trainingsList",trainingsList);
        return "trainings";
    }
    @RequestMapping("/searchTheme")
    public String searchTheme(HttpServletRequest request, Model model){
        String theme = request.getParameter("theme");
        model.addAttribute("trainingsList", trainingRepository.findByTheme(theme));
        return "trainings";
    }
}
