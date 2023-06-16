package fact.it.startproject.controller;

import fact.it.startproject.model.Club;
import fact.it.startproject.model.Event;
import fact.it.startproject.model.Jogger;
import fact.it.startproject.repository.ClubRepository;
import fact.it.startproject.repository.EventRepository;
import fact.it.startproject.repository.JoggerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {
    private JoggerRepository joggerRepository;
    private ClubRepository clubRepository;

    private EventRepository eventRepository;

    public MainController(JoggerRepository joggerRepository, ClubRepository clubRepository, EventRepository eventRepository) {
        this.joggerRepository = joggerRepository;
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/overview")
    public String overview(Model model){
        //get clubs
        List<Club> clubList = this.clubRepository.findAll();

        //get joggers in club

        model.addAttribute("clubList", clubList);

        return "overview";
    }

    @RequestMapping("/jogger")
    public String jogger(Model model){
        //get joggers
        List<Jogger> joggerList = this.joggerRepository.findAll();

        model.addAttribute("joggerList", joggerList);

        return "jogger";
    }

    @RequestMapping("deleteJogger")
    public String deleteJogger(Model model, HttpServletRequest request){
        Long joggerId = Long.valueOf(request.getParameter("joggerId"));

        //jogger verwijderen
        this.joggerRepository.deleteById(joggerId);

        //lijst terug laten zien
        List<Jogger> joggerList = this.joggerRepository.findAll();

        //lijst meesturen
        model.addAttribute("joggerList", joggerList);

        return "jogger";
    }

    @RequestMapping("event")
    public String event(Model model){
        List<Event> eventList = this.eventRepository.findAll();

        model.addAttribute("eventList", eventList);

        return "event";
    }

    @RequestMapping("editEvent")
    public String editEvent(Model model, HttpServletRequest request){
        Long eventId = Long.valueOf(request.getParameter("eventId"));

        Event event = this.eventRepository.findById(eventId).get();

        //get clubs
        List<Club> clubList = this.clubRepository.findAll();

        model.addAttribute("clubList", clubList);
        model.addAttribute("event", event);

        return "editEvent";
    }

    @RequestMapping("processEditEvent")
    public String processEditEvent(Model model, HttpServletRequest request){
        // nieuwe waarden ophalen
        String name = request.getParameter("name");
        String location = request.getParameter("location");

        //als ingevoerd jaartal een string is, geef error
        if (!request.getParameter("year").matches("\\d+")){
            model.addAttribute("errorMessage", "entered value is not a whole number");
            return "error";
        }

        int year = Integer.parseInt(request.getParameter("year"));
        Club club = this.clubRepository.findById(Long.valueOf(request.getParameter("clubId"))).get();

        //event zoeken
        Event event = this.eventRepository.findById(Long.valueOf(request.getParameter("eventId"))).get();

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
