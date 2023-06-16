package fact.it.startproject.controller;

import fact.it.startproject.model.*;
import fact.it.startproject.repository.PersonRepository;
import fact.it.startproject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    TeamRepository teamRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Team> list = teamRepository.findAll();
        model.addAttribute("teamList", list);
        return "index";
    }

    @RequestMapping("/addTeam")
    public String addTeam() {
        return "addteam";
    }

    @RequestMapping("/processAddTeam")
    public String processAddTeam(Model model, HttpServletRequest request) {
        String assignment = request.getParameter("assignment");
        String number = request.getParameter("number");
        Team team = new Team();
        team.setAssignment(assignment);
        team.setNumber(number);
        teamRepository.save(team);
        List<Team> list = teamRepository.findAll();
        model.addAttribute("teamList", list);
        return "index";
    }
    @RequestMapping("/addPerson")
    public String addPerson(Model model) {
        List<Team> list = teamRepository.findAll();
        model.addAttribute("teamList", list);
        return "addPerson";
    }

    @RequestMapping("/processAddPerson")
    public String processAddPerson(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        long teamId = Long.parseLong(request.getParameter("teamIndex"));

        Optional<Team> team = teamRepository.findById(teamId);

        Person person = new Person();
        person.setName(name);

        if (team.isPresent()){
            person.setTeam(team.get());
        }
        //paspoort aanmaken en verbinden met person
        Passport passport = new Passport();
        passport.setPassportnbr(request.getParameter("passport"));
        person.setPassport(passport);

        personRepository.save(person);

        List<Team> list = teamRepository.findAll();
        model.addAttribute("teamList", list);
        return "index";
    }
    @RequestMapping("/addPhone")
    public String addTelephone(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("personList", list);
        return "addPhone";
    }

    @RequestMapping("/processAddPhone")
    public String processAddTelephone(Model model, HttpServletRequest request) {
        String type = request.getParameter("type");
        String number = request.getParameter("number");
        long personId = Long.parseLong(request.getParameter("personIndex"));

        Person person= personRepository.findById(personId).get();
        person.addPhonenbr(type, number);
        personRepository.save(person);
        List<Team> list = teamRepository.findAll();
        model.addAttribute("teamList", list);
        return "index";
    }



}
