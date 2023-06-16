package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, location;
    private double memberfee;
    @OneToMany(mappedBy = "club")
    private List<Jogger> memberList = new ArrayList<>();
    @OneToMany(mappedBy = "club")
    private List<Event> eventList = new ArrayList<>();

    public Club() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMemberfee() {
        return memberfee;
    }

    public void setMemberfee(double memberfee) {
        this.memberfee = memberfee;
    }

    public List<Jogger> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Jogger> memberList) {
        this.memberList = memberList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
