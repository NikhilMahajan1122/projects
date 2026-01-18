import axios from "axios";
import {
  Button,
  Container,
  Card,
  CardBody,
  CardText,
  CardSubtitle,
} from "reactstrap";
import Base_Url from "../api/BootApi";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

const Employee = ({ employee, deleted }) => {
  const deleteEmployee = (id) => {
    axios.delete(`${Base_Url}/api/employees/${id}`).then(
      (response) => {
        toast.success("Employee Deleted Successfully!", {
          position: "bottom-center",
        });
        deleted(id);
      },
      (error) => {
        toast.error("Something Went Wrong!", {
          position: "bottom-center",
        });
      },
    );
  };
  const navigate = useNavigate();

  const updateEmployee = (employee) => {
    navigate("/add-employee", { state: employee });
  };

  return (
    <Card className="text-center">
      <CardBody>
        <CardSubtitle style={{ fontWeight: "bold" }}>
          {employee.name} : {employee.deptName}
        </CardSubtitle>
        <CardText>{employee.email}</CardText>
        <Container>
          <Button color="danger" onClick={() => deleteEmployee(employee.id)}>
            Delete
          </Button>
          <Button
            className="ms-2"
            color="warning"
            onClick={() => updateEmployee(employee)}
          >
            Update
          </Button>
        </Container>
      </CardBody>
    </Card>
  );
};

export default Employee;
