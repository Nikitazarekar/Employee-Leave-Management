package example.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import example.spring.project.entity.Leave;
import example.spring.project.service.LeaveService;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveController {

    @Autowired
    private LeaveService service;

    @PostMapping
    public String apply(@RequestBody Leave l) {
        service.applyLeave(l);
        return "Leave Applied";
    }

    @GetMapping
    public List<Leave> all() {
        return service.getAllLeaves();
    }

    @GetMapping("/employee/{empCode}")
    public List<Leave> emp(@PathVariable String empCode) {
        return service.getByEmpCode(empCode);
    }

    @PutMapping("/approve/{id}/{days}")
    public String approve(@PathVariable Integer id, @PathVariable int days) {
        service.approve(id, days);
        return "Processed";
    }

    @PutMapping("/reject/{id}")
    public String reject(@PathVariable Integer id) {
        service.reject(id);
        return "Rejected";
    }
}
