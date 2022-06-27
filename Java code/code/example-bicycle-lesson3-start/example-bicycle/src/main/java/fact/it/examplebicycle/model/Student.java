package fact.it.examplebicycle.model;

public class Student {
    private String rnumber, firstName, surname;
    private boolean foreigner;

    public Student() {
    }

    public Student(String rnumber, String firstName, String surname) {
        this.rnumber = rnumber;
        this.firstName = firstName;
        this.surname = surname;
    }

    //public Student(String rnumber, String firstName, String surname){
    //    this.rnumber = rnumber;
    //    this.firstName = firstName;
    //    this.surname = surname;
    //}

    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isForeigner() {
        return foreigner;
    }

    public void setForeigner(boolean foreigner) {
        this.foreigner = foreigner;
    }

    public String getEmailAddress(){
        return rnumber + "@student.thomasmore.be";
    }

    public String getInitials(){
        return firstName.charAt(0) + surname.substring(0,2);
    }

    public String getFullName(){
        return firstName + " " + surname.toUpperCase()+ " (" + getInitials() + ")";
    }
}
