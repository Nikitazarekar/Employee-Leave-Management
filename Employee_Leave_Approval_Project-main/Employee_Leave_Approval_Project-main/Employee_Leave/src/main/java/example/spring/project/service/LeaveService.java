package example.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import example.spring.project.entity.Leave;
import example.spring.project.repository.LeaveRepository;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository repo;

    public void applyLeave(Leave leave) {
        leave.setStatus("PENDING");
        leave.setApprovedLeaves(0);
        repo.save(leave);
    }

    public List<Leave> getAllLeaves() {
        return repo.findAll();
    }

    public List<Leave> getByEmpCode(String empCode) {
        return repo.findByEmpCode(empCode);
    }

    public void approve(Integer id, int days) {
        Leave l = repo.findById(id).orElse(null);
        if (l != null) {
            l.setApprovedLeaves(days);
            if (days == l.getRequestedLeaves())
                l.setStatus("APPROVED");
            else if (days > 0)
                l.setStatus("PARTIALLY_APPROVED");
            else
                l.setStatus("REJECTED");
            repo.save(l);
        }
    }

    public void reject(Integer id) {
        Leave l = repo.findById(id).orElse(null);
        if (l != null) {
            l.setApprovedLeaves(0);
            l.setStatus("REJECTED");
            repo.save(l);
        }
    }
}
