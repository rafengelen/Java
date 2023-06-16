package fact.it.startproject.model;

import javax.persistence.*;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Person{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public Person() {
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
}
