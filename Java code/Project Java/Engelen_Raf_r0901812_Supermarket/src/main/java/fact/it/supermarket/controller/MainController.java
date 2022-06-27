package fact.it.supermarket.controller;


import fact.it.supermarket.model.Customer;
import fact.it.supermarket.model.Department;
import fact.it.supermarket.model.Staff;
import fact.it.supermarket.model.Supermarket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

//Raf Engelen
//r0901812
//1ITF02

@Controller
public class MainController {
//  You will need these ArrayLists in part 3 of the project assignment.

    private ArrayList<Staff> staffArrayList = new ArrayList<>();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();
    private ArrayList<Supermarket> supermarketArrayList = new ArrayList<>();

//    Write your code here

    @PostConstruct
    private void fillData(){

        staffArrayList.addAll(fillStaffMembers());
        customerArrayList.addAll(fillCustomers());
        supermarketArrayList.addAll(fillSupermarkets());
    }

    @RequestMapping("/1_newCustomer")
    public String newCustomer(Model model){

        //supermarketArrayList meegeven naar 1_newCustomer.html
        model.addAttribute("supermarketArrayList",supermarketArrayList);

        return "1_newCustomer";
    }

    @RequestMapping("/submitNewCustomer")
    public String submitNewCustomer(HttpServletRequest request, Model model){

        //Data ophalen uit 1_newCustomer.html
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");
        int yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));

        //customer maken en geboortejaar toevoegen
        Customer customer = new Customer(firstName, surName);
        customer.setYearOfBirth(yearOfBirth);

        //ingegeven customer meegeven naar de volgende pagina
        model.addAttribute("customer", customer);

        //index van de gekozen supermakt halen
        int supermarketIndex = Integer.parseInt(request.getParameter("supermarketIndex"));

        //supermarkt uit ArrayList nemen en ingegeven customer toevoegen
        Supermarket supermarket = supermarketArrayList.get(supermarketIndex);
        supermarket.registerCustomer(customer);

        //customer toevoegen aan customerArrayList
        customerArrayList.add(customer);

        return "2_welcomeCustomer";
    }

    @RequestMapping("/3_newStaff")
    public String newStaff(){
        return "3_newStaff";
    }

    @RequestMapping("/submitNewStaff")
    public String submitNewStaff(HttpServletRequest request, Model model){

        //Data halen uit 3_newStaff.html
        String firstName = request.getParameter("firstName");
        String surName = request.getParameter("surName");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate employedSince = LocalDate.parse(request.getParameter("employedSince"), dtf);

        boolean student = (request.getParameter("student") != null);

        //Staff object aanmaken en data toevoegen
        Staff staff = new Staff(firstName, surName);
        staff.setStartDate(employedSince);
        staff.setStudent(student);

        //Nieuw staff object toevoegen aan staffArrayList en meegeven naar 4_welcomeStaff.html
        staffArrayList.add(staff);

        model.addAttribute(staff);

        return "4_welcomeStaff";

    }

    @RequestMapping("/5_staffMembersList")
    public String staffMembersList(Model model){

        //staffArrayList meegeven naar volgende html pagina
        model.addAttribute("staffArrayList", staffArrayList);
        return "5_staffMembersList";
    }

    @RequestMapping("/6_customersList")
    public String customersList(Model model){

        //customerArrayList meegeven naar volgende html pagina
        model.addAttribute("customerArrayList", customerArrayList);
        return "6_customersList";
    }

    @RequestMapping("/7_newSupermarket")
    public String newSupermarket(Model model){
        //Added with exam:
        model.addAttribute("staffArrayList",staffArrayList);
        return "7_newSupermarket";
    }

    @RequestMapping("/submitNewSupermarket")
    public String submitNewSupermarket(HttpServletRequest request, Model model){

        //supermarkt naam nemen uit html en een nieuwe supermarkt aanmaken
        String supermarketName = request.getParameter("supermarketName");
        Supermarket supermarket = new Supermarket(supermarketName);

        //Exam
        int staffIndex = Integer.parseInt(request.getParameter("staffIndex"));

        if (staffIndex == -1) {
            model.addAttribute("errorMessage", "You didn't choose a general manager!");
            return "error";
        }
        supermarket.setGeneralManager(staffArrayList.get(staffIndex));
        model.addAttribute("supermarket", supermarket);

        //nieuwe supermakt toevoegen aan supermarketArrayList en sturen naar volgende html pagina
        supermarketArrayList.add(supermarket);

        return "0_exam";
    }

    @RequestMapping("/8_supermarketList")
    public String supermarketList(Model model){

        //supermarketArrayList meegeven naar de volgende pagina
        model.addAttribute("supermarketArrayList", supermarketArrayList);
        return "8_supermarketList";
    }

    @RequestMapping("/9_newDepartment")
    public String newDepartment(Model model){

        //staffArrayList en supermarketArrayList sturen naar 9_newDepartment.html
        model.addAttribute("supermarketArrayList", supermarketArrayList);
        model.addAttribute("staffArrayList", staffArrayList);
        return "9_newDepartment";
    }

    @RequestMapping("/submitNewDepartment")
    public String submitNewDepartment(Model model, HttpServletRequest request){

        //data uit html pagina opvragen
        String departmentName = request.getParameter("departmentName");
        String photo = request.getParameter("photo");
        boolean refrigerated = (request.getParameter("refrigerated") != null);

        int supermarketIndex = Integer.parseInt(request.getParameter("supermarketIndex"));
        int responsibleIndex = Integer.parseInt(request.getParameter("responsibleIndex"));

        //nakijken of de persoon iets uit de dropdownmenu's heeft gekozen. Indien dit niet het geval is, de correcte errormessage versturen.
        if (supermarketIndex == -1 && responsibleIndex == -1){
            model.addAttribute("errorMessage", "You did not select a supermarket and staff member!");
            return "error";
        }

        if (supermarketIndex == -1){
            model.addAttribute("errorMessage", "You did not select a supermarket!");
            return "error";
        }

        if (responsibleIndex == -1){
            model.addAttribute("errorMessage", "You did not select a staff member!");
            return "error";
        }

        //supermarket en staff uit hun bijhorende lijsten nemen
        Supermarket supermarket = supermarketArrayList.get(supermarketIndex);
        Staff staff = staffArrayList.get(responsibleIndex);


        //nieuwe department samenstellen met data gehaald uit de webpagina
        Department department = new Department(departmentName);
        department.setPhoto(photo);
        department.setResponsible(staff);
        department.setRefrigerated(refrigerated);

        //de nieuw gemaakte department bij de supermarket zetten en de supermarket meegeven naar de volgende webpagina.
        supermarket.addDepartment(department);

        model.addAttribute("supermarket", supermarket);

        return "10_departmentsOfSupermarket";
    }

    @RequestMapping("/10_departmentsOfSupermarket")
    public String departmentsOfSupermarket(Model model, HttpServletRequest request){

        //index uit webpagina namen en de bijhorende supermakt uit supermarketArrayList halen
        int supermarketIndex = Integer.parseInt(request.getParameter("supermarketIndex"));
        Supermarket supermarket = supermarketArrayList.get(supermarketIndex);

        //supermarket meegeven naar 10_departmentOfSupermarket.html
        model.addAttribute("supermarket", supermarket);
        return "10_departmentsOfSupermarket";
    }

    @RequestMapping("/searchDepartment")
    public String searchDepartment(Model model, HttpServletRequest request){

        //departmentName uit het inputvak halen.
        String departmentName = request.getParameter("departmentName");
        Department department;

        //nakijken of de department bij een van de supermakten uit de lijst hoort. Zo ja, wordt deze department naar de volgende pagina gestuurd.
        for (Supermarket supermarket : supermarketArrayList) {
            department = supermarket.searchDepartmentByName(departmentName);

            if (department != null){
                model.addAttribute("department", department);
                return "11_searchDepartment";
            }
        }

        //als de departmentName niet voorkomt bij de supermarkten, dan wordt er een errormessage gegeven.
        model.addAttribute("errorMessage", "There is no department with the name '"+ departmentName + "'");
        return "error";
    }

//  You wll need these methods in part 3 of the project assignment
    private ArrayList<Staff> fillStaffMembers() {
        ArrayList<Staff> staffMembers = new ArrayList<>();

        Staff staff1 = new Staff("Johan", "Bertels");
        staff1.setStartDate(LocalDate.of(2002, 5, 1));
        Staff staff2 = new Staff("An", "Van Herck");
        staff2.setStartDate(LocalDate.of(2019, 3, 15));
        staff2.setStudent(true);
        Staff staff3 = new Staff("Bruno", "Coenen");
        staff3.setStartDate(LocalDate.of(1995,1,1));
        Staff staff4 = new Staff("Wout", "Dayaert");
        staff4.setStartDate(LocalDate.of(2002, 12, 15));
        Staff staff5 = new Staff("Louis", "Petit");
        staff5.setStartDate(LocalDate.of(2020, 8, 1));
        staff5.setStudent(true);
        Staff staff6 = new Staff("Jean", "Pinot");
        staff6.setStartDate(LocalDate.of(1999,4,1));
        Staff staff7 = new Staff("Ahmad", "Bezeri");
        staff7.setStartDate(LocalDate.of(2009, 5, 1));
        Staff staff8 = new Staff("Hans", "Volzky");
        staff8.setStartDate(LocalDate.of(2015, 6, 10));
        staff8.setStudent(true);
        Staff staff9 = new Staff("Joachim", "Henau");
        staff9.setStartDate(LocalDate.of(2007,9,18));
        staffMembers.add(staff1);
        staffMembers.add(staff2);
        staffMembers.add(staff3);
        staffMembers.add(staff4);
        staffMembers.add(staff5);
        staffMembers.add(staff6);
        staffMembers.add(staff7);
        staffMembers.add(staff8);
        staffMembers.add(staff9);
        return staffMembers;
    }

    private ArrayList<Customer> fillCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("Dominik", "Mioens");
        customer1.setYearOfBirth(2001);
        Customer customer2 = new Customer("Zion", "Noops");
        customer2.setYearOfBirth(1996);
        Customer customer3 = new Customer("Maria", "Bonetta");
        customer3.setYearOfBirth(1998);
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.get(0).addToShoppingList("Butter");
        customers.get(0).addToShoppingList("Bread");
        customers.get(1).addToShoppingList("Apple");
        customers.get(1).addToShoppingList("Banana");
        customers.get(1).addToShoppingList("Grapes");
        customers.get(1).addToShoppingList("Oranges");
        customers.get(2).addToShoppingList("Fish");

        // ikzelf als customer:
        Customer customer4 = new Customer("Raf", "Engelen");
        customer4.setYearOfBirth(1998);
        customers.add(customer4);
        customers.get(3).addToShoppingList("Java coffee");
        customers.get(3).addToShoppingList("Lemons");
        customers.get(3).addToShoppingList("Lasagna");

        return customers;
    }

    private ArrayList<Supermarket> fillSupermarkets() {
        ArrayList<Supermarket> supermarkets = new ArrayList<>();
        Supermarket supermarket1 = new Supermarket("Delhaize");
        Supermarket supermarket2 = new Supermarket("Colruyt");
        Supermarket supermarket3 = new Supermarket("Albert Heyn");
        Department department1 = new Department("Fruit");
        Department department2 = new Department("Bread");
        Department department3 = new Department("Vegetables");
        department1.setPhoto("/img/fruit.jpg");
        department2.setPhoto("/img/bread.jpg");
        department3.setPhoto("/img/vegetables.jpg");
        department1.setResponsible(staffArrayList.get(0));
        department2.setResponsible(staffArrayList.get(1));
        department3.setResponsible(staffArrayList.get(2));
        supermarket1.addDepartment(department1);
        supermarket1.addDepartment(department2);
        supermarket1.addDepartment(department3);
        supermarket2.addDepartment(department1);
        supermarket2.addDepartment(department2);
        supermarket3.addDepartment(department1);
        supermarket3.addDepartment(department3);

        //exam

        supermarket1.setGeneralManager(staffArrayList.get(0));
        supermarket2.setGeneralManager(staffArrayList.get(1));
        supermarket3.setGeneralManager(staffArrayList.get(2));

        supermarkets.add(supermarket1);
        supermarkets.add(supermarket2);
        supermarkets.add(supermarket3);
        return supermarkets;
    }


}
