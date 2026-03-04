import React, { useEffect, useState } from "react";
import API from "../api";

function EmployeeDashboard({ empCode, logout }) {
  const [leaves, setLeaves] = useState([]);
  const [form, setForm] = useState({
    leaveType: "SICK",
    fromDate: "",
    toDate: "",
    requestedLeaves: "",
    reason: ""
  });

  useEffect(() => {
    API.get(`/leaves/employee/${empCode}`).then(res => setLeaves(res.data));
  }, [empCode]);

  const apply = async () => {
    await API.post("/leaves", { ...form, empCode });
    alert("Leave Applied");
    window.location.reload();
  };

  return (
    <div className="container fade">
      <h2>Employee Dashboard</h2>
      <button className="logout" onClick={logout}>Logout</button>

      <div className="card">
        <h3>Apply Leave</h3>

        <select onChange={e => setForm({ ...form, leaveType: e.target.value })}>
          <option>SICK</option>
          <option>CASUAL</option>
          <option>EARNED</option>
        </select>

        <input type="date" onChange={e => setForm({ ...form, fromDate: e.target.value })} />
        <input type="date" onChange={e => setForm({ ...form, toDate: e.target.value })} />
        <input placeholder="Number of Days" onChange={e => setForm({ ...form, requestedLeaves: e.target.value })} />
        <input placeholder="Reason" onChange={e => setForm({ ...form, reason: e.target.value })} />

        <button onClick={apply}>Apply</button>
      </div>

      <table>
        <thead>
          <tr>
            <th>Type</th><th>From</th><th>To</th>
            <th>Requested</th><th>Approved</th><th>Status</th>
          </tr>
        </thead>
        <tbody>
          {leaves.map(l => (
            <tr key={l.leaveId}>
              <td>{l.leaveType}</td>
              <td>{l.fromDate}</td>
              <td>{l.toDate}</td>
              <td>{l.requestedLeaves}</td>
              <td>{l.approvedLeaves}</td>
              <td>{l.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmployeeDashboard;
