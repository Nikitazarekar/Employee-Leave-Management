package example.spring.project.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    private String empCode;
    private String leaveType;

    private LocalDate fromDate;
    private LocalDate toDate;

    private int requestedLeaves;
    private int approvedLeaves;

    private String status; // PENDING / APPROVED / PARTIALLY_APPROVED / REJECTED
    private String reason;

    public Leave() {}

    public Integer getLeaveId() { return leaveId; }
    public void setLeaveId(Integer leaveId) { this.leaveId = leaveId; }

    public String getEmpCode() { return empCode; }
    public void setEmpCode(String empCode) { this.empCode = empCode; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }

    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }

    public int getRequestedLeaves() { return requestedLeaves; }
    public void setRequestedLeaves(int requestedLeaves) { this.requestedLeaves = requestedLeaves; }

    public int getApprovedLeaves() { return approvedLeaves; }
    public void setApprovedLeaves(int approvedLeaves) { this.approvedLeaves = approvedLeaves; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
