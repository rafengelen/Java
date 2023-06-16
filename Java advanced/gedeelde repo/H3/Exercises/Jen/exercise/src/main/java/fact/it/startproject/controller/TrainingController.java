package fact.it.startproject.controller;

import fact.it.startproject.model.Training;
import fact.it.startproject.repository.TrainingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainingController {
    public TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        List<Training> trainingList = this.trainingRepository.findAll();

        model.addAttribute("trainingList", trainingList);

        return "admin";
    }

    @RequestMapping("/newTraining")
    public String newTraining(){
        return "newTraining";
    }

    @RequestMapping("/processNewTraining")
    public String processNewTraining(Model model, HttpServletRequest request){
        //waarden ophalen uit form
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));

        //nieuw training object aanmaken om in te vullen met waarden van hierboven
        Training training = new Training();

        //trainingobject variabelen invullen
        training.setCode(code);
        training.setTitle(title);
        training.setTheme(theme);
        training.setDuration(duration);
        training.setMax(max);

        //training object oplslaan in db als een record
        this.trainingRepository.save(training);

        //geupdate lijst met trainingen terugsturen om te laten zien op admin pagina
        List<Training> trainingList = this.trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);

        return "admin";
    }

    @RequestMapping("/deleteTraining")
    public String deleteTraining(Model model, HttpServletRequest request){
        //variabele ophalen vanop admin pagina
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));

        //record verwijderen
        this.trainingRepository.deleteById(trainingId);

        //pagina terug updaten
        List<Training> trainingList = this.trainingRepository.findAll();
        model.addAttribute("trainingList", trainingList);

        return "admin";
    }

    @RequestMapping("/editTraining")
    public String editTraining(Model model, HttpServletRequest request){
        //variabele ophalen vanop admin pagina
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));

        Training training = this.trainingRepository.findById(trainingId).get();

        model.addAttribute("training", training);

        return "editTraining";
    }

    @RequestMapping("/processEditTraining")
    public String processEditTraining(Model model, HttpServletRequest request){
        //id van aan te passen training ophalen
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));

        //waarden ophalen van form
        String code = request.getParameter("code");
        String title = request.getParameter("title");
        String theme = request.getParameter("theme");
        int duration = Integer.parseInt(request.getParameter("duration"));
        int max = Integer.parseInt(request.getParameter("max"));

        //object aanmaken om waarden in te steken
        Training training = this.trainingRepository.findById(trainingId).get();

        //waarden insteken
        training.setCode(code);
        training.setTitle(title);
        training.setTheme(theme);
        training.setDuration(duration);
        training.setMax(max);

        //record toevoegen aan db
        this.trainingRepository.save(training);

        //geupdate lijst ophalen om te tonen
        List<Training> trainingList = this.trainingRepository.findAll();

        //nieuwe lijst meesturen om pagina te updaten
        model.addAttribute("trainingList", trainingList);

        return "admin";
    }

    @RequestMapping("/sort")
    public String sort(Model model, HttpServletRequest request){
        //
        if (request.getParameter("searchTheme") != null){
            List<Training> trainingList = this.trainingRepository.findAllByOrderByTheme();
            model.addAttribute("trainingList", trainingList);
        }

        return "admin";
    }

    @RequestMapping("/details")
    public String details(Model model, HttpServletRequest request){

        //id van training ophalen
        Long trainingId = Long.valueOf(request.getParameter("trainingId"));

        //object ophalen
        Training training = this.trainingRepository.findById(trainingId).get();

        model.addAttribute("training", training);

        return "details";
    }

    @RequestMapping("/search")
    public String search(Model model){
        List<String> themeList = this.trainingRepository.giveAllUniqueThemes();

        model.addAttribute("themeList", themeList);

        return "search";
    }

    @RequestMapping("/filterTheme")
    public String filterTheme(Model model, HttpServletRequest request){
        //get theme to search on
        String theme = request.getParameter("theme");

        //filter all trainings on theme
        List<Training> trainingList = this.trainingRepository.findAllByThemeEquals(theme);

        //pass list to view
        model.addAttribute("trainingList", trainingList);

        return "admin";
    }

    @RequestMapping("/filterName")
    public String filterName(Model model, HttpServletRequest request){
        //get theme to search on
        String name = request.getParameter("title");

        //filter all trainings on theme
        List<Training> trainingList = this.trainingRepository.findAllByTitleContains(name);

        //pass list to view
        model.addAttribute("trainingList", trainingList);

        return "admin";
    }
}
