package example.spring.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import example.spring.project.entity.Leave;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    List<Leave> findByEmpCode(String empCode);
}
