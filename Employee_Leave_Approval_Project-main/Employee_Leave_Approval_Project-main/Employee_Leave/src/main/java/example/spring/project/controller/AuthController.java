package example.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import example.spring.project.entity.Employee;
import example.spring.project.service.EmployeeService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/admin/login")
    public String admin(@RequestBody Employee e) {
        return ("admin".equals(e.getEmpCode()) && "admin123".equals(e.getPassword()))
                ? "Admin Login Successful"
                : "Invalid Admin";
    }

    @PostMapping("/register")
    public String register(@RequestBody Employee e) {
        service.register(e);
        return "Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee e) {
        return service.login(e.getEmpCode(), e.getPassword())
                ? "Login Success"
                : "Invalid Credentials";
    }
}
