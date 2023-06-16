package fact.it.startproject.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Employee extends Person {
    private double salary;
    public Employee () {
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this. salary = salary;
    }
}
