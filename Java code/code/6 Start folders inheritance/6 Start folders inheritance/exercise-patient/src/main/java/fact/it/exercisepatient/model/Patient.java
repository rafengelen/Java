package fact.it.exercisepatient.model;

public class Patient extends Person {

    private String nationalNumber;

    public Patient(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public Patient(String name, String nationalNumber){
        //super(name);
        setName(name);
        this.nationalNumber = nationalNumber;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String toString(){
        return "Name: " + getName() + " (national number: " + nationalNumber+")";
    }
}
