package fact.it.startproject.repository;

import fact.it.startproject.model.Department;
import fact.it.startproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //List<Department> findAllByEmployee(Employee employee);
    //@Query("SELECT d.employees FROM Department")
    //List<Employee> find
}
