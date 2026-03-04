import React, { useState } from "react";
import API from "../api";

function Login({ setRole, setEmpCode }) {
  const [userType, setUserType] = useState("EMPLOYEE");
  const [empCode, setEmp] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [isRegister, setIsRegister] = useState(false);

  const submit = async () => {
    try {
      if (userType === "MANAGER") {
        const res = await API.post("/auth/admin/login", {
          empCode,
          password
        });
        if (res.data.includes("Successful")) {
          setRole("MANAGER");
        } else alert("Invalid Manager");
      } else {
        if (isRegister) {
          await API.post("/auth/register", { empCode, password, name });
          alert("Registered Successfully");
          setIsRegister(false);
        } else {
          const res = await API.post("/auth/login", { empCode, password });
          if (res.data.includes("Success")) {
            setRole("EMPLOYEE");
            setEmpCode(empCode);
          } else alert("Invalid Login");
        }
      }
    } catch {
      alert("Server Error");
    }
  };

  return (
    <div className="center-card fade">
      <h2>Employee Leave System</h2>

      <select onChange={e => setUserType(e.target.value)}>
        <option value="EMPLOYEE">Employee</option>
        <option value="MANAGER">Manager</option>
      </select>

      {userType === "EMPLOYEE" && isRegister && (
        <input placeholder="Name" onChange={e => setName(e.target.value)} />
      )}

      <input placeholder="Username" onChange={e => setEmp(e.target.value)} />
      <input type="password" placeholder="Password" onChange={e => setPassword(e.target.value)} />

      <button onClick={submit}>
        {isRegister ? "Register" : "Login"}
      </button>

      {userType === "EMPLOYEE" && (
        <p className="link" onClick={() => setIsRegister(!isRegister)}>
          {isRegister ? "Already registered? Login" : "New user? Register"}
        </p>
      )}
    </div>
  );
}

export default Login;
