import React from "react";
import {
  Card,
  CardBody,
  CardTitle,
  CardText,
  Container,
  Button,
} from "reactstrap";
import "bootstrap/dist/css/bootstrap.min.css"; // Import Bootstrap CSS

const Home = () => {
  return (
    <div>
      <Card className="text-center">
        <CardBody>
          <CardTitle tag="h1">Employee Details</CardTitle>
          <CardText>
            This is developed by Nikhil Mahajan for Performing CRUD operations.
            Its backend is built on Spring Boot and frontend with ReactJS.
          </CardText>
          <Container>
            <Button outline color="primary">
              Start Using
            </Button>
          </Container>
        </CardBody>
      </Card>
    </div>
  );
};

export default Home;
