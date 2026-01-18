import axios from "axios";
import { Fragment, useEffect, useState } from "react";
import Base_Url from "../api/BootApi";
import { toast, ToastContainer } from "react-toastify";
import { Container, Button, Form, FormGroup } from "reactstrap";
import { useLocation } from "react-router-dom";

const AddEmployee = () => {
  const location = useLocation();
  const employeeData = location.state;
  const [employee, setEmployee] = useState({});

  useEffect(() => {
    document.title = "Add Employee";
    if (employeeData) {
      setEmployee({
        id: employeeData.id,
        name: employeeData.name,
        email: employeeData.email,
        salary: employeeData.salary,
        deptName: employeeData.deptName,
      });
    } else {
      setEmployee({
        name: "",
        email: "",
        salary: "",
        deptName: "",
      });
    }
  }, []);

  const handleForm = (e) => {
    e.preventDefault();
    addEmployeeToServer(employee);
  };

  const addEmployeeToServer = (data) => {
    if (employeeData) {
      axios.put(`${Base_Url}/api/employees/${data.id}`, data).then(
        (response) => {
          console.log(response);
          toast.success("Employee Updated Successfully!", {
            position: "bottom-center",
          });
        },
        (error) => {
          toast.error("Something went Wrong!", {
            position: "bottom-center",
          });
        },
      );
    } else {
      axios.post(`${Base_Url}/api/employees`, data).then(
        (response) => {
          console.log(response);
          toast.success("Employee Added Successfully!", {
            position: "bottom-center",
          });
        },
        (error) => {
          toast.error("Something went Wrong!", {
            position: "bottom-center",
          });
        },
      );
    }
  };

  return (
    <Fragment>
      <ToastContainer />
      <h2>Fill below Details</h2>
      <Form onSubmit={handleForm}>
        <FormGroup>
          <input
            type="text"
            className="form-control"
            placeholder="Employee Name"
            name="name"
            id="name"
            value={employee.name || ""}
            onChange={(e) => {
              setEmployee({ ...employee, name: e.target.value });
            }}
          ></input>
        </FormGroup>
        <FormGroup>
          <input
            type="text"
            className="form-control"
            placeholder="Email"
            name="email"
            id="email"
            value={employee.email || ""}
            onChange={(e) => {
              setEmployee({ ...employee, email: e.target.value });
            }}
          ></input>
        </FormGroup>
        <FormGroup>
          <input
            type="text"
            className="form-control"
            placeholder="Salary"
            name="salary"
            id="salary"
            value={employee.salary || ""}
            onChange={(e) => {
              setEmployee({ ...employee, salary: e.target.value });
            }}
          ></input>
        </FormGroup>
        <FormGroup>
          <input
            type="text"
            className="form-control"
            placeholder="Department Name"
            name="deptName"
            id="deptName"
            value={employee.deptName || ""}
            onChange={(e) => {
              setEmployee({ ...employee, deptName: e.target.value });
            }}
          ></input>
        </FormGroup>
        {employeeData ? (
          <Container className="text-center">
            <Button outline type="submit" color="warning">
              Update Employee
            </Button>
            <Button
              outline
              onClick={() => {
                setEmployee({ name: "", email: "", salary: "", deptName: "" });
              }}
              color="secondary"
              className="ms-3"
            >
              Clear
            </Button>
          </Container>
        ) : (
          <Container className="text-center">
            <Button outline type="submit" color="primary">
              Add Employee
            </Button>
            <Button
              outline
              onClick={() => {
                setEmployee({ name: "", email: "", salary: "", deptName: "" });
              }}
              color="secondary"
              className="ms-3"
            >
              Clear
            </Button>
          </Container>
        )}
      </Form>
    </Fragment>
  );
};

export default AddEmployee;
