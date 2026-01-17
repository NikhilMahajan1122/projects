import axios from "axios";
import { Fragment, useState } from "react";
import Base_Url from "../api/BootApi";
import { toast } from "react-toastify";
import { Container, Button, Form, FormGroup } from "reactstrap";

const AddEmployee = () => {
  const [employee, setEmployee] = useState({});

  const handleForm = () => {
    addEmployeeToServer(employee);
  };

  const addEmployeeToServer = (data) => {
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
      }
    );
  };

  return (
    <Fragment>
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
        <Container className="text-center">
          <Button outline type="submit" color="primary">
            Add Employee
          </Button>
          <Button
            outline
            onClick={() => {
              setEmployee({ firstName: "", lastName: "", email: "" });
            }}
            color="secondary"
            className="ms-3"
          >
            Clear
          </Button>
        </Container>
      </Form>
    </Fragment>
  );
};

export default AddEmployee;
