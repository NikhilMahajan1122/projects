import { Col, Container, Row } from "reactstrap";
import "./App.css";
import Header from "./components/Header";
import Home from "./components/Home";
import Employee from "./components/Employee";
import { ToastContainer } from "react-toastify";
import AllEmployees from "./components/AllEmployees";
import AddEmployee from "./components/AddEmployee";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Menus from "./components/Menus";
function App() {
  return (
    <div>
      <ToastContainer />
      <Router>
        <Container>
          <Row>
            <Header />
            <Col md={4}>
              <Menus />
            </Col>
            <Col md={8}>
              <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/all-employees" element={<AllEmployees />}></Route>
                <Route path="/add-employee" element={<AddEmployee />}></Route>
              </Routes>
            </Col>
          </Row>
        </Container>
      </Router>
    </div>
  );
}

export default App;
