import React, { useEffect, useState } from "react";
import API from "../api";

function ManagerDashboard({ logout }) {
  const [leaves, setLeaves] = useState([]);
  const [days, setDays] = useState({});

  useEffect(() => {
    API.get("/leaves").then(res => setLeaves(res.data));
  }, []);

  const approve = (id) => {
    API.put(`/leaves/approve/${id}/${days[id] || 0}`).then(() => window.location.reload());
  };

  const reject = (id) => {
    API.put(`/leaves/reject/${id}`).then(() => window.location.reload());
  };

  return (
    <div className="container fade">
      <h2>Manager Dashboard</h2>
      <button className="logout" onClick={logout}>Logout</button>

      <table>
        <thead>
          <tr>
            <th>Emp</th><th>Type</th><th>Requested</th>
            <th>Approve Days</th><th>Status</th><th>Action</th>
          </tr>
        </thead>
        <tbody>
          {leaves.map(l => (
            <tr key={l.leaveId}>
              <td>{l.empCode}</td>
              <td>{l.leaveType}</td>
              <td>{l.requestedLeaves}</td>
              <td>
                <input
                  style={{ width: "60px" }}
                  onChange={e => setDays({ ...days, [l.leaveId]: e.target.value })}
                />
              </td>
              <td>{l.status}</td>
              <td>
                <button onClick={() => approve(l.leaveId)}>Approve</button>
                <button className="danger" onClick={() => reject(l.leaveId)}>Reject</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ManagerDashboard;
