package example.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import example.spring.project.entity.Employee;
import example.spring.project.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void register(Employee emp) {
        emp.setPassword(encoder.encode(emp.getPassword()));
        emp.setRole("EMPLOYEE");
        empRepo.save(emp);
    }

    public boolean login(String empCode, String password) {
        Employee emp = empRepo.findByEmpCode(empCode);
        return emp != null && encoder.matches(password, emp.getPassword());
    }
}
