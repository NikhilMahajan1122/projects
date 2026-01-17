import { Container } from "reactstrap";
import "./App.css";
import Header from "./components/Header";
import Home from "./components/Home";
import Employee from "./components/Employee";
import { ToastContainer } from "react-toastify";
import AllEmployees from "./components/AllEmployees";
import AddEmployee from "./components/AddEmployee";
function App() {
  return (
    <div>
      <ToastContainer />
      <Container>
        <Header />
        <Home />
        <AddEmployee />
        <AllEmployees />
      </Container>
    </div>
  );
}

export default App;
