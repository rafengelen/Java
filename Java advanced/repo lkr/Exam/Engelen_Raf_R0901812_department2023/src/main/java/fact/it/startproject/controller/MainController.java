package fact.it.startproject.controller;

import fact.it.startproject.model.Department;
import fact.it.startproject.repository.CompanyRepository;
import fact.it.startproject.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/listCompanies")
    public String listCompanies(Model model){
        model.addAttribute("companyList", companyRepository.findAllByOrderByLocation());
        return "1_listCompanies";
    }
    @RequestMapping("/listDepartments")
    public String listDepartments(Model model){
        model.addAttribute("departmentList", departmentRepository.findAll());
        return "2_listDepartments";
    }
    @RequestMapping("/editDepartment")
    public String editDepartment(Model model, HttpServletRequest request){
        Long id = Long.valueOf(request.getParameter("id"));
        model.addAttribute("department", departmentRepository.findById(id).get());
        model.addAttribute("companyList", companyRepository.findAll());
        return "3_editDepartment";
    }
    @RequestMapping("/processEditDepartment")
    public String processEditDepartment(Model model, HttpServletRequest request){
        Long departmentId = Long.valueOf(request.getParameter("departmentId"));
        Long companyId = Long.valueOf(request.getParameter("companyId"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");

        Department department = departmentRepository.getById(departmentId);
        department.setCode(code);
        department.setName(name);
        department.setCompany(companyRepository.getById(companyId));

        departmentRepository.save(department);

        model.addAttribute("departmentList", departmentRepository.findAll());
        return "2_listDepartments";
    }
}
