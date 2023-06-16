package fact.it.startproject.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Team team;

    @OneToMany(cascade={CascadeType.ALL})
    private List<Phone> phonenbrs = new ArrayList<>();
    // Always instantiate that collection immediately!
    public void addPhonenbr(String type, String number){
        Phone phone = new Phone();
        phone.setType(type);
        phone.setNumber(number);
        this. phonenbrs.add(phone);
    }


    @OneToOne (cascade={CascadeType.ALL})
    private Passport passport;

    @ManyToMany
    @JoinTable(name="coursestudent")
    private List<Course> courses = new ArrayList<>();

    public Person() {
    }

    public String toString() {
        return name;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Phone> getPhonenbrs() {
        return phonenbrs;
    }

    public void setPhonenbrs(List<Phone> phonenbrs) {
        this.phonenbrs = phonenbrs;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
