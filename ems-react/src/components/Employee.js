import {
  Button,
  Container,
  Card,
  CardBody,
  CardText,
  CardSubtitle,
} from "reactstrap";

const Employee = ({ employee }) => {
  return (
    <Card className="text-center">
      <CardBody>
        <CardSubtitle style={{ fontWeight: "bold" }}>
          {employee.name} : {employee.deptName}
        </CardSubtitle>
        <CardText>{employee.email}</CardText>
        <Container>
          <Button color="danger">Delete</Button>
          <Button className="ms-2" color="warning">
            Update
          </Button>
        </Container>
      </CardBody>
    </Card>
  );
};

export default Employee;
