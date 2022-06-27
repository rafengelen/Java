package fact.it.supermarket.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Supermarket {

    //Raf Engelen
    //r0901812
    //1ITF02

    private String name;
    private int numberCustomers;
    private ArrayList<Department> departmentList = new ArrayList<>();
    //Exam attribute
    private Staff generalManager;

    public Supermarket(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberCustomers() {
        return numberCustomers;
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }


    public int getNumberOfDepartments(){
        return departmentList.size();
    }

    public void addDepartment(Department department){
        departmentList.add(department);
    }

    public Department searchDepartmentByName(String name){
        for (int position = 0; position < departmentList.size(); position++){
            if (departmentList.get(position).getName().equals(name)){
                return departmentList.get(position);
            }
        }
        return null;
    }

    public void registerCustomer(Customer customer){
        this.numberCustomers += 1;
        customer.setCardNumber(this.numberCustomers);
    }

    //Added with exam:

    public Staff getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(Staff generalManager) {
        this.generalManager = generalManager;
    }
}
