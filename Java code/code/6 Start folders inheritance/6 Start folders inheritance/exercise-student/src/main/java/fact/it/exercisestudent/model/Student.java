package fact.it.exercisestudent.model;

public class Student {
    private String name;
    private String studentnumber;
    private String address;
    private String major;

    public Student(String name, String studentnumber) {
        this.name = name;
        this.studentnumber = studentnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentnumber() {
        return studentnumber;
    }

    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString(){
        return this.studentnumber +' ' + this.name +" ("+ this.major + ") - Address: " + this.address;
    }
}
