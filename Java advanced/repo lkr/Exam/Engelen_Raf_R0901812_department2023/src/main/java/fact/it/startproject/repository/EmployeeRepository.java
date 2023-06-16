package fact.it.startproject.repository;

import fact.it.startproject.model.Department;
import fact.it.startproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
