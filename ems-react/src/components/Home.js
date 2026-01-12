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
          <CardTitle tag="h1">LearnCodeWith Durgesh</CardTitle>
          <CardText>
            This is developed by LearnCodeWith Durgesh for learning purposes.
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
