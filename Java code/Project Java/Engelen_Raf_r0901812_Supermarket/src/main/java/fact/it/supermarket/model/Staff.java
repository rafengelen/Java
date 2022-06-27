package fact.it.supermarket.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Staff extends Person{

    //Raf Engelen
    //r0901812
    //1ITF02

    private LocalDate startDate;
    private boolean student;


    public Staff(String firstName, String surName) {
        super(firstName, surName);
        startDate = LocalDate.now();
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }


    public String toString(){
        String endMessage = "Staff member " + super.toString();

        if (this.student == true){
            endMessage += " (working student)";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("dd/MM/yyyy");

        endMessage += " is employed since " + this.startDate.format(dtf);
        return endMessage;
    }
}
