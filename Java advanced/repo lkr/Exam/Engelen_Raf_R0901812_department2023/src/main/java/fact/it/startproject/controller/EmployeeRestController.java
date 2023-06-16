package fact.it.startproject.controller;

import fact.it.startproject.model.Department;
import fact.it.startproject.model.Employee;
import fact.it.startproject.repository.DepartmentRepository;
import fact.it.startproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("employees/request")
    public List<String> tenantsIncome(@RequestBody String search){

        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .filter(e -> e.getName().contains(search))
                .map(Employee::toString)
                .toList();
    }
    @PostMapping("employee")
    public String addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return employee.toString();
    }
    @DeleteMapping("employee/{id}")
    public ResponseEntity<Integer> removeEmployee(@PathVariable long id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()){
            return new ResponseEntity<>(employeeRepository.findAll().size(),HttpStatus.NOT_FOUND);
        }

        try{
            employeeRepository.delete(employeeOptional.get());
            return new ResponseEntity<>(employeeRepository.findAll().size(),HttpStatus.OK);

        } catch (Exception exception){
            return new ResponseEntity<>(employeeRepository.findAll().size(),HttpStatus.CONFLICT);
        }
    }


}
