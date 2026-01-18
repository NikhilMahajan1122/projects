import React, { useEffect, useState } from "react";
import Employee from "./Employee";
import axios from "axios";
import Base_Url from "../api/BootApi";
import { toast } from "react-toastify";

const AllEmployees = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    document.title = "All Employees";
    getEmployeesFromServer();
  }, []);

  const deletedEmployees = (id) => {
    setEmployees(employees.filter((item) => item.id != id));
  };

  const getEmployeesFromServer = () => {
    axios.get(`${Base_Url}/api/employees`).then(
      (response) => {
        console.log(response);
        toast.success("Employees Fetched Successfully!", {
          position: "bottom-center",
        });
        setEmployees(response.data);
      },
      (error) => {
        toast.error("Something went wrong", {
          position: "bottom-center",
        });
        console.log(error);
      },
    );
  };

  return (
    <div className="text-center">
      <h2>List of Employees</h2>
      {employees.length > 0
        ? employees.map((item) => (
            <Employee
              key={item.email}
              employee={item}
              deleted={deletedEmployees}
            />
          ))
        : "No Employees"}
    </div>
  );
};

export default AllEmployees;
