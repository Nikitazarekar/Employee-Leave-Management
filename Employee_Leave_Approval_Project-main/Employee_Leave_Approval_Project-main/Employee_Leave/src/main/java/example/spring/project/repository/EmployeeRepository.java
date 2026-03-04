package example.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.spring.project.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmpCode(String empCode);
}
