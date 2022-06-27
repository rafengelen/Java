package fact.it.exercisestudent.model;

public class DormStudent extends Student{
    private String dormLandlord;
    private String dormAddress;

    public DormStudent(String name, String studentnumber, String dormAddress) {
        super(name, studentnumber);
        this.dormAddress = dormAddress;
    }

    public String getDormLandlord() {
        return dormLandlord;
    }

    public void setDormLandlord(String dormLandlord) {
        this.dormLandlord = dormLandlord;
    }

    public String getDormAddress() {
        return dormAddress;
    }

    public void setDormAddress(String dormAddress) {
        this.dormAddress = dormAddress;
    }

    @Override
    public String toString(){
        return super.getStudentnumber() +' ' + super.getName() +" ("+ super.getMajor() + ") - Dorm address: " + this.dormAddress + " (landlord: " + this.dormLandlord +")";
    }
}
