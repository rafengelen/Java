package fact.it.startproject.controller;

import fact.it.startproject.model.*;
import fact.it.startproject.repository.ClubRepository;
import fact.it.startproject.repository.EventRepository;
import fact.it.startproject.repository.JoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    JoggerRepository joggerRepository;
    @Autowired
    ClubRepository clubRepository;
    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/overview")
    public String overview(Model model){
        List<Club> clubList = clubRepository.findAll();
        model.addAttribute("clubList", clubList);
        return "overview";
    }
    @RequestMapping("/joggers")
    public String jogger(Model model){
        List<Jogger> joggerList = joggerRepository.findAll();
        model.addAttribute("joggerList",joggerList);
        return "jogger";
    }
    @RequestMapping("/deleteJogger")
    public String deleteJogger(Model model, HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        joggerRepository.delete(joggerRepository.getById(id));

        List<Jogger> joggerList = joggerRepository.findAll();
        model.addAttribute("joggerList",joggerList);
        return "jogger";
    }
    @RequestMapping("/events")
    public String event(Model model){
        model.addAttribute("eventList", eventRepository.findAll());
        return "event";
    }
    @RequestMapping("/editEvent")
    public String editEvent(Model model, HttpServletRequest request){
        Long eventId = Long.valueOf(request.getParameter("id"));

        Event event = this.eventRepository.findById(eventId).get();

        //get clubs
        List<Club> clubList = this.clubRepository.findAll();

        model.addAttribute("clubList", clubList);
        model.addAttribute("event", event);
        return "EditEvent";
    }
    @RequestMapping("/processEditEvent")
    public String processEditEvent(Model model, HttpServletRequest request){
        // nieuwe waarden ophalen
        String name = request.getParameter("name");
        String location = request.getParameter("location");

        //als ingevoerd jaartal een string is, geef error
        if (!request.getParameter("year").matches("\\d+")){
            model.addAttribute("errorMessage", request.getParameter("year").concat(" is not a valid value for year"));
            return "error";
        }

        int year = Integer.parseInt(request.getParameter("year"));
        Club club = this.clubRepository.findById(Long.valueOf(request.getParameter("clubId"))).get();

        //event zoeken
        Event event = this.eventRepository.findById(Long.valueOf(request.getParameter("id"))).get();

        //event aanpassen
        event.setName(name);
        event.setLocation(location);
        event.setYear(year);
        event.setClub(club);
        this.eventRepository.save(event);

        //lijst refreshen
        List<Event> eventList = this.eventRepository.findAll();

        model.addAttribute("eventList", eventList);

        return "event";
    }

}
