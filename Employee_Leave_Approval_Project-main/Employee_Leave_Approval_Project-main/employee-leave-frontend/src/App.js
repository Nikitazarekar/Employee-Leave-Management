import React, { useState } from "react";
import Login from "./pages/Login";
import EmployeeDashboard from "./pages/EmployeeDashboard";
import ManagerDashboard from "./pages/ManagerDashboard";

function App() {
  const [role, setRole] = useState(null);
  const [empCode, setEmpCode] = useState(null);

  if (!role) {
    return <Login setRole={setRole} setEmpCode={setEmpCode} />;
  }

  if (role === "EMPLOYEE") {
    return <EmployeeDashboard empCode={empCode} logout={() => setRole(null)} />;
  }

  return <ManagerDashboard logout={() => setRole(null)} />;
}

export default App;
